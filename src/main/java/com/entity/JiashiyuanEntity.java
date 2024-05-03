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
 * 驾驶员
 *
 * @author 
 * @email
 */
@TableName("jiashiyuan")
public class JiashiyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiashiyuanEntity() {

	}

	public JiashiyuanEntity(T t) {
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
     * 驾驶员姓名
     */
    @ColumnInfo(comment="驾驶员姓名",type="varchar(200)")
    @TableField(value = "jiashiyuan_name")

    private String jiashiyuanName;


    /**
     * 驾驶员手机号
     */
    @ColumnInfo(comment="驾驶员手机号",type="varchar(200)")
    @TableField(value = "jiashiyuan_phone")

    private String jiashiyuanPhone;


    /**
     * 驾驶员身份证号
     */
    @ColumnInfo(comment="驾驶员身份证号",type="varchar(200)")
    @TableField(value = "jiashiyuan_id_number")

    private String jiashiyuanIdNumber;


    /**
     * 驾驶员照片
     */
    @ColumnInfo(comment="驾驶员照片",type="varchar(200)")
    @TableField(value = "jiashiyuan_photo")

    private String jiashiyuanPhoto;


    /**
     * 驾照照片
     */
    @ColumnInfo(comment="驾照照片",type="varchar(200)")
    @TableField(value = "jiashiyuan_jiazhao_photo")

    private String jiashiyuanJiazhaoPhoto;


    /**
     * 驾龄
     */
    @ColumnInfo(comment="驾龄",type="varchar(200)")
    @TableField(value = "jiashiyuan_jialing")

    private String jiashiyuanJialing;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 驾驶员邮箱
     */
    @ColumnInfo(comment="驾驶员邮箱",type="varchar(200)")
    @TableField(value = "jiashiyuan_email")

    private String jiashiyuanEmail;


    /**
     * 驾驶员介绍
     */
    @ColumnInfo(comment="驾驶员介绍",type="longtext")
    @TableField(value = "jiashiyuan_content")

    private String jiashiyuanContent;


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
	 * 获取：驾驶员姓名
	 */
    public String getJiashiyuanName() {
        return jiashiyuanName;
    }
    /**
	 * 设置：驾驶员姓名
	 */

    public void setJiashiyuanName(String jiashiyuanName) {
        this.jiashiyuanName = jiashiyuanName;
    }
    /**
	 * 获取：驾驶员手机号
	 */
    public String getJiashiyuanPhone() {
        return jiashiyuanPhone;
    }
    /**
	 * 设置：驾驶员手机号
	 */

    public void setJiashiyuanPhone(String jiashiyuanPhone) {
        this.jiashiyuanPhone = jiashiyuanPhone;
    }
    /**
	 * 获取：驾驶员身份证号
	 */
    public String getJiashiyuanIdNumber() {
        return jiashiyuanIdNumber;
    }
    /**
	 * 设置：驾驶员身份证号
	 */

    public void setJiashiyuanIdNumber(String jiashiyuanIdNumber) {
        this.jiashiyuanIdNumber = jiashiyuanIdNumber;
    }
    /**
	 * 获取：驾驶员照片
	 */
    public String getJiashiyuanPhoto() {
        return jiashiyuanPhoto;
    }
    /**
	 * 设置：驾驶员照片
	 */

    public void setJiashiyuanPhoto(String jiashiyuanPhoto) {
        this.jiashiyuanPhoto = jiashiyuanPhoto;
    }
    /**
	 * 获取：驾照照片
	 */
    public String getJiashiyuanJiazhaoPhoto() {
        return jiashiyuanJiazhaoPhoto;
    }
    /**
	 * 设置：驾照照片
	 */

    public void setJiashiyuanJiazhaoPhoto(String jiashiyuanJiazhaoPhoto) {
        this.jiashiyuanJiazhaoPhoto = jiashiyuanJiazhaoPhoto;
    }
    /**
	 * 获取：驾龄
	 */
    public String getJiashiyuanJialing() {
        return jiashiyuanJialing;
    }
    /**
	 * 设置：驾龄
	 */

    public void setJiashiyuanJialing(String jiashiyuanJialing) {
        this.jiashiyuanJialing = jiashiyuanJialing;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：驾驶员邮箱
	 */
    public String getJiashiyuanEmail() {
        return jiashiyuanEmail;
    }
    /**
	 * 设置：驾驶员邮箱
	 */

    public void setJiashiyuanEmail(String jiashiyuanEmail) {
        this.jiashiyuanEmail = jiashiyuanEmail;
    }
    /**
	 * 获取：驾驶员介绍
	 */
    public String getJiashiyuanContent() {
        return jiashiyuanContent;
    }
    /**
	 * 设置：驾驶员介绍
	 */

    public void setJiashiyuanContent(String jiashiyuanContent) {
        this.jiashiyuanContent = jiashiyuanContent;
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
        return "Jiashiyuan{" +
            ", id=" + id +
            ", jiashiyuanName=" + jiashiyuanName +
            ", jiashiyuanPhone=" + jiashiyuanPhone +
            ", jiashiyuanIdNumber=" + jiashiyuanIdNumber +
            ", jiashiyuanPhoto=" + jiashiyuanPhoto +
            ", jiashiyuanJiazhaoPhoto=" + jiashiyuanJiazhaoPhoto +
            ", jiashiyuanJialing=" + jiashiyuanJialing +
            ", sexTypes=" + sexTypes +
            ", jiashiyuanEmail=" + jiashiyuanEmail +
            ", jiashiyuanContent=" + jiashiyuanContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
