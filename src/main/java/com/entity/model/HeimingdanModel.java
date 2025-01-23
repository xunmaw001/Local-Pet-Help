package com.entity.model;

import com.entity.HeimingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 黑名单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HeimingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 黑名单编号
     */
    private String heimingdanUuidNumber;


    /**
     * 黑名单类型
     */
    private Integer heimingdanTypes;


    /**
     * 拉黑理由
     */
    private String heimingdanContent;


    /**
     * 逻辑删除
     */
    private Integer heimingdanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
