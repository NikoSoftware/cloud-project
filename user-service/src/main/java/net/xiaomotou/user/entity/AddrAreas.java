package net.xiaomotou.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 区县信息表
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
public class AddrAreas implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 区县编码
     */
    private String areaid;

    /**
     * 区县名称
     */
    private String area;

    /**
     * 所属城市编码
     */
    private String cityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public String toString() {
        return "AddrAreas{" +
        "id=" + id +
        ", areaid=" + areaid +
        ", area=" + area +
        ", cityid=" + cityid +
        "}";
    }
}
