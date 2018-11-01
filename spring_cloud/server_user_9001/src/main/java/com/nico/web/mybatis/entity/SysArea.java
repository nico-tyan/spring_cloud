package com.nico.web.mybatis.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 地区信息表
 * </p>
 *
 * @author 
 * @since 2018-06-22
 */
@TableName("Sys_Area")
public class SysArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区ID
     */
    @TableId(value = "Area_Id", type = IdType.AUTO)
    private Integer areaId;
    /**
     * 地区名称
     */
    @TableField("Area_Name")
    private String areaName;
    /**
     * 父级地区ID
     */
    @TableField("Parent_Id")
    private Integer parentId;
    /**
     * 地区状态 0 有效  1 无效
     */
    @TableField("Area_Status")
    private Integer areaStatus;
    /**
     * 修改者
     */
    @TableField("Modifier")
    private String Modifier;
    /**
     * 修改时间
     */
    @TableField("Update_Time")
    private Date updateTime;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(Integer areaStatus) {
        this.areaStatus = areaStatus;
    }

    public String getModifier() {
        return Modifier;
    }

    public void setModifier(String Modifier) {
        this.Modifier = Modifier;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysArea{" +
        "areaId=" + areaId +
        ", areaName=" + areaName +
        ", parentId=" + parentId +
        ", areaStatus=" + areaStatus +
        ", Modifier=" + Modifier +
        ", updateTime=" + updateTime +
        "}";
    }
}
