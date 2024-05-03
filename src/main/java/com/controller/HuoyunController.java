
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 货运
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huoyun")
public class HuoyunController {
    private static final Logger logger = LoggerFactory.getLogger(HuoyunController.class);

    private static final String TABLE_NAME = "huoyun";

    @Autowired
    private HuoyunService huoyunService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CheliangService cheliangService;//车辆
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//物流资讯
    @Autowired
    private JiashiyuanService jiashiyuanService;//驾驶员
    @Autowired
    private KehuService kehuService;//客户
    @Autowired
    private TongzhiService tongzhiService;//员工通知
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = huoyunService.queryPage(params);

        //字典表数据转换
        List<HuoyunView> list =(List<HuoyunView>)page.getList();
        for(HuoyunView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuoyunEntity huoyun = huoyunService.selectById(id);
        if(huoyun !=null){
            //entity转view
            HuoyunView view = new HuoyunView();
            BeanUtils.copyProperties( huoyun , view );//把实体数据重构到view中
            //级联表 客户
            //级联表
            KehuEntity kehu = kehuService.selectById(huoyun.getKehuId());
            if(kehu != null){
            BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"
, "kehuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setKehuId(kehu.getId());
            }
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(huoyun.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"
, "kehuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 驾驶员
            //级联表
            JiashiyuanEntity jiashiyuan = jiashiyuanService.selectById(huoyun.getJiashiyuanId());
            if(jiashiyuan != null){
            BeanUtils.copyProperties( jiashiyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"
, "kehuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiashiyuanId(jiashiyuan.getId());
            }
            //级联表 车辆
            //级联表
            CheliangEntity cheliang = cheliangService.selectById(huoyun.getCheliangId());
            if(cheliang != null){
            BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"
, "kehuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setCheliangId(cheliang.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuoyunEntity huoyun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huoyun:{}",this.getClass().getName(),huoyun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role)){
            huoyun.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            huoyun.setYushuTypes(1);
        }
        else if("客户".equals(role)){
            huoyun.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            huoyun.setYushuTypes(5);
        }

        Wrapper<HuoyunEntity> queryWrapper = new EntityWrapper<HuoyunEntity>()
            .eq("kehu_id", huoyun.getKehuId())
            .eq("yuangong_id", huoyun.getYuangongId())
            .eq("jiashiyuan_id", huoyun.getJiashiyuanId())
            .eq("cheliang_id", huoyun.getCheliangId())
            .eq("huoyun_name", huoyun.getHuoyunName())
            .eq("wupin_types", huoyun.getWupinTypes())
            .eq("huoyun_types", huoyun.getHuoyunTypes())
            .eq("huoyun_chufadi", huoyun.getHuoyunChufadi())
            .eq("huoyun_tujing", huoyun.getHuoyunTujing())
            .eq("huoyun_didadi", huoyun.getHuoyunDidadi())
            .eq("yushu_types", huoyun.getYushuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoyunEntity huoyunEntity = huoyunService.selectOne(queryWrapper);
        if(huoyunEntity==null){
            KehuEntity kehuEntity = kehuService.selectById(huoyun.getKehuId());
            if(kehuEntity == null)
                return R.error("查不到客户");

            double balance = kehuEntity.getNewMoney() - huoyun.getHuoyunJine();
            if(balance<0)
                return R.error("客户账户不足以支付金额,请让客户充值后再添加运单");
            kehuEntity.setNewMoney(balance);
            kehuService.updateById(kehuEntity);


            huoyun.setInsertTime(new Date());
            huoyun.setCreateTime(new Date());
            huoyunService.insert(huoyun);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuoyunEntity huoyun, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huoyun:{}",this.getClass().getName(),huoyun.toString());
        HuoyunEntity oldHuoyunEntity = huoyunService.selectById(huoyun.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            huoyun.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("客户".equals(role)){
            huoyun.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            huoyun.setYushuTypes(5);
        }
            huoyunService.updateById(huoyun);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuoyunEntity> oldHuoyunList =huoyunService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        huoyunService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yuangongId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuoyunEntity> huoyunList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuoyunEntity huoyunEntity = new HuoyunEntity();
//                            huoyunEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            huoyunEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            huoyunEntity.setJiashiyuanId(Integer.valueOf(data.get(0)));   //驾驶员 要改的
//                            huoyunEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            huoyunEntity.setHuoyunUuidNumber(data.get(0));                    //订单编号 要改的
//                            huoyunEntity.setHuoyunName(data.get(0));                    //物品标题 要改的
//                            huoyunEntity.setWupinTypes(Integer.valueOf(data.get(0)));   //物品类型 要改的
//                            huoyunEntity.setHuoyunTypes(Integer.valueOf(data.get(0)));   //货运类型 要改的
//                            huoyunEntity.setHuoyunZhongliang(data.get(0));                    //物品重量 要改的
//                            huoyunEntity.setHuoyunChang(data.get(0));                    //物品长 要改的
//                            huoyunEntity.setHuoyunKuan(data.get(0));                    //物品宽 要改的
//                            huoyunEntity.setHuoyunGao(data.get(0));                    //物品高 要改的
//                            huoyunEntity.setHuoyunJine(data.get(0));                    //货运金额 要改的
//                            huoyunEntity.setHuoyunChufadi(data.get(0));                    //出发地 要改的
//                            huoyunEntity.setChufaTime(sdf.parse(data.get(0)));          //出发时间 要改的
//                            huoyunEntity.setHuoyunTujing(data.get(0));                    //途径地 要改的
//                            huoyunEntity.setHuoyunDidadi(data.get(0));                    //抵达地 要改的
//                            huoyunEntity.setSongdaTime(sdf.parse(data.get(0)));          //送达时间 要改的
//                            huoyunEntity.setWupinContent("");//详情和图片
//                            huoyunEntity.setHuoyunContent("");//详情和图片
//                            huoyunEntity.setYushuTypes(Integer.valueOf(data.get(0)));   //运输状态 要改的
//                            huoyunEntity.setHuoyunPingjiaContent("");//详情和图片
//                            huoyunEntity.setInsertTime(date);//时间
//                            huoyunEntity.setCreateTime(date);//时间
                            huoyunList.add(huoyunEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("huoyunUuidNumber")){
                                    List<String> huoyunUuidNumber = seachFields.get("huoyunUuidNumber");
                                    huoyunUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huoyunUuidNumber = new ArrayList<>();
                                    huoyunUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huoyunUuidNumber",huoyunUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<HuoyunEntity> huoyunEntities_huoyunUuidNumber = huoyunService.selectList(new EntityWrapper<HuoyunEntity>().in("huoyun_uuid_number", seachFields.get("huoyunUuidNumber")));
                        if(huoyunEntities_huoyunUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuoyunEntity s:huoyunEntities_huoyunUuidNumber){
                                repeatFields.add(s.getHuoyunUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huoyunService.insertBatch(huoyunList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

