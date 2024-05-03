package com.entity.vo;

import com.entity.HuoyunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 货运
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huoyun")
public class HuoyunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 驾驶员
     */

    @TableField(value = "jiashiyuan_id")
    private Integer jiashiyuanId;


    /**
     * 车辆
     */

    @TableField(value = "cheliang_id")
    private Integer cheliangId;


    /**
     * 订单编号
     */

    @TableField(value = "huoyun_uuid_number")
    private String huoyunUuidNumber;


    /**
     * 物品标题
     */

    @TableField(value = "huoyun_name")
    private String huoyunName;


    /**
     * 物品类型
     */

    @TableField(value = "wupin_types")
    private Integer wupinTypes;


    /**
     * 货运类型
     */

    @TableField(value = "huoyun_types")
    private Integer huoyunTypes;


    /**
     * 物品重量
     */

    @TableField(value = "huoyun_zhongliang")
    private Double huoyunZhongliang;


    /**
     * 物品长
     */

    @TableField(value = "huoyun_chang")
    private Double huoyunChang;


    /**
     * 物品宽
     */

    @TableField(value = "huoyun_kuan")
    private Double huoyunKuan;


    /**
     * 物品高
     */

    @TableField(value = "huoyun_gao")
    private Double huoyunGao;


    /**
     * 货运金额
     */

    @TableField(value = "huoyun_jine")
    private Double huoyunJine;


    /**
     * 出发地
     */

    @TableField(value = "huoyun_chufadi")
    private String huoyunChufadi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chufa_time")
    private Date chufaTime;


    /**
     * 途径地
     */

    @TableField(value = "huoyun_tujing")
    private String huoyunTujing;


    /**
     * 抵达地
     */

    @TableField(value = "huoyun_didadi")
    private String huoyunDidadi;


    /**
     * 送达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "songda_time")
    private Date songdaTime;


    /**
     * 物品备注
     */

    @TableField(value = "wupin_content")
    private String wupinContent;


    /**
     * 货运备注
     */

    @TableField(value = "huoyun_content")
    private String huoyunContent;


    /**
     * 运输状态
     */

    @TableField(value = "yushu_types")
    private Integer yushuTypes;


    /**
     * 评价
     */

    @TableField(value = "huoyun_pingjia_content")
    private String huoyunPingjiaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：驾驶员
	 */
    public Integer getJiashiyuanId() {
        return jiashiyuanId;
    }


    /**
	 * 获取：驾驶员
	 */

    public void setJiashiyuanId(Integer jiashiyuanId) {
        this.jiashiyuanId = jiashiyuanId;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：订单编号
	 */
    public String getHuoyunUuidNumber() {
        return huoyunUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setHuoyunUuidNumber(String huoyunUuidNumber) {
        this.huoyunUuidNumber = huoyunUuidNumber;
    }
    /**
	 * 设置：物品标题
	 */
    public String getHuoyunName() {
        return huoyunName;
    }


    /**
	 * 获取：物品标题
	 */

    public void setHuoyunName(String huoyunName) {
        this.huoyunName = huoyunName;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getWupinTypes() {
        return wupinTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setWupinTypes(Integer wupinTypes) {
        this.wupinTypes = wupinTypes;
    }
    /**
	 * 设置：货运类型
	 */
    public Integer getHuoyunTypes() {
        return huoyunTypes;
    }


    /**
	 * 获取：货运类型
	 */

    public void setHuoyunTypes(Integer huoyunTypes) {
        this.huoyunTypes = huoyunTypes;
    }
    /**
	 * 设置：物品重量
	 */
    public Double getHuoyunZhongliang() {
        return huoyunZhongliang;
    }


    /**
	 * 获取：物品重量
	 */

    public void setHuoyunZhongliang(Double huoyunZhongliang) {
        this.huoyunZhongliang = huoyunZhongliang;
    }
    /**
	 * 设置：物品长
	 */
    public Double getHuoyunChang() {
        return huoyunChang;
    }


    /**
	 * 获取：物品长
	 */

    public void setHuoyunChang(Double huoyunChang) {
        this.huoyunChang = huoyunChang;
    }
    /**
	 * 设置：物品宽
	 */
    public Double getHuoyunKuan() {
        return huoyunKuan;
    }


    /**
	 * 获取：物品宽
	 */

    public void setHuoyunKuan(Double huoyunKuan) {
        this.huoyunKuan = huoyunKuan;
    }
    /**
	 * 设置：物品高
	 */
    public Double getHuoyunGao() {
        return huoyunGao;
    }


    /**
	 * 获取：物品高
	 */

    public void setHuoyunGao(Double huoyunGao) {
        this.huoyunGao = huoyunGao;
    }
    /**
	 * 设置：货运金额
	 */
    public Double getHuoyunJine() {
        return huoyunJine;
    }


    /**
	 * 获取：货运金额
	 */

    public void setHuoyunJine(Double huoyunJine) {
        this.huoyunJine = huoyunJine;
    }
    /**
	 * 设置：出发地
	 */
    public String getHuoyunChufadi() {
        return huoyunChufadi;
    }


    /**
	 * 获取：出发地
	 */

    public void setHuoyunChufadi(String huoyunChufadi) {
        this.huoyunChufadi = huoyunChufadi;
    }
    /**
	 * 设置：出发时间
	 */
    public Date getChufaTime() {
        return chufaTime;
    }


    /**
	 * 获取：出发时间
	 */

    public void setChufaTime(Date chufaTime) {
        this.chufaTime = chufaTime;
    }
    /**
	 * 设置：途径地
	 */
    public String getHuoyunTujing() {
        return huoyunTujing;
    }


    /**
	 * 获取：途径地
	 */

    public void setHuoyunTujing(String huoyunTujing) {
        this.huoyunTujing = huoyunTujing;
    }
    /**
	 * 设置：抵达地
	 */
    public String getHuoyunDidadi() {
        return huoyunDidadi;
    }


    /**
	 * 获取：抵达地
	 */

    public void setHuoyunDidadi(String huoyunDidadi) {
        this.huoyunDidadi = huoyunDidadi;
    }
    /**
	 * 设置：送达时间
	 */
    public Date getSongdaTime() {
        return songdaTime;
    }


    /**
	 * 获取：送达时间
	 */

    public void setSongdaTime(Date songdaTime) {
        this.songdaTime = songdaTime;
    }
    /**
	 * 设置：物品备注
	 */
    public String getWupinContent() {
        return wupinContent;
    }


    /**
	 * 获取：物品备注
	 */

    public void setWupinContent(String wupinContent) {
        this.wupinContent = wupinContent;
    }
    /**
	 * 设置：货运备注
	 */
    public String getHuoyunContent() {
        return huoyunContent;
    }


    /**
	 * 获取：货运备注
	 */

    public void setHuoyunContent(String huoyunContent) {
        this.huoyunContent = huoyunContent;
    }
    /**
	 * 设置：运输状态
	 */
    public Integer getYushuTypes() {
        return yushuTypes;
    }


    /**
	 * 获取：运输状态
	 */

    public void setYushuTypes(Integer yushuTypes) {
        this.yushuTypes = yushuTypes;
    }
    /**
	 * 设置：评价
	 */
    public String getHuoyunPingjiaContent() {
        return huoyunPingjiaContent;
    }


    /**
	 * 获取：评价
	 */

    public void setHuoyunPingjiaContent(String huoyunPingjiaContent) {
        this.huoyunPingjiaContent = huoyunPingjiaContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
