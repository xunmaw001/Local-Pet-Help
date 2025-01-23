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
 * 家养宠物
 *
 * @author 
 * @email
 */
@TableName("jiayang")
public class JiayangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiayangEntity() {

	}

	public JiayangEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 家养宠物名称
     */
    @ColumnInfo(comment="家养宠物名称",type="varchar(200)")
    @TableField(value = "jiayang_name")

    private String jiayangName;


    /**
     * 家养宠物编号
     */
    @ColumnInfo(comment="家养宠物编号",type="varchar(200)")
    @TableField(value = "jiayang_uuid_number")

    private String jiayangUuidNumber;


    /**
     * 家养宠物照片
     */
    @ColumnInfo(comment="家养宠物照片",type="varchar(200)")
    @TableField(value = "jiayang_photo")

    private String jiayangPhoto;


    /**
     * 家养宠物主人
     */
    @ColumnInfo(comment="家养宠物主人",type="varchar(200)")
    @TableField(value = "jiayang_zhuren")

    private String jiayangZhuren;


    /**
     * 宠物主人联系方式
     */
    @ColumnInfo(comment="宠物主人联系方式",type="varchar(200)")
    @TableField(value = "jiayang_phone")

    private String jiayangPhone;


    /**
     * 家养宠物地点
     */
    @ColumnInfo(comment="家养宠物地点",type="varchar(200)")
    @TableField(value = "jiayang_address")

    private String jiayangAddress;


    /**
     * 家养宠物类型
     */
    @ColumnInfo(comment="家养宠物类型",type="int(11)")
    @TableField(value = "jiayang_types")

    private Integer jiayangTypes;


    /**
     * 家养宠物介绍
     */
    @ColumnInfo(comment="家养宠物介绍",type="text")
    @TableField(value = "jiayang_content")

    private String jiayangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiayang_delete")

    private Integer jiayangDelete;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：家养宠物名称
	 */
    public String getJiayangName() {
        return jiayangName;
    }
    /**
	 * 设置：家养宠物名称
	 */

    public void setJiayangName(String jiayangName) {
        this.jiayangName = jiayangName;
    }
    /**
	 * 获取：家养宠物编号
	 */
    public String getJiayangUuidNumber() {
        return jiayangUuidNumber;
    }
    /**
	 * 设置：家养宠物编号
	 */

    public void setJiayangUuidNumber(String jiayangUuidNumber) {
        this.jiayangUuidNumber = jiayangUuidNumber;
    }
    /**
	 * 获取：家养宠物照片
	 */
    public String getJiayangPhoto() {
        return jiayangPhoto;
    }
    /**
	 * 设置：家养宠物照片
	 */

    public void setJiayangPhoto(String jiayangPhoto) {
        this.jiayangPhoto = jiayangPhoto;
    }
    /**
	 * 获取：家养宠物主人
	 */
    public String getJiayangZhuren() {
        return jiayangZhuren;
    }
    /**
	 * 设置：家养宠物主人
	 */

    public void setJiayangZhuren(String jiayangZhuren) {
        this.jiayangZhuren = jiayangZhuren;
    }
    /**
	 * 获取：宠物主人联系方式
	 */
    public String getJiayangPhone() {
        return jiayangPhone;
    }
    /**
	 * 设置：宠物主人联系方式
	 */

    public void setJiayangPhone(String jiayangPhone) {
        this.jiayangPhone = jiayangPhone;
    }
    /**
	 * 获取：家养宠物地点
	 */
    public String getJiayangAddress() {
        return jiayangAddress;
    }
    /**
	 * 设置：家养宠物地点
	 */

    public void setJiayangAddress(String jiayangAddress) {
        this.jiayangAddress = jiayangAddress;
    }
    /**
	 * 获取：家养宠物类型
	 */
    public Integer getJiayangTypes() {
        return jiayangTypes;
    }
    /**
	 * 设置：家养宠物类型
	 */

    public void setJiayangTypes(Integer jiayangTypes) {
        this.jiayangTypes = jiayangTypes;
    }
    /**
	 * 获取：家养宠物介绍
	 */
    public String getJiayangContent() {
        return jiayangContent;
    }
    /**
	 * 设置：家养宠物介绍
	 */

    public void setJiayangContent(String jiayangContent) {
        this.jiayangContent = jiayangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiayangDelete() {
        return jiayangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiayangDelete(Integer jiayangDelete) {
        this.jiayangDelete = jiayangDelete;
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
        return "Jiayang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiayangName=" + jiayangName +
            ", jiayangUuidNumber=" + jiayangUuidNumber +
            ", jiayangPhoto=" + jiayangPhoto +
            ", jiayangZhuren=" + jiayangZhuren +
            ", jiayangPhone=" + jiayangPhone +
            ", jiayangAddress=" + jiayangAddress +
            ", jiayangTypes=" + jiayangTypes +
            ", jiayangContent=" + jiayangContent +
            ", jiayangDelete=" + jiayangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
