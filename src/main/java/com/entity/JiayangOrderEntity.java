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
 * 家养宠物领养
 *
 * @author 
 * @email
 */
@TableName("jiayang_order")
public class JiayangOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiayangOrderEntity() {

	}

	public JiayangOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "jiayang_order_uuid_number")

    private String jiayangOrderUuidNumber;


    /**
     * 家养宠物
     */
    @ColumnInfo(comment="家养宠物",type="int(11)")
    @TableField(value = "jiayang_id")

    private Integer jiayangId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 领养类型
     */
    @ColumnInfo(comment="领养类型",type="int(11)")
    @TableField(value = "jiayang_order_types")

    private Integer jiayangOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：订单编号
	 */
    public String getJiayangOrderUuidNumber() {
        return jiayangOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setJiayangOrderUuidNumber(String jiayangOrderUuidNumber) {
        this.jiayangOrderUuidNumber = jiayangOrderUuidNumber;
    }
    /**
	 * 获取：家养宠物
	 */
    public Integer getJiayangId() {
        return jiayangId;
    }
    /**
	 * 设置：家养宠物
	 */

    public void setJiayangId(Integer jiayangId) {
        this.jiayangId = jiayangId;
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
	 * 获取：领养类型
	 */
    public Integer getJiayangOrderTypes() {
        return jiayangOrderTypes;
    }
    /**
	 * 设置：领养类型
	 */

    public void setJiayangOrderTypes(Integer jiayangOrderTypes) {
        this.jiayangOrderTypes = jiayangOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JiayangOrder{" +
            ", id=" + id +
            ", jiayangOrderUuidNumber=" + jiayangOrderUuidNumber +
            ", jiayangId=" + jiayangId +
            ", yonghuId=" + yonghuId +
            ", jiayangOrderTypes=" + jiayangOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
