package com.entity.vo;

import com.entity.JiashiyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 驾驶员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiashiyuan")
public class JiashiyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 驾驶员姓名
     */

    @TableField(value = "jiashiyuan_name")
    private String jiashiyuanName;


    /**
     * 驾驶员手机号
     */

    @TableField(value = "jiashiyuan_phone")
    private String jiashiyuanPhone;


    /**
     * 驾驶员身份证号
     */

    @TableField(value = "jiashiyuan_id_number")
    private String jiashiyuanIdNumber;


    /**
     * 驾驶员照片
     */

    @TableField(value = "jiashiyuan_photo")
    private String jiashiyuanPhoto;


    /**
     * 驾照照片
     */

    @TableField(value = "jiashiyuan_jiazhao_photo")
    private String jiashiyuanJiazhaoPhoto;


    /**
     * 驾龄
     */

    @TableField(value = "jiashiyuan_jialing")
    private String jiashiyuanJialing;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 驾驶员邮箱
     */

    @TableField(value = "jiashiyuan_email")
    private String jiashiyuanEmail;


    /**
     * 驾驶员介绍
     */

    @TableField(value = "jiashiyuan_content")
    private String jiashiyuanContent;


    /**
     * 创建时间
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
	 * 设置：驾驶员姓名
	 */
    public String getJiashiyuanName() {
        return jiashiyuanName;
    }


    /**
	 * 获取：驾驶员姓名
	 */

    public void setJiashiyuanName(String jiashiyuanName) {
        this.jiashiyuanName = jiashiyuanName;
    }
    /**
	 * 设置：驾驶员手机号
	 */
    public String getJiashiyuanPhone() {
        return jiashiyuanPhone;
    }


    /**
	 * 获取：驾驶员手机号
	 */

    public void setJiashiyuanPhone(String jiashiyuanPhone) {
        this.jiashiyuanPhone = jiashiyuanPhone;
    }
    /**
	 * 设置：驾驶员身份证号
	 */
    public String getJiashiyuanIdNumber() {
        return jiashiyuanIdNumber;
    }


    /**
	 * 获取：驾驶员身份证号
	 */

    public void setJiashiyuanIdNumber(String jiashiyuanIdNumber) {
        this.jiashiyuanIdNumber = jiashiyuanIdNumber;
    }
    /**
	 * 设置：驾驶员照片
	 */
    public String getJiashiyuanPhoto() {
        return jiashiyuanPhoto;
    }


    /**
	 * 获取：驾驶员照片
	 */

    public void setJiashiyuanPhoto(String jiashiyuanPhoto) {
        this.jiashiyuanPhoto = jiashiyuanPhoto;
    }
    /**
	 * 设置：驾照照片
	 */
    public String getJiashiyuanJiazhaoPhoto() {
        return jiashiyuanJiazhaoPhoto;
    }


    /**
	 * 获取：驾照照片
	 */

    public void setJiashiyuanJiazhaoPhoto(String jiashiyuanJiazhaoPhoto) {
        this.jiashiyuanJiazhaoPhoto = jiashiyuanJiazhaoPhoto;
    }
    /**
	 * 设置：驾龄
	 */
    public String getJiashiyuanJialing() {
        return jiashiyuanJialing;
    }


    /**
	 * 获取：驾龄
	 */

    public void setJiashiyuanJialing(String jiashiyuanJialing) {
        this.jiashiyuanJialing = jiashiyuanJialing;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：驾驶员邮箱
	 */
    public String getJiashiyuanEmail() {
        return jiashiyuanEmail;
    }


    /**
	 * 获取：驾驶员邮箱
	 */

    public void setJiashiyuanEmail(String jiashiyuanEmail) {
        this.jiashiyuanEmail = jiashiyuanEmail;
    }
    /**
	 * 设置：驾驶员介绍
	 */
    public String getJiashiyuanContent() {
        return jiashiyuanContent;
    }


    /**
	 * 获取：驾驶员介绍
	 */

    public void setJiashiyuanContent(String jiashiyuanContent) {
        this.jiashiyuanContent = jiashiyuanContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
