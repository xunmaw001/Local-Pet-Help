package com.entity.vo;

import com.entity.XuanshangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寻找宠物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuanshang")
public class XuanshangVO implements Serializable {
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
     * 寻找宠物名称
     */

    @TableField(value = "xuanshang_name")
    private String xuanshangName;


    /**
     * 寻找宠物编号
     */

    @TableField(value = "xuanshang_uuid_number")
    private String xuanshangUuidNumber;


    /**
     * 寻找宠物照片
     */

    @TableField(value = "xuanshang_photo")
    private String xuanshangPhoto;


    /**
     * 悬赏金额
     */

    @TableField(value = "xuanshang_jine")
    private Double xuanshangJine;


    /**
     * 寻找宠物地点
     */

    @TableField(value = "xuanshang_address")
    private String xuanshangAddress;


    /**
     * 寻找宠物类型
     */

    @TableField(value = "xuanshang_types")
    private Integer xuanshangTypes;


    /**
     * 寻找宠物介绍
     */

    @TableField(value = "xuanshang_content")
    private String xuanshangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xuanshang_delete")
    private Integer xuanshangDelete;


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
	 * 设置：寻找宠物名称
	 */
    public String getXuanshangName() {
        return xuanshangName;
    }


    /**
	 * 获取：寻找宠物名称
	 */

    public void setXuanshangName(String xuanshangName) {
        this.xuanshangName = xuanshangName;
    }
    /**
	 * 设置：寻找宠物编号
	 */
    public String getXuanshangUuidNumber() {
        return xuanshangUuidNumber;
    }


    /**
	 * 获取：寻找宠物编号
	 */

    public void setXuanshangUuidNumber(String xuanshangUuidNumber) {
        this.xuanshangUuidNumber = xuanshangUuidNumber;
    }
    /**
	 * 设置：寻找宠物照片
	 */
    public String getXuanshangPhoto() {
        return xuanshangPhoto;
    }


    /**
	 * 获取：寻找宠物照片
	 */

    public void setXuanshangPhoto(String xuanshangPhoto) {
        this.xuanshangPhoto = xuanshangPhoto;
    }
    /**
	 * 设置：悬赏金额
	 */
    public Double getXuanshangJine() {
        return xuanshangJine;
    }


    /**
	 * 获取：悬赏金额
	 */

    public void setXuanshangJine(Double xuanshangJine) {
        this.xuanshangJine = xuanshangJine;
    }
    /**
	 * 设置：寻找宠物地点
	 */
    public String getXuanshangAddress() {
        return xuanshangAddress;
    }


    /**
	 * 获取：寻找宠物地点
	 */

    public void setXuanshangAddress(String xuanshangAddress) {
        this.xuanshangAddress = xuanshangAddress;
    }
    /**
	 * 设置：寻找宠物类型
	 */
    public Integer getXuanshangTypes() {
        return xuanshangTypes;
    }


    /**
	 * 获取：寻找宠物类型
	 */

    public void setXuanshangTypes(Integer xuanshangTypes) {
        this.xuanshangTypes = xuanshangTypes;
    }
    /**
	 * 设置：寻找宠物介绍
	 */
    public String getXuanshangContent() {
        return xuanshangContent;
    }


    /**
	 * 获取：寻找宠物介绍
	 */

    public void setXuanshangContent(String xuanshangContent) {
        this.xuanshangContent = xuanshangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXuanshangDelete() {
        return xuanshangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXuanshangDelete(Integer xuanshangDelete) {
        this.xuanshangDelete = xuanshangDelete;
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
