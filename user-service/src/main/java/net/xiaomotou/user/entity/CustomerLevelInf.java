package net.xiaomotou.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户级别信息表
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public class CustomerLevelInf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员级别ID
     */
    @TableId(value = "customer_level", type = IdType.AUTO)
    private Integer customerLevel;

    /**
     * 会员级别名称
     */
    private String levelName;

    /**
     * 该级别最低积分
     */
    private Integer minPoint;

    /**
     * 该级别最高积分
     */
    private Integer maxPoint;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    public Integer getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Integer minPoint) {
        this.minPoint = minPoint;
    }
    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CustomerLevelInf{" +
        "customerLevel=" + customerLevel +
        ", levelName=" + levelName +
        ", minPoint=" + minPoint +
        ", maxPoint=" + maxPoint +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
