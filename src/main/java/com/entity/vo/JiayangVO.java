package com.entity.vo;

import com.entity.JiayangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家养宠物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiayang")
public class JiayangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 家养宠物名称
     */

    @TableField(value = "jiayang_name")
    private String jiayangName;


    /**
     * 家养宠物编号
     */

    @TableField(value = "jiayang_uuid_number")
    private String jiayangUuidNumber;


    /**
     * 家养宠物照片
     */

    @TableField(value = "jiayang_photo")
    private String jiayangPhoto;


    /**
     * 家养宠物主人
     */

    @TableField(value = "jiayang_zhuren")
    private String jiayangZhuren;


    /**
     * 宠物主人联系方式
     */

    @TableField(value = "jiayang_phone")
    private String jiayangPhone;


    /**
     * 家养宠物地点
     */

    @TableField(value = "jiayang_address")
    private String jiayangAddress;


    /**
     * 家养宠物类型
     */

    @TableField(value = "jiayang_types")
    private Integer jiayangTypes;


    /**
     * 家养宠物介绍
     */

    @TableField(value = "jiayang_content")
    private String jiayangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiayang_delete")
    private Integer jiayangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：家养宠物名称
	 */
    public String getJiayangName() {
        return jiayangName;
    }


    /**
	 * 获取：家养宠物名称
	 */

    public void setJiayangName(String jiayangName) {
        this.jiayangName = jiayangName;
    }
    /**
	 * 设置：家养宠物编号
	 */
    public String getJiayangUuidNumber() {
        return jiayangUuidNumber;
    }


    /**
	 * 获取：家养宠物编号
	 */

    public void setJiayangUuidNumber(String jiayangUuidNumber) {
        this.jiayangUuidNumber = jiayangUuidNumber;
    }
    /**
	 * 设置：家养宠物照片
	 */
    public String getJiayangPhoto() {
        return jiayangPhoto;
    }


    /**
	 * 获取：家养宠物照片
	 */

    public void setJiayangPhoto(String jiayangPhoto) {
        this.jiayangPhoto = jiayangPhoto;
    }
    /**
	 * 设置：家养宠物主人
	 */
    public String getJiayangZhuren() {
        return jiayangZhuren;
    }


    /**
	 * 获取：家养宠物主人
	 */

    public void setJiayangZhuren(String jiayangZhuren) {
        this.jiayangZhuren = jiayangZhuren;
    }
    /**
	 * 设置：宠物主人联系方式
	 */
    public String getJiayangPhone() {
        return jiayangPhone;
    }


    /**
	 * 获取：宠物主人联系方式
	 */

    public void setJiayangPhone(String jiayangPhone) {
        this.jiayangPhone = jiayangPhone;
    }
    /**
	 * 设置：家养宠物地点
	 */
    public String getJiayangAddress() {
        return jiayangAddress;
    }


    /**
	 * 获取：家养宠物地点
	 */

    public void setJiayangAddress(String jiayangAddress) {
        this.jiayangAddress = jiayangAddress;
    }
    /**
	 * 设置：家养宠物类型
	 */
    public Integer getJiayangTypes() {
        return jiayangTypes;
    }


    /**
	 * 获取：家养宠物类型
	 */

    public void setJiayangTypes(Integer jiayangTypes) {
        this.jiayangTypes = jiayangTypes;
    }
    /**
	 * 设置：家养宠物介绍
	 */
    public String getJiayangContent() {
        return jiayangContent;
    }


    /**
	 * 获取：家养宠物介绍
	 */

    public void setJiayangContent(String jiayangContent) {
        this.jiayangContent = jiayangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiayangDelete() {
        return jiayangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiayangDelete(Integer jiayangDelete) {
        this.jiayangDelete = jiayangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
