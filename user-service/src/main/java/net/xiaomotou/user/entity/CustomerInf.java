package net.xiaomotou.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class CustomerInf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @TableId(value = "customer_inf_id", type = IdType.AUTO)
    private Integer customerInfId;

    /**
     * customer_login表的自增ID
     */
    private Integer customerId;

    /**
     * 用户真实姓名
     */
    @NotEmpty(message="姓名不能为空")
    private String customerName;

    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
    private Integer identityCardType;

    /**
     * 用户头像地址
     */
    private String avatarUrl;

    /**
     * 证件号码
     */
    @Pattern(regexp = "/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$/"
    ,message = "身份证有误")
    private String identityCardNo;

    /**
     * 手机号
     */
    @Size(min = 11, max=11,message="电话号码必须11位")
    private String mobilePhone;

    /**
     * 邮箱
     */
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "状态只能为00或01或02或03")
    private String customerEmail;

    /**
     * 性别
     */
    @Pattern(regexp = "[0-1]",message = "性别只能是男或女")
    private String gender;

    /**
     * 用户积分
     */
    private Integer userPoint;

    /**
     * 注册时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime registerTime;

    /**
     * 会员生日
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime birthday;

    /**
     * 会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石
     */
    private Integer customerLevel;

    /**
     * 用户余额
     */
    private BigDecimal userMoney;

    /**
     * 最后修改时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime modifiedTime;

    public Integer getCustomerInfId() {
        return customerInfId;
    }

    public void setCustomerInfId(Integer customerInfId) {
        this.customerInfId = customerInfId;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(Integer identityCardType) {
        this.identityCardType = identityCardType;
    }
    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }
    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }
    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "CustomerInf{" +
                "customerInfId=" + customerInfId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", identityCardType=" + identityCardType +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", identityCardNo='" + identityCardNo + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", gender='" + gender + '\'' +
                ", userPoint=" + userPoint +
                ", registerTime=" + registerTime +
                ", birthday=" + birthday +
                ", customerLevel=" + customerLevel +
                ", userMoney=" + userMoney +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
