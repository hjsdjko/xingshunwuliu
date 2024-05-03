package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 货运
 *
 * @author 
 * @email
 */
@TableName("huoyun")
public class HuoyunEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuoyunEntity() {

	}

	public HuoyunEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 客户
     */
    @ColumnInfo(comment="客户",type="int(11)")
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 驾驶员
     */
    @ColumnInfo(comment="驾驶员",type="int(11)")
    @TableField(value = "jiashiyuan_id")

    private Integer jiashiyuanId;


    /**
     * 车辆
     */
    @ColumnInfo(comment="车辆",type="int(11)")
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "huoyun_uuid_number")

    private String huoyunUuidNumber;


    /**
     * 物品标题
     */
    @ColumnInfo(comment="物品标题",type="varchar(200)")
    @TableField(value = "huoyun_name")

    private String huoyunName;


    /**
     * 物品类型
     */
    @ColumnInfo(comment="物品类型",type="int(11)")
    @TableField(value = "wupin_types")

    private Integer wupinTypes;


    /**
     * 货运类型
     */
    @ColumnInfo(comment="货运类型",type="int(11)")
    @TableField(value = "huoyun_types")

    private Integer huoyunTypes;


    /**
     * 物品重量
     */
    @ColumnInfo(comment="物品重量",type="decimal(10,2)")
    @TableField(value = "huoyun_zhongliang")

    private Double huoyunZhongliang;


    /**
     * 物品长
     */
    @ColumnInfo(comment="物品长",type="decimal(10,2)")
    @TableField(value = "huoyun_chang")

    private Double huoyunChang;


    /**
     * 物品宽
     */
    @ColumnInfo(comment="物品宽",type="decimal(10,2)")
    @TableField(value = "huoyun_kuan")

    private Double huoyunKuan;


    /**
     * 物品高
     */
    @ColumnInfo(comment="物品高",type="decimal(10,2)")
    @TableField(value = "huoyun_gao")

    private Double huoyunGao;


    /**
     * 货运金额
     */
    @ColumnInfo(comment="货运金额",type="decimal(10,2)")
    @TableField(value = "huoyun_jine")

    private Double huoyunJine;


    /**
     * 出发地
     */
    @ColumnInfo(comment="出发地",type="varchar(200)")
    @TableField(value = "huoyun_chufadi")

    private String huoyunChufadi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出发时间",type="timestamp")
    @TableField(value = "chufa_time")

    private Date chufaTime;


    /**
     * 途径地
     */
    @ColumnInfo(comment="途径地",type="varchar(200)")
    @TableField(value = "huoyun_tujing")

    private String huoyunTujing;


    /**
     * 抵达地
     */
    @ColumnInfo(comment="抵达地",type="varchar(200)")
    @TableField(value = "huoyun_didadi")

    private String huoyunDidadi;


    /**
     * 送达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="送达时间",type="timestamp")
    @TableField(value = "songda_time")

    private Date songdaTime;


    /**
     * 物品备注
     */
    @ColumnInfo(comment="物品备注",type="longtext")
    @TableField(value = "wupin_content")

    private String wupinContent;


    /**
     * 货运备注
     */
    @ColumnInfo(comment="货运备注",type="longtext")
    @TableField(value = "huoyun_content")

    private String huoyunContent;


    /**
     * 运输状态
     */
    @ColumnInfo(comment="运输状态",type="int(11)")
    @TableField(value = "yushu_types")

    private Integer yushuTypes;


    /**
     * 评价
     */
    @ColumnInfo(comment="评价",type="longtext")
    @TableField(value = "huoyun_pingjia_content")

    private String huoyunPingjiaContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huoyun{" +
            ", id=" + id +
            ", kehuId=" + kehuId +
            ", yuangongId=" + yuangongId +
            ", jiashiyuanId=" + jiashiyuanId +
            ", cheliangId=" + cheliangId +
            ", huoyunUuidNumber=" + huoyunUuidNumber +
            ", huoyunName=" + huoyunName +
            ", wupinTypes=" + wupinTypes +
            ", huoyunTypes=" + huoyunTypes +
            ", huoyunZhongliang=" + huoyunZhongliang +
            ", huoyunChang=" + huoyunChang +
            ", huoyunKuan=" + huoyunKuan +
            ", huoyunGao=" + huoyunGao +
            ", huoyunJine=" + huoyunJine +
            ", huoyunChufadi=" + huoyunChufadi +
            ", chufaTime=" + DateUtil.convertString(chufaTime,"yyyy-MM-dd") +
            ", huoyunTujing=" + huoyunTujing +
            ", huoyunDidadi=" + huoyunDidadi +
            ", songdaTime=" + DateUtil.convertString(songdaTime,"yyyy-MM-dd") +
            ", wupinContent=" + wupinContent +
            ", huoyunContent=" + huoyunContent +
            ", yushuTypes=" + yushuTypes +
            ", huoyunPingjiaContent=" + huoyunPingjiaContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
