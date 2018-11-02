package com.nico.web.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 
 * @since 2018-06-22
 */
@TableName("Sys_User")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "User_Id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 所属公司
     */
    @TableField("Company_Id")
    private Integer companyId;
    /**
     * 用户姓名
     */
    @TableField("User_Name")
    private String userName;
    /**
     * 登录帐号
     */
    @TableField("Login_Name")
    private String loginName;
    /**
     * 登录密码
     */
    @TableField("Login_Password")
    private String loginPassword;
    /**
     * 联系手机
     */
    @TableField("Mobile")
    private String Mobile;
    /**
     * 电子邮箱
     */
    @TableField("Email")
    private String Email;
    /**
     * 联系地址
     */
    @TableField("Home_Address")
    private String homeAddress;
    /**
     * 邮政编码
     */
    @TableField("PostCode")
    private String PostCode;
    /**
     * 性别 0男 1女 2保密
     */
    @TableField("Sex")
    private String Sex;
    /**
     * 创建时间
     */
    @TableField("Create_Time")
    private Date createTime;
    /**
     * 最后登录IP
     */
    @TableField("Last_IP")
    private String lastIp;
    /**
     * 最后登录时间
     */
    @TableField("Last_Time")
    private Date lastTime;
    /**
     * 用户头像
     */
    @TableField("Photo_URL")
    private String photoUrl;
    /**
     * 用户状态 0有效 1无效
     */
    @TableField("Status")
    private Integer Status;
    /**
     * 预警接收状态（0：不接收，1接收）
     */
    @TableField("warning_State")
    private String warningState;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }

    public String getWarningState() {
        return warningState;
    }

    public void setWarningState(String warningState) {
        this.warningState = warningState;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "userId=" + userId +
        ", companyId=" + companyId +
        ", userName=" + userName +
        ", loginName=" + loginName +
        ", loginPassword=" + loginPassword +
        ", Mobile=" + Mobile +
        ", Email=" + Email +
        ", homeAddress=" + homeAddress +
        ", PostCode=" + PostCode +
        ", Sex=" + Sex +
        ", createTime=" + createTime +
        ", lastIp=" + lastIp +
        ", lastTime=" + lastTime +
        ", photoUrl=" + photoUrl +
        ", Status=" + Status +
        ", warningState=" + warningState +
        "}";
    }
}
