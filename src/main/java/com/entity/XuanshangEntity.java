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
 * 寻找宠物
 *
 * @author 
 * @email
 */
@TableName("xuanshang")
public class XuanshangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanshangEntity() {

	}

	public XuanshangEntity(T t) {
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
     * 寻找宠物名称
     */
    @ColumnInfo(comment="寻找宠物名称",type="varchar(200)")
    @TableField(value = "xuanshang_name")

    private String xuanshangName;


    /**
     * 寻找宠物编号
     */
    @ColumnInfo(comment="寻找宠物编号",type="varchar(200)")
    @TableField(value = "xuanshang_uuid_number")

    private String xuanshangUuidNumber;


    /**
     * 寻找宠物照片
     */
    @ColumnInfo(comment="寻找宠物照片",type="varchar(200)")
    @TableField(value = "xuanshang_photo")

    private String xuanshangPhoto;


    /**
     * 悬赏金额
     */
    @ColumnInfo(comment="悬赏金额",type="decimal(10,2)")
    @TableField(value = "xuanshang_jine")

    private Double xuanshangJine;


    /**
     * 寻找宠物地点
     */
    @ColumnInfo(comment="寻找宠物地点",type="varchar(200)")
    @TableField(value = "xuanshang_address")

    private String xuanshangAddress;


    /**
     * 寻找宠物类型
     */
    @ColumnInfo(comment="寻找宠物类型",type="int(11)")
    @TableField(value = "xuanshang_types")

    private Integer xuanshangTypes;


    /**
     * 寻找宠物介绍
     */
    @ColumnInfo(comment="寻找宠物介绍",type="text")
    @TableField(value = "xuanshang_content")

    private String xuanshangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xuanshang_delete")

    private Integer xuanshangDelete;


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
	 * 获取：寻找宠物名称
	 */
    public String getXuanshangName() {
        return xuanshangName;
    }
    /**
	 * 设置：寻找宠物名称
	 */

    public void setXuanshangName(String xuanshangName) {
        this.xuanshangName = xuanshangName;
    }
    /**
	 * 获取：寻找宠物编号
	 */
    public String getXuanshangUuidNumber() {
        return xuanshangUuidNumber;
    }
    /**
	 * 设置：寻找宠物编号
	 */

    public void setXuanshangUuidNumber(String xuanshangUuidNumber) {
        this.xuanshangUuidNumber = xuanshangUuidNumber;
    }
    /**
	 * 获取：寻找宠物照片
	 */
    public String getXuanshangPhoto() {
        return xuanshangPhoto;
    }
    /**
	 * 设置：寻找宠物照片
	 */

    public void setXuanshangPhoto(String xuanshangPhoto) {
        this.xuanshangPhoto = xuanshangPhoto;
    }
    /**
	 * 获取：悬赏金额
	 */
    public Double getXuanshangJine() {
        return xuanshangJine;
    }
    /**
	 * 设置：悬赏金额
	 */

    public void setXuanshangJine(Double xuanshangJine) {
        this.xuanshangJine = xuanshangJine;
    }
    /**
	 * 获取：寻找宠物地点
	 */
    public String getXuanshangAddress() {
        return xuanshangAddress;
    }
    /**
	 * 设置：寻找宠物地点
	 */

    public void setXuanshangAddress(String xuanshangAddress) {
        this.xuanshangAddress = xuanshangAddress;
    }
    /**
	 * 获取：寻找宠物类型
	 */
    public Integer getXuanshangTypes() {
        return xuanshangTypes;
    }
    /**
	 * 设置：寻找宠物类型
	 */

    public void setXuanshangTypes(Integer xuanshangTypes) {
        this.xuanshangTypes = xuanshangTypes;
    }
    /**
	 * 获取：寻找宠物介绍
	 */
    public String getXuanshangContent() {
        return xuanshangContent;
    }
    /**
	 * 设置：寻找宠物介绍
	 */

    public void setXuanshangContent(String xuanshangContent) {
        this.xuanshangContent = xuanshangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXuanshangDelete() {
        return xuanshangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXuanshangDelete(Integer xuanshangDelete) {
        this.xuanshangDelete = xuanshangDelete;
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
        return "Xuanshang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", xuanshangName=" + xuanshangName +
            ", xuanshangUuidNumber=" + xuanshangUuidNumber +
            ", xuanshangPhoto=" + xuanshangPhoto +
            ", xuanshangJine=" + xuanshangJine +
            ", xuanshangAddress=" + xuanshangAddress +
            ", xuanshangTypes=" + xuanshangTypes +
            ", xuanshangContent=" + xuanshangContent +
            ", xuanshangDelete=" + xuanshangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
