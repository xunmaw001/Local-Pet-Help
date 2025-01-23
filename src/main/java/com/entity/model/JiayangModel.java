package com.entity.model;

import com.entity.JiayangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家养宠物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiayangModel implements Serializable {
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
     * 家养宠物名称
     */
    private String jiayangName;


    /**
     * 家养宠物编号
     */
    private String jiayangUuidNumber;


    /**
     * 家养宠物照片
     */
    private String jiayangPhoto;


    /**
     * 家养宠物主人
     */
    private String jiayangZhuren;


    /**
     * 宠物主人联系方式
     */
    private String jiayangPhone;


    /**
     * 家养宠物地点
     */
    private String jiayangAddress;


    /**
     * 家养宠物类型
     */
    private Integer jiayangTypes;


    /**
     * 家养宠物介绍
     */
    private String jiayangContent;


    /**
     * 逻辑删除
     */
    private Integer jiayangDelete;


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
