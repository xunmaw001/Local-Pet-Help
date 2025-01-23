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
 * 黑名单
 *
 * @author 
 * @email
 */
@TableName("heimingdan")
public class HeimingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HeimingdanEntity() {

	}

	public HeimingdanEntity(T t) {
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
     * 黑名单编号
     */
    @ColumnInfo(comment="黑名单编号",type="varchar(200)")
    @TableField(value = "heimingdan_uuid_number")

    private String heimingdanUuidNumber;


    /**
     * 黑名单类型
     */
    @ColumnInfo(comment="黑名单类型",type="int(11)")
    @TableField(value = "heimingdan_types")

    private Integer heimingdanTypes;


    /**
     * 拉黑理由
     */
    @ColumnInfo(comment="拉黑理由",type="text")
    @TableField(value = "heimingdan_content")

    private String heimingdanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "heimingdan_delete")

    private Integer heimingdanDelete;


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
	 * 获取：黑名单编号
	 */
    public String getHeimingdanUuidNumber() {
        return heimingdanUuidNumber;
    }
    /**
	 * 设置：黑名单编号
	 */

    public void setHeimingdanUuidNumber(String heimingdanUuidNumber) {
        this.heimingdanUuidNumber = heimingdanUuidNumber;
    }
    /**
	 * 获取：黑名单类型
	 */
    public Integer getHeimingdanTypes() {
        return heimingdanTypes;
    }
    /**
	 * 设置：黑名单类型
	 */

    public void setHeimingdanTypes(Integer heimingdanTypes) {
        this.heimingdanTypes = heimingdanTypes;
    }
    /**
	 * 获取：拉黑理由
	 */
    public String getHeimingdanContent() {
        return heimingdanContent;
    }
    /**
	 * 设置：拉黑理由
	 */

    public void setHeimingdanContent(String heimingdanContent) {
        this.heimingdanContent = heimingdanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHeimingdanDelete() {
        return heimingdanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setHeimingdanDelete(Integer heimingdanDelete) {
        this.heimingdanDelete = heimingdanDelete;
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
        return "Heimingdan{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", heimingdanUuidNumber=" + heimingdanUuidNumber +
            ", heimingdanTypes=" + heimingdanTypes +
            ", heimingdanContent=" + heimingdanContent +
            ", heimingdanDelete=" + heimingdanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
