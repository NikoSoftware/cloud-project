package net.xiaomotou.user.service;

import net.xiaomotou.user.entity.AddrCities;
import com.baomidou.mybatisplus.extension.service.IService;
import net.xiaomotou.user.entity.AddrProvinces;
import net.xiaomotou.user.entity.CityAndArea;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 城市信息表 服务类
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
public interface IAddrCitiesService extends IService<AddrCities> {

    HashMap<Integer,AddrCities> getAllCityAreaByProvince(@Param("provinceId")int provinceId);

}
