
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
 * 驾驶员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiashiyuan")
public class JiashiyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiashiyuanController.class);

    private static final String TABLE_NAME = "jiashiyuan";

    @Autowired
    private JiashiyuanService jiashiyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CheliangService cheliangService;//车辆
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//物流资讯
    @Autowired
    private HuoyunService huoyunService;//货运
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
        PageUtils page = jiashiyuanService.queryPage(params);

        //字典表数据转换
        List<JiashiyuanView> list =(List<JiashiyuanView>)page.getList();
        for(JiashiyuanView c:list){
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
        JiashiyuanEntity jiashiyuan = jiashiyuanService.selectById(id);
        if(jiashiyuan !=null){
            //entity转view
            JiashiyuanView view = new JiashiyuanView();
            BeanUtils.copyProperties( jiashiyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiashiyuanEntity jiashiyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiashiyuan:{}",this.getClass().getName(),jiashiyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiashiyuanEntity> queryWrapper = new EntityWrapper<JiashiyuanEntity>()
            .eq("jiashiyuan_name", jiashiyuan.getJiashiyuanName())
            .eq("jiashiyuan_phone", jiashiyuan.getJiashiyuanPhone())
            .eq("jiashiyuan_id_number", jiashiyuan.getJiashiyuanIdNumber())
            .eq("jiashiyuan_jialing", jiashiyuan.getJiashiyuanJialing())
            .eq("sex_types", jiashiyuan.getSexTypes())
            .eq("jiashiyuan_email", jiashiyuan.getJiashiyuanEmail())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashiyuanEntity jiashiyuanEntity = jiashiyuanService.selectOne(queryWrapper);
        if(jiashiyuanEntity==null){
            jiashiyuan.setCreateTime(new Date());
            jiashiyuanService.insert(jiashiyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiashiyuanEntity jiashiyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiashiyuan:{}",this.getClass().getName(),jiashiyuan.toString());
        JiashiyuanEntity oldJiashiyuanEntity = jiashiyuanService.selectById(jiashiyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiashiyuan.getJiashiyuanPhoto()) || "null".equals(jiashiyuan.getJiashiyuanPhoto())){
                jiashiyuan.setJiashiyuanPhoto(null);
        }
        if("".equals(jiashiyuan.getJiashiyuanJiazhaoPhoto()) || "null".equals(jiashiyuan.getJiashiyuanJiazhaoPhoto())){
                jiashiyuan.setJiashiyuanJiazhaoPhoto(null);
        }

            jiashiyuanService.updateById(jiashiyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiashiyuanEntity> oldJiashiyuanList =jiashiyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiashiyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiashiyuanEntity> jiashiyuanList = new ArrayList<>();//上传的东西
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
                            JiashiyuanEntity jiashiyuanEntity = new JiashiyuanEntity();
//                            jiashiyuanEntity.setJiashiyuanName(data.get(0));                    //驾驶员姓名 要改的
//                            jiashiyuanEntity.setJiashiyuanPhone(data.get(0));                    //驾驶员手机号 要改的
//                            jiashiyuanEntity.setJiashiyuanIdNumber(data.get(0));                    //驾驶员身份证号 要改的
//                            jiashiyuanEntity.setJiashiyuanPhoto("");//详情和图片
//                            jiashiyuanEntity.setJiashiyuanJiazhaoPhoto("");//详情和图片
//                            jiashiyuanEntity.setJiashiyuanJialing(data.get(0));                    //驾龄 要改的
//                            jiashiyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiashiyuanEntity.setJiashiyuanEmail(data.get(0));                    //驾驶员邮箱 要改的
//                            jiashiyuanEntity.setJiashiyuanContent("");//详情和图片
//                            jiashiyuanEntity.setCreateTime(date);//时间
                            jiashiyuanList.add(jiashiyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //驾驶员手机号
                                if(seachFields.containsKey("jiashiyuanPhone")){
                                    List<String> jiashiyuanPhone = seachFields.get("jiashiyuanPhone");
                                    jiashiyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiashiyuanPhone = new ArrayList<>();
                                    jiashiyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("jiashiyuanPhone",jiashiyuanPhone);
                                }
                                //驾驶员身份证号
                                if(seachFields.containsKey("jiashiyuanIdNumber")){
                                    List<String> jiashiyuanIdNumber = seachFields.get("jiashiyuanIdNumber");
                                    jiashiyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiashiyuanIdNumber = new ArrayList<>();
                                    jiashiyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("jiashiyuanIdNumber",jiashiyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //驾驶员手机号
                        List<JiashiyuanEntity> jiashiyuanEntities_jiashiyuanPhone = jiashiyuanService.selectList(new EntityWrapper<JiashiyuanEntity>().in("jiashiyuan_phone", seachFields.get("jiashiyuanPhone")));
                        if(jiashiyuanEntities_jiashiyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashiyuanEntity s:jiashiyuanEntities_jiashiyuanPhone){
                                repeatFields.add(s.getJiashiyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [驾驶员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //驾驶员身份证号
                        List<JiashiyuanEntity> jiashiyuanEntities_jiashiyuanIdNumber = jiashiyuanService.selectList(new EntityWrapper<JiashiyuanEntity>().in("jiashiyuan_id_number", seachFields.get("jiashiyuanIdNumber")));
                        if(jiashiyuanEntities_jiashiyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiashiyuanEntity s:jiashiyuanEntities_jiashiyuanIdNumber){
                                repeatFields.add(s.getJiashiyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [驾驶员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiashiyuanService.insertBatch(jiashiyuanList);
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

