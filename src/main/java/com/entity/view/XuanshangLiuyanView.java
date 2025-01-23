package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuanshangLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 寻找宠物留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanshang_liuyan")
public class XuanshangLiuyanView extends XuanshangLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 寻找宠物
					 
		/**
		* 寻找宠物 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer xuanshangYonghuId;
		/**
		* 寻找宠物名称
		*/

		@ColumnInfo(comment="寻找宠物名称",type="varchar(200)")
		private String xuanshangName;
		/**
		* 寻找宠物编号
		*/

		@ColumnInfo(comment="寻找宠物编号",type="varchar(200)")
		private String xuanshangUuidNumber;
		/**
		* 寻找宠物照片
		*/

		@ColumnInfo(comment="寻找宠物照片",type="varchar(200)")
		private String xuanshangPhoto;
		/**
		* 悬赏金额
		*/
		@ColumnInfo(comment="悬赏金额",type="decimal(10,2)")
		private Double xuanshangJine;
		/**
		* 寻找宠物地点
		*/

		@ColumnInfo(comment="寻找宠物地点",type="varchar(200)")
		private String xuanshangAddress;
		/**
		* 寻找宠物类型
		*/
		@ColumnInfo(comment="寻找宠物类型",type="int(11)")
		private Integer xuanshangTypes;
			/**
			* 寻找宠物类型的值
			*/
			@ColumnInfo(comment="寻找宠物类型的字典表值",type="varchar(200)")
			private String xuanshangValue;
		/**
		* 寻找宠物介绍
		*/

		@ColumnInfo(comment="寻找宠物介绍",type="text")
		private String xuanshangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xuanshangDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public XuanshangLiuyanView() {

	}

	public XuanshangLiuyanView(XuanshangLiuyanEntity xuanshangLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, xuanshangLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 寻找宠物
		/**
		* 获取：寻找宠物 的 用户
		*/
		public Integer getXuanshangYonghuId() {
			return xuanshangYonghuId;
		}
		/**
		* 设置：寻找宠物 的 用户
		*/
		public void setXuanshangYonghuId(Integer xuanshangYonghuId) {
			this.xuanshangYonghuId = xuanshangYonghuId;
		}

		/**
		* 获取： 寻找宠物名称
		*/
		public String getXuanshangName() {
			return xuanshangName;
		}
		/**
		* 设置： 寻找宠物名称
		*/
		public void setXuanshangName(String xuanshangName) {
			this.xuanshangName = xuanshangName;
		}

		/**
		* 获取： 寻找宠物编号
		*/
		public String getXuanshangUuidNumber() {
			return xuanshangUuidNumber;
		}
		/**
		* 设置： 寻找宠物编号
		*/
		public void setXuanshangUuidNumber(String xuanshangUuidNumber) {
			this.xuanshangUuidNumber = xuanshangUuidNumber;
		}

		/**
		* 获取： 寻找宠物照片
		*/
		public String getXuanshangPhoto() {
			return xuanshangPhoto;
		}
		/**
		* 设置： 寻找宠物照片
		*/
		public void setXuanshangPhoto(String xuanshangPhoto) {
			this.xuanshangPhoto = xuanshangPhoto;
		}

		/**
		* 获取： 悬赏金额
		*/
		public Double getXuanshangJine() {
			return xuanshangJine;
		}
		/**
		* 设置： 悬赏金额
		*/
		public void setXuanshangJine(Double xuanshangJine) {
			this.xuanshangJine = xuanshangJine;
		}

		/**
		* 获取： 寻找宠物地点
		*/
		public String getXuanshangAddress() {
			return xuanshangAddress;
		}
		/**
		* 设置： 寻找宠物地点
		*/
		public void setXuanshangAddress(String xuanshangAddress) {
			this.xuanshangAddress = xuanshangAddress;
		}
		/**
		* 获取： 寻找宠物类型
		*/
		public Integer getXuanshangTypes() {
			return xuanshangTypes;
		}
		/**
		* 设置： 寻找宠物类型
		*/
		public void setXuanshangTypes(Integer xuanshangTypes) {
			this.xuanshangTypes = xuanshangTypes;
		}


			/**
			* 获取： 寻找宠物类型的值
			*/
			public String getXuanshangValue() {
				return xuanshangValue;
			}
			/**
			* 设置： 寻找宠物类型的值
			*/
			public void setXuanshangValue(String xuanshangValue) {
				this.xuanshangValue = xuanshangValue;
			}

		/**
		* 获取： 寻找宠物介绍
		*/
		public String getXuanshangContent() {
			return xuanshangContent;
		}
		/**
		* 设置： 寻找宠物介绍
		*/
		public void setXuanshangContent(String xuanshangContent) {
			this.xuanshangContent = xuanshangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXuanshangDelete() {
			return xuanshangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXuanshangDelete(Integer xuanshangDelete) {
			this.xuanshangDelete = xuanshangDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "XuanshangLiuyanView{" +
			", xuanshangName=" + xuanshangName +
			", xuanshangUuidNumber=" + xuanshangUuidNumber +
			", xuanshangPhoto=" + xuanshangPhoto +
			", xuanshangJine=" + xuanshangJine +
			", xuanshangAddress=" + xuanshangAddress +
			", xuanshangContent=" + xuanshangContent +
			", xuanshangDelete=" + xuanshangDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
