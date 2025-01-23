package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiayangLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 家养宠物留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiayang_liuyan")
public class JiayangLiuyanView extends JiayangLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 家养宠物
					 
		/**
		* 家养宠物 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer jiayangYonghuId;
		/**
		* 家养宠物名称
		*/

		@ColumnInfo(comment="家养宠物名称",type="varchar(200)")
		private String jiayangName;
		/**
		* 家养宠物编号
		*/

		@ColumnInfo(comment="家养宠物编号",type="varchar(200)")
		private String jiayangUuidNumber;
		/**
		* 家养宠物照片
		*/

		@ColumnInfo(comment="家养宠物照片",type="varchar(200)")
		private String jiayangPhoto;
		/**
		* 家养宠物主人
		*/

		@ColumnInfo(comment="家养宠物主人",type="varchar(200)")
		private String jiayangZhuren;
		/**
		* 宠物主人联系方式
		*/

		@ColumnInfo(comment="宠物主人联系方式",type="varchar(200)")
		private String jiayangPhone;
		/**
		* 家养宠物地点
		*/

		@ColumnInfo(comment="家养宠物地点",type="varchar(200)")
		private String jiayangAddress;
		/**
		* 家养宠物类型
		*/
		@ColumnInfo(comment="家养宠物类型",type="int(11)")
		private Integer jiayangTypes;
			/**
			* 家养宠物类型的值
			*/
			@ColumnInfo(comment="家养宠物类型的字典表值",type="varchar(200)")
			private String jiayangValue;
		/**
		* 家养宠物介绍
		*/

		@ColumnInfo(comment="家养宠物介绍",type="text")
		private String jiayangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiayangDelete;
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



	public JiayangLiuyanView() {

	}

	public JiayangLiuyanView(JiayangLiuyanEntity jiayangLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, jiayangLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 家养宠物
		/**
		* 获取：家养宠物 的 用户
		*/
		public Integer getJiayangYonghuId() {
			return jiayangYonghuId;
		}
		/**
		* 设置：家养宠物 的 用户
		*/
		public void setJiayangYonghuId(Integer jiayangYonghuId) {
			this.jiayangYonghuId = jiayangYonghuId;
		}

		/**
		* 获取： 家养宠物名称
		*/
		public String getJiayangName() {
			return jiayangName;
		}
		/**
		* 设置： 家养宠物名称
		*/
		public void setJiayangName(String jiayangName) {
			this.jiayangName = jiayangName;
		}

		/**
		* 获取： 家养宠物编号
		*/
		public String getJiayangUuidNumber() {
			return jiayangUuidNumber;
		}
		/**
		* 设置： 家养宠物编号
		*/
		public void setJiayangUuidNumber(String jiayangUuidNumber) {
			this.jiayangUuidNumber = jiayangUuidNumber;
		}

		/**
		* 获取： 家养宠物照片
		*/
		public String getJiayangPhoto() {
			return jiayangPhoto;
		}
		/**
		* 设置： 家养宠物照片
		*/
		public void setJiayangPhoto(String jiayangPhoto) {
			this.jiayangPhoto = jiayangPhoto;
		}

		/**
		* 获取： 家养宠物主人
		*/
		public String getJiayangZhuren() {
			return jiayangZhuren;
		}
		/**
		* 设置： 家养宠物主人
		*/
		public void setJiayangZhuren(String jiayangZhuren) {
			this.jiayangZhuren = jiayangZhuren;
		}

		/**
		* 获取： 宠物主人联系方式
		*/
		public String getJiayangPhone() {
			return jiayangPhone;
		}
		/**
		* 设置： 宠物主人联系方式
		*/
		public void setJiayangPhone(String jiayangPhone) {
			this.jiayangPhone = jiayangPhone;
		}

		/**
		* 获取： 家养宠物地点
		*/
		public String getJiayangAddress() {
			return jiayangAddress;
		}
		/**
		* 设置： 家养宠物地点
		*/
		public void setJiayangAddress(String jiayangAddress) {
			this.jiayangAddress = jiayangAddress;
		}
		/**
		* 获取： 家养宠物类型
		*/
		public Integer getJiayangTypes() {
			return jiayangTypes;
		}
		/**
		* 设置： 家养宠物类型
		*/
		public void setJiayangTypes(Integer jiayangTypes) {
			this.jiayangTypes = jiayangTypes;
		}


			/**
			* 获取： 家养宠物类型的值
			*/
			public String getJiayangValue() {
				return jiayangValue;
			}
			/**
			* 设置： 家养宠物类型的值
			*/
			public void setJiayangValue(String jiayangValue) {
				this.jiayangValue = jiayangValue;
			}

		/**
		* 获取： 家养宠物介绍
		*/
		public String getJiayangContent() {
			return jiayangContent;
		}
		/**
		* 设置： 家养宠物介绍
		*/
		public void setJiayangContent(String jiayangContent) {
			this.jiayangContent = jiayangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiayangDelete() {
			return jiayangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiayangDelete(Integer jiayangDelete) {
			this.jiayangDelete = jiayangDelete;
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
		return "JiayangLiuyanView{" +
			", jiayangName=" + jiayangName +
			", jiayangUuidNumber=" + jiayangUuidNumber +
			", jiayangPhoto=" + jiayangPhoto +
			", jiayangZhuren=" + jiayangZhuren +
			", jiayangPhone=" + jiayangPhone +
			", jiayangAddress=" + jiayangAddress +
			", jiayangContent=" + jiayangContent +
			", jiayangDelete=" + jiayangDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
