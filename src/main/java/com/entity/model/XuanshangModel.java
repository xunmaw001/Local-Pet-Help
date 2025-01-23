package com.entity.model;

import com.entity.XuanshangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寻找宠物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuanshangModel implements Serializable {
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
     * 寻找宠物名称
     */
    private String xuanshangName;


    /**
     * 寻找宠物编号
     */
    private String xuanshangUuidNumber;


    /**
     * 寻找宠物照片
     */
    private String xuanshangPhoto;


    /**
     * 悬赏金额
     */
    private Double xuanshangJine;


    /**
     * 寻找宠物地点
     */
    private String xuanshangAddress;


    /**
     * 寻找宠物类型
     */
    private Integer xuanshangTypes;


    /**
     * 寻找宠物介绍
     */
    private String xuanshangContent;


    /**
     * 逻辑删除
     */
    private Integer xuanshangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
