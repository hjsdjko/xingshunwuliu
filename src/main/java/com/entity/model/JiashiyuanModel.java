package com.entity.model;

import com.entity.JiashiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 驾驶员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiashiyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 驾驶员姓名
     */
    private String jiashiyuanName;


    /**
     * 驾驶员手机号
     */
    private String jiashiyuanPhone;


    /**
     * 驾驶员身份证号
     */
    private String jiashiyuanIdNumber;


    /**
     * 驾驶员照片
     */
    private String jiashiyuanPhoto;


    /**
     * 驾照照片
     */
    private String jiashiyuanJiazhaoPhoto;


    /**
     * 驾龄
     */
    private String jiashiyuanJialing;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 驾驶员邮箱
     */
    private String jiashiyuanEmail;


    /**
     * 驾驶员介绍
     */
    private String jiashiyuanContent;


    /**
     * 创建时间
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

    }
