package net.xiaomotou.user.service.impl;

import net.xiaomotou.user.entity.AddrAreas;
import net.xiaomotou.user.entity.AddrCities;
import net.xiaomotou.user.entity.AddrProvinces;
import net.xiaomotou.user.entity.CityAndArea;
import net.xiaomotou.user.mapper.AddrCitiesMapper;
import net.xiaomotou.user.service.IAddrCitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 城市信息表 服务实现类
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
@Service
public class AddrCitiesServiceImpl extends ServiceImpl<AddrCitiesMapper, AddrCities> implements IAddrCitiesService {

    @Autowired
    AddrCitiesMapper addrCitiesMapper;

    @Override
    public  HashMap<Integer,AddrCities> getAllCityAreaByProvince(int provinceId) {
        List<CityAndArea> cityAndAreaList = addrCitiesMapper.getAllCityAreaByProvince(provinceId);
        HashMap<Integer,AddrCities> cityMap = new HashMap<>();
        for (CityAndArea cityAndArea : cityAndAreaList) {
            if(cityMap.get(Integer.valueOf(cityAndArea.getCityid()))==null){
                AddrCities addrCities = new AddrCities();
                addrCities.setCityid(cityAndArea.getCityid());
                addrCities.setCity(cityAndArea.getCity());
                addrCities.setProvinceid(cityAndArea.getProvinceid());
                cityMap.put(Integer.valueOf(cityAndArea.getCityid()),addrCities);
            }
            AddrCities addrCities = cityMap.get(Integer.valueOf(cityAndArea.getCityid()));
            if(addrCities.getAreasList()==null){
                addrCities.setAreasList(new ArrayList<>());
            }
            AddrAreas addrAreas = new AddrAreas();
            addrAreas.setCityid(cityAndArea.getCityid());
            addrAreas.setArea(cityAndArea.getArea());
            addrAreas.setAreaid(cityAndArea.getAreaid());
            addrCities.getAreasList().add(addrAreas);
        }

        return cityMap;
    }
}
