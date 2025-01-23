package com.entity.model;

import com.entity.DakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 每日打卡
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DakaModel implements Serializable {
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
     * 打卡
     */
    private String dakaName;


    /**
     * 照片
     */
    private String dakaFile;


    /**
     * 备注
     */
    private String dakaText;


    /**
     * 逻辑删除
     */
    private Integer dakaDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：打卡
	 */
    public String getDakaName() {
        return dakaName;
    }


    /**
	 * 设置：打卡
	 */
    public void setDakaName(String dakaName) {
        this.dakaName = dakaName;
    }
    /**
	 * 获取：照片
	 */
    public String getDakaFile() {
        return dakaFile;
    }


    /**
	 * 设置：照片
	 */
    public void setDakaFile(String dakaFile) {
        this.dakaFile = dakaFile;
    }
    /**
	 * 获取：备注
	 */
    public String getDakaText() {
        return dakaText;
    }


    /**
	 * 设置：备注
	 */
    public void setDakaText(String dakaText) {
        this.dakaText = dakaText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDakaDelete() {
        return dakaDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDakaDelete(Integer dakaDelete) {
        this.dakaDelete = dakaDelete;
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
