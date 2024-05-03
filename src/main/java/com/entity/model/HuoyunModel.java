package com.entity.model;

import com.entity.HuoyunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 货运
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuoyunModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 驾驶员
     */
    private Integer jiashiyuanId;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 订单编号
     */
    private String huoyunUuidNumber;


    /**
     * 物品标题
     */
    private String huoyunName;


    /**
     * 物品类型
     */
    private Integer wupinTypes;


    /**
     * 货运类型
     */
    private Integer huoyunTypes;


    /**
     * 物品重量
     */
    private Double huoyunZhongliang;


    /**
     * 物品长
     */
    private Double huoyunChang;


    /**
     * 物品宽
     */
    private Double huoyunKuan;


    /**
     * 物品高
     */
    private Double huoyunGao;


    /**
     * 货运金额
     */
    private Double huoyunJine;


    /**
     * 出发地
     */
    private String huoyunChufadi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chufaTime;


    /**
     * 途径地
     */
    private String huoyunTujing;


    /**
     * 抵达地
     */
    private String huoyunDidadi;


    /**
     * 送达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date songdaTime;


    /**
     * 物品备注
     */
    private String wupinContent;


    /**
     * 货运备注
     */
    private String huoyunContent;


    /**
     * 运输状态
     */
    private Integer yushuTypes;


    /**
     * 评价
     */
    private String huoyunPingjiaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：驾驶员
	 */
    public Integer getJiashiyuanId() {
        return jiashiyuanId;
    }


    /**
	 * 设置：驾驶员
	 */
    public void setJiashiyuanId(Integer jiashiyuanId) {
        this.jiashiyuanId = jiashiyuanId;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：订单编号
	 */
    public String getHuoyunUuidNumber() {
        return huoyunUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setHuoyunUuidNumber(String huoyunUuidNumber) {
        this.huoyunUuidNumber = huoyunUuidNumber;
    }
    /**
	 * 获取：物品标题
	 */
    public String getHuoyunName() {
        return huoyunName;
    }


    /**
	 * 设置：物品标题
	 */
    public void setHuoyunName(String huoyunName) {
        this.huoyunName = huoyunName;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 获取：货运类型
	 */
    public Integer getHuoyunTypes() {
        return huoyunTypes;
    }


    /**
	 * 设置：货运类型
	 */
    public void setHuoyunTypes(Integer huoyunTypes) {
        this.huoyunTypes = huoyunTypes;
    }
    /**
	 * 获取：物品重量
	 */
    public Double getHuoyunZhongliang() {
        return huoyunZhongliang;
    }


    /**
	 * 设置：物品重量
	 */
    public void setHuoyunZhongliang(Double huoyunZhongliang) {
        this.huoyunZhongliang = huoyunZhongliang;
    }
    /**
	 * 获取：物品长
	 */
    public Double getHuoyunChang() {
        return huoyunChang;
    }


    /**
	 * 设置：物品长
	 */
    public void setHuoyunChang(Double huoyunChang) {
        this.huoyunChang = huoyunChang;
    }
    /**
	 * 获取：物品宽
	 */
    public Double getHuoyunKuan() {
        return huoyunKuan;
    }


    /**
	 * 设置：物品宽
	 */
    public void setHuoyunKuan(Double huoyunKuan) {
        this.huoyunKuan = huoyunKuan;
    }
    /**
	 * 获取：物品高
	 */
    public Double getHuoyunGao() {
        return huoyunGao;
    }


    /**
	 * 设置：物品高
	 */
    public void setHuoyunGao(Double huoyunGao) {
        this.huoyunGao = huoyunGao;
    }
    /**
	 * 获取：货运金额
	 */
    public Double getHuoyunJine() {
        return huoyunJine;
    }


    /**
	 * 设置：货运金额
	 */
    public void setHuoyunJine(Double huoyunJine) {
        this.huoyunJine = huoyunJine;
    }
    /**
	 * 获取：出发地
	 */
    public String getHuoyunChufadi() {
        return huoyunChufadi;
    }


    /**
	 * 设置：出发地
	 */
    public void setHuoyunChufadi(String huoyunChufadi) {
        this.huoyunChufadi = huoyunChufadi;
    }
    /**
	 * 获取：出发时间
	 */
    public Date getChufaTime() {
        return chufaTime;
    }


    /**
	 * 设置：出发时间
	 */
    public void setChufaTime(Date chufaTime) {
        this.chufaTime = chufaTime;
    }
    /**
	 * 获取：途径地
	 */
    public String getHuoyunTujing() {
        return huoyunTujing;
    }


    /**
	 * 设置：途径地
	 */
    public void setHuoyunTujing(String huoyunTujing) {
        this.huoyunTujing = huoyunTujing;
    }
    /**
	 * 获取：抵达地
	 */
    public String getHuoyunDidadi() {
        return huoyunDidadi;
    }


    /**
	 * 设置：抵达地
	 */
    public void setHuoyunDidadi(String huoyunDidadi) {
        this.huoyunDidadi = huoyunDidadi;
    }
    /**
	 * 获取：送达时间
	 */
    public Date getSongdaTime() {
        return songdaTime;
    }


    /**
	 * 设置：送达时间
	 */
    public void setSongdaTime(Date songdaTime) {
        this.songdaTime = songdaTime;
    }
    /**
	 * 获取：物品备注
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 设置：物品备注
	 */
    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 获取：货运备注
	 */
    public String getHuoyunContent() {
        return huoyunContent;
    }


    /**
	 * 设置：货运备注
	 */
    public void setHuoyunContent(String huoyunContent) {
        this.huoyunContent = huoyunContent;
    }
    /**
	 * 获取：运输状态
	 */
    public Integer getYushuTypes() {
        return yushuTypes;
    }


    /**
	 * 设置：运输状态
	 */
    public void setYushuTypes(Integer yushuTypes) {
        this.yushuTypes = yushuTypes;
    }
    /**
	 * 获取：评价
	 */
    public String getHuoyunPingjiaContent() {
        return huoyunPingjiaContent;
    }


    /**
	 * 设置：评价
	 */
    public void setHuoyunPingjiaContent(String huoyunPingjiaContent) {
        this.huoyunPingjiaContent = huoyunPingjiaContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
