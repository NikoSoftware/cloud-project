package net.xiaomotou.gateway.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class User implements Serializable {


    /**
     * 自增主键ID
     */
    private Integer customerInfId;

    /**
     * customer_login表的自增ID
     */
    private Integer customerId;

    /**
     * 用户真实姓名
     */
    private String customerName;

    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
    private Integer identityCardType;

    /**
     * 证件号码
     */
    private String identityCardNo;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 邮箱
     */
    private String customerEmail;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户积分
     */
    private Integer userPoint;

    /**
     * 注册时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)  //application/json
    @JsonSerialize(using = LocalDateTimeSerializer.class) //application/json
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime registerTime;

    /**
     * 会员生日
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)  //application/json
    @JsonSerialize(using = LocalDateTimeSerializer.class) //application/json
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

    /**
     * token 创建时间
     */
    private Long iat;

    /**
     * token 过期时间
     */
    private Long exp;

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

    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "User{" +
                "customerInfId=" + customerInfId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", identityCardType=" + identityCardType +
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
                ", iat=" + iat +
                ", exp=" + exp +
                '}';
    }
}
