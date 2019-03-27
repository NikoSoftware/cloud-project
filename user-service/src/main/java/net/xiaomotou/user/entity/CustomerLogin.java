package net.xiaomotou.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class CustomerLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * md5加密的密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer userStats;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUserStats() {
        return userStats;
    }

    public void setUserStats(Integer userStats) {
        this.userStats = userStats;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CustomerLogin{" +
        "customerId=" + customerId +
        ", loginName=" + loginName +
        ", password=" + password +
        ", userStats=" + userStats +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
