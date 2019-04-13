package net.xiaomotou.user.mapper;

import net.xiaomotou.user.entity.AddrCities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.xiaomotou.user.entity.AddrProvinces;
import net.xiaomotou.user.entity.CityAndArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 城市信息表 Mapper 接口
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
public interface AddrCitiesMapper extends BaseMapper<AddrCities> {

    @Select(" select addr_cities.*, addr_areas.* FROM addr_cities JOIN addr_areas WHERE addr_cities.cityid = addr_areas.cityid AND addr_cities.provinceid = #{provinceId}")
    List<CityAndArea> getAllCityAreaByProvince(@Param("provinceId")int provinceId);

}
