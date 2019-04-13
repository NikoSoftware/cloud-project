package net.xiaomotou.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 城市信息表
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
public class AddrCities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 城市编码
     */
    private String cityid;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 所属省份编码
     */
    private String provinceid;

    /**
     * 区域详情
     */
    private List<AddrAreas> areasList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public List<AddrAreas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<AddrAreas> areasList) {
        this.areasList = areasList;
    }

    @Override
    public String toString() {
        return "AddrCities{" +
                "id=" + id +
                ", cityid='" + cityid + '\'' +
                ", city='" + city + '\'' +
                ", provinceid='" + provinceid + '\'' +
                ", areasList=" + areasList +
                '}';
    }
}
