package net.xiaomotou.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户登陆日志表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class CustomerLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登陆日志ID
     */
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    /**
     * 登陆用户ID
     */
    private Integer customerId;

    /**
     * 用户登陆时间
     */
    private LocalDateTime loginTime;

    /**
     * 登陆IP
     */
    private Integer loginIp;

    /**
     * 登陆类型：0未成功，1成功
     */
    private Integer loginType;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
    public Integer getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Integer loginIp) {
        this.loginIp = loginIp;
    }
    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "CustomerLoginLog{" +
        "loginId=" + loginId +
        ", customerId=" + customerId +
        ", loginTime=" + loginTime +
        ", loginIp=" + loginIp +
        ", loginType=" + loginType +
        "}";
    }
}
