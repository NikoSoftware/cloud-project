package net.xiaomotou.user.controller;


import net.xiaomotou.user.entity.AddrProvinces;
import net.xiaomotou.user.service.impl.AddrProvincesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author niko
 * @since 2019-03-31
 */
@RestController
@RequestMapping("/addr-provinces")
public class AddrProvincesController {

    @Autowired
    AddrProvincesServiceImpl addrProvincesService;

    @GetMapping("/getProvinces")
    public ResponseEntity<List<AddrProvinces>> getProvinces() {

        return ResponseEntity.ok(addrProvincesService.list());
    }


}
