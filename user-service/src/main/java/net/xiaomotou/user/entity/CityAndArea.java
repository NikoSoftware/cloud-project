package net.xiaomotou.user.entity;

import lombok.Data;

@Data
public class CityAndArea {


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
     * 区县编码
     */
    private String areaid;

    /**
     * 区县名称
     */
    private String area;





}
