package com.entity.vo;

import com.entity.HeimingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 黑名单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("heimingdan")
public class HeimingdanVO implements Serializable {
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
     * 黑名单编号
     */

    @TableField(value = "heimingdan_uuid_number")
    private String heimingdanUuidNumber;


    /**
     * 黑名单类型
     */

    @TableField(value = "heimingdan_types")
    private Integer heimingdanTypes;


    /**
     * 拉黑理由
     */

    @TableField(value = "heimingdan_content")
    private String heimingdanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "heimingdan_delete")
    private Integer heimingdanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：黑名单编号
	 */
    public String getHeimingdanUuidNumber() {
        return heimingdanUuidNumber;
    }


    /**
	 * 获取：黑名单编号
	 */

    public void setHeimingdanUuidNumber(String heimingdanUuidNumber) {
        this.heimingdanUuidNumber = heimingdanUuidNumber;
    }
    /**
	 * 设置：黑名单类型
	 */
    public Integer getHeimingdanTypes() {
        return heimingdanTypes;
    }


    /**
	 * 获取：黑名单类型
	 */

    public void setHeimingdanTypes(Integer heimingdanTypes) {
        this.heimingdanTypes = heimingdanTypes;
    }
    /**
	 * 设置：拉黑理由
	 */
    public String getHeimingdanContent() {
        return heimingdanContent;
    }


    /**
	 * 获取：拉黑理由
	 */

    public void setHeimingdanContent(String heimingdanContent) {
        this.heimingdanContent = heimingdanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getHeimingdanDelete() {
        return heimingdanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setHeimingdanDelete(Integer heimingdanDelete) {
        this.heimingdanDelete = heimingdanDelete;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
