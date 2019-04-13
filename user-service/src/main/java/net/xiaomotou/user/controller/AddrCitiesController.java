package net.xiaomotou.user.controller;


import net.xiaomotou.user.entity.AddrCities;
import net.xiaomotou.user.entity.CityAndArea;
import net.xiaomotou.user.service.impl.AddrCitiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 城市信息表 前端控制器
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
@RestController
@RequestMapping("/addr-cities")
public class AddrCitiesController {

    @Autowired
    AddrCitiesServiceImpl addrCitiesService;



    @GetMapping("/getCityArea")
    public ResponseEntity<HashMap<Integer, AddrCities>> getAllCityAreaByProvince(int id){

        return ResponseEntity.ok(addrCitiesService.getAllCityAreaByProvince(id));
    }


}
