package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuoyunEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 货运
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huoyun")
public class HuoyunView extends HuoyunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物品类型的值
	*/
	@ColumnInfo(comment="物品类型的字典表值",type="varchar(200)")
	private String wupinValue;
	/**
	* 货运类型的值
	*/
	@ColumnInfo(comment="货运类型的字典表值",type="varchar(200)")
	private String huoyunValue;
	/**
	* 运输状态的值
	*/
	@ColumnInfo(comment="运输状态的字典表值",type="varchar(200)")
	private String yushuValue;

	//级联表 车辆
		/**
		* 车辆名称
		*/

		@ColumnInfo(comment="车辆名称",type="varchar(200)")
		private String cheliangName;
		/**
		* 车辆编号
		*/

		@ColumnInfo(comment="车辆编号",type="varchar(200)")
		private String cheliangUuidNumber;
		/**
		* 车辆照片
		*/

		@ColumnInfo(comment="车辆照片",type="varchar(200)")
		private String cheliangPhoto;
		/**
		* 车辆颜色
		*/

		@ColumnInfo(comment="车辆颜色",type="varchar(200)")
		private String cheliangYanse;
		/**
		* 车牌号
		*/

		@ColumnInfo(comment="车牌号",type="varchar(200)")
		private String cheliangChepaihao;
		/**
		* 车辆类型
		*/
		@ColumnInfo(comment="车辆类型",type="int(11)")
		private Integer cheliangTypes;
			/**
			* 车辆类型的值
			*/
			@ColumnInfo(comment="车辆类型的字典表值",type="varchar(200)")
			private String cheliangValue;
		/**
		* 车辆介绍
		*/

		@ColumnInfo(comment="车辆介绍",type="longtext")
		private String cheliangContent;
	//级联表 驾驶员
		/**
		* 驾驶员姓名
		*/

		@ColumnInfo(comment="驾驶员姓名",type="varchar(200)")
		private String jiashiyuanName;
		/**
		* 驾驶员手机号
		*/

		@ColumnInfo(comment="驾驶员手机号",type="varchar(200)")
		private String jiashiyuanPhone;
		/**
		* 驾驶员身份证号
		*/

		@ColumnInfo(comment="驾驶员身份证号",type="varchar(200)")
		private String jiashiyuanIdNumber;
		/**
		* 驾驶员照片
		*/

		@ColumnInfo(comment="驾驶员照片",type="varchar(200)")
		private String jiashiyuanPhoto;
		/**
		* 驾照照片
		*/

		@ColumnInfo(comment="驾照照片",type="varchar(200)")
		private String jiashiyuanJiazhaoPhoto;
		/**
		* 驾龄
		*/

		@ColumnInfo(comment="驾龄",type="varchar(200)")
		private String jiashiyuanJialing;
		/**
		* 驾驶员邮箱
		*/

		@ColumnInfo(comment="驾驶员邮箱",type="varchar(200)")
		private String jiashiyuanEmail;
		/**
		* 驾驶员介绍
		*/

		@ColumnInfo(comment="驾驶员介绍",type="longtext")
		private String jiashiyuanContent;
	//级联表 客户
		/**
		* 客户姓名
		*/

		@ColumnInfo(comment="客户姓名",type="varchar(200)")
		private String kehuName;
		/**
		* 客户手机号
		*/

		@ColumnInfo(comment="客户手机号",type="varchar(200)")
		private String kehuPhone;
		/**
		* 客户身份证号
		*/

		@ColumnInfo(comment="客户身份证号",type="varchar(200)")
		private String kehuIdNumber;
		/**
		* 客户头像
		*/

		@ColumnInfo(comment="客户头像",type="varchar(200)")
		private String kehuPhoto;
		/**
		* 客户邮箱
		*/

		@ColumnInfo(comment="客户邮箱",type="varchar(200)")
		private String kehuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
	//级联表 员工
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public HuoyunView() {

	}

	public HuoyunView(HuoyunEntity huoyunEntity) {
		try {
			BeanUtils.copyProperties(this, huoyunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物品类型的值
	*/
	public String getWupinValue() {
		return wupinValue;
	}
	/**
	* 设置： 物品类型的值
	*/
	public void setWupinValue(String wupinValue) {
		this.wupinValue = wupinValue;
	}
	//当前表的
	/**
	* 获取： 货运类型的值
	*/
	public String getHuoyunValue() {
		return huoyunValue;
	}
	/**
	* 设置： 货运类型的值
	*/
	public void setHuoyunValue(String huoyunValue) {
		this.huoyunValue = huoyunValue;
	}
	//当前表的
	/**
	* 获取： 运输状态的值
	*/
	public String getYushuValue() {
		return yushuValue;
	}
	/**
	* 设置： 运输状态的值
	*/
	public void setYushuValue(String yushuValue) {
		this.yushuValue = yushuValue;
	}


	//级联表的get和set 车辆

		/**
		* 获取： 车辆名称
		*/
		public String getCheliangName() {
			return cheliangName;
		}
		/**
		* 设置： 车辆名称
		*/
		public void setCheliangName(String cheliangName) {
			this.cheliangName = cheliangName;
		}

		/**
		* 获取： 车辆编号
		*/
		public String getCheliangUuidNumber() {
			return cheliangUuidNumber;
		}
		/**
		* 设置： 车辆编号
		*/
		public void setCheliangUuidNumber(String cheliangUuidNumber) {
			this.cheliangUuidNumber = cheliangUuidNumber;
		}

		/**
		* 获取： 车辆照片
		*/
		public String getCheliangPhoto() {
			return cheliangPhoto;
		}
		/**
		* 设置： 车辆照片
		*/
		public void setCheliangPhoto(String cheliangPhoto) {
			this.cheliangPhoto = cheliangPhoto;
		}

		/**
		* 获取： 车辆颜色
		*/
		public String getCheliangYanse() {
			return cheliangYanse;
		}
		/**
		* 设置： 车辆颜色
		*/
		public void setCheliangYanse(String cheliangYanse) {
			this.cheliangYanse = cheliangYanse;
		}

		/**
		* 获取： 车牌号
		*/
		public String getCheliangChepaihao() {
			return cheliangChepaihao;
		}
		/**
		* 设置： 车牌号
		*/
		public void setCheliangChepaihao(String cheliangChepaihao) {
			this.cheliangChepaihao = cheliangChepaihao;
		}
		/**
		* 获取： 车辆类型
		*/
		public Integer getCheliangTypes() {
			return cheliangTypes;
		}
		/**
		* 设置： 车辆类型
		*/
		public void setCheliangTypes(Integer cheliangTypes) {
			this.cheliangTypes = cheliangTypes;
		}


			/**
			* 获取： 车辆类型的值
			*/
			public String getCheliangValue() {
				return cheliangValue;
			}
			/**
			* 设置： 车辆类型的值
			*/
			public void setCheliangValue(String cheliangValue) {
				this.cheliangValue = cheliangValue;
			}

		/**
		* 获取： 车辆介绍
		*/
		public String getCheliangContent() {
			return cheliangContent;
		}
		/**
		* 设置： 车辆介绍
		*/
		public void setCheliangContent(String cheliangContent) {
			this.cheliangContent = cheliangContent;
		}
	//级联表的get和set 驾驶员

		/**
		* 获取： 驾驶员姓名
		*/
		public String getJiashiyuanName() {
			return jiashiyuanName;
		}
		/**
		* 设置： 驾驶员姓名
		*/
		public void setJiashiyuanName(String jiashiyuanName) {
			this.jiashiyuanName = jiashiyuanName;
		}

		/**
		* 获取： 驾驶员手机号
		*/
		public String getJiashiyuanPhone() {
			return jiashiyuanPhone;
		}
		/**
		* 设置： 驾驶员手机号
		*/
		public void setJiashiyuanPhone(String jiashiyuanPhone) {
			this.jiashiyuanPhone = jiashiyuanPhone;
		}

		/**
		* 获取： 驾驶员身份证号
		*/
		public String getJiashiyuanIdNumber() {
			return jiashiyuanIdNumber;
		}
		/**
		* 设置： 驾驶员身份证号
		*/
		public void setJiashiyuanIdNumber(String jiashiyuanIdNumber) {
			this.jiashiyuanIdNumber = jiashiyuanIdNumber;
		}

		/**
		* 获取： 驾驶员照片
		*/
		public String getJiashiyuanPhoto() {
			return jiashiyuanPhoto;
		}
		/**
		* 设置： 驾驶员照片
		*/
		public void setJiashiyuanPhoto(String jiashiyuanPhoto) {
			this.jiashiyuanPhoto = jiashiyuanPhoto;
		}

		/**
		* 获取： 驾照照片
		*/
		public String getJiashiyuanJiazhaoPhoto() {
			return jiashiyuanJiazhaoPhoto;
		}
		/**
		* 设置： 驾照照片
		*/
		public void setJiashiyuanJiazhaoPhoto(String jiashiyuanJiazhaoPhoto) {
			this.jiashiyuanJiazhaoPhoto = jiashiyuanJiazhaoPhoto;
		}

		/**
		* 获取： 驾龄
		*/
		public String getJiashiyuanJialing() {
			return jiashiyuanJialing;
		}
		/**
		* 设置： 驾龄
		*/
		public void setJiashiyuanJialing(String jiashiyuanJialing) {
			this.jiashiyuanJialing = jiashiyuanJialing;
		}

		/**
		* 获取： 驾驶员邮箱
		*/
		public String getJiashiyuanEmail() {
			return jiashiyuanEmail;
		}
		/**
		* 设置： 驾驶员邮箱
		*/
		public void setJiashiyuanEmail(String jiashiyuanEmail) {
			this.jiashiyuanEmail = jiashiyuanEmail;
		}

		/**
		* 获取： 驾驶员介绍
		*/
		public String getJiashiyuanContent() {
			return jiashiyuanContent;
		}
		/**
		* 设置： 驾驶员介绍
		*/
		public void setJiashiyuanContent(String jiashiyuanContent) {
			this.jiashiyuanContent = jiashiyuanContent;
		}
	//级联表的get和set 客户

		/**
		* 获取： 客户姓名
		*/
		public String getKehuName() {
			return kehuName;
		}
		/**
		* 设置： 客户姓名
		*/
		public void setKehuName(String kehuName) {
			this.kehuName = kehuName;
		}

		/**
		* 获取： 客户手机号
		*/
		public String getKehuPhone() {
			return kehuPhone;
		}
		/**
		* 设置： 客户手机号
		*/
		public void setKehuPhone(String kehuPhone) {
			this.kehuPhone = kehuPhone;
		}

		/**
		* 获取： 客户身份证号
		*/
		public String getKehuIdNumber() {
			return kehuIdNumber;
		}
		/**
		* 设置： 客户身份证号
		*/
		public void setKehuIdNumber(String kehuIdNumber) {
			this.kehuIdNumber = kehuIdNumber;
		}

		/**
		* 获取： 客户头像
		*/
		public String getKehuPhoto() {
			return kehuPhoto;
		}
		/**
		* 设置： 客户头像
		*/
		public void setKehuPhoto(String kehuPhoto) {
			this.kehuPhoto = kehuPhoto;
		}

		/**
		* 获取： 客户邮箱
		*/
		public String getKehuEmail() {
			return kehuEmail;
		}
		/**
		* 设置： 客户邮箱
		*/
		public void setKehuEmail(String kehuEmail) {
			this.kehuEmail = kehuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
	//级联表的get和set 员工

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "HuoyunView{" +
			", wupinValue=" + wupinValue +
			", huoyunValue=" + huoyunValue +
			", yushuValue=" + yushuValue +
			", kehuName=" + kehuName +
			", kehuPhone=" + kehuPhone +
			", kehuIdNumber=" + kehuIdNumber +
			", kehuPhoto=" + kehuPhoto +
			", kehuEmail=" + kehuEmail +
			", newMoney=" + newMoney +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			", jiashiyuanName=" + jiashiyuanName +
			", jiashiyuanPhone=" + jiashiyuanPhone +
			", jiashiyuanIdNumber=" + jiashiyuanIdNumber +
			", jiashiyuanPhoto=" + jiashiyuanPhoto +
			", jiashiyuanJiazhaoPhoto=" + jiashiyuanJiazhaoPhoto +
			", jiashiyuanJialing=" + jiashiyuanJialing +
			", jiashiyuanEmail=" + jiashiyuanEmail +
			", jiashiyuanContent=" + jiashiyuanContent +
			", cheliangName=" + cheliangName +
			", cheliangUuidNumber=" + cheliangUuidNumber +
			", cheliangPhoto=" + cheliangPhoto +
			", cheliangYanse=" + cheliangYanse +
			", cheliangChepaihao=" + cheliangChepaihao +
			", cheliangContent=" + cheliangContent +
			"} " + super.toString();
	}
}
