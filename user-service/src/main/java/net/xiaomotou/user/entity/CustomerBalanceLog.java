package net.xiaomotou.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户余额变动表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class CustomerBalanceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 余额日志ID
     */
    @TableId(value = "balance_id", type = IdType.AUTO)
    private Integer balanceId;

    /**
     * 用户ID
     */
    private Integer customerId;

    /**
     * 记录来源：1订单，2退货单
     */
    private Integer source;

    /**
     * 相关单据ID
     */
    private Integer sourceSn;

    /**
     * 记录生成时间
     */
    private LocalDateTime createTime;

    /**
     * 变动金额
     */
    private BigDecimal amount;

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
    public Integer getSourceSn() {
        return sourceSn;
    }

    public void setSourceSn(Integer sourceSn) {
        this.sourceSn = sourceSn;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomerBalanceLog{" +
        "balanceId=" + balanceId +
        ", customerId=" + customerId +
        ", source=" + source +
        ", sourceSn=" + sourceSn +
        ", createTime=" + createTime +
        ", amount=" + amount +
        "}";
    }
}
