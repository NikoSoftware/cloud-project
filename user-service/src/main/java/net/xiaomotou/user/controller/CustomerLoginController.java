package net.xiaomotou.user.controller;


import net.xiaomotou.user.entity.CustomerInf;
import net.xiaomotou.user.service.impl.CustomerLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/customer-login")
public class CustomerLoginController {


    @Autowired
    CustomerLoginServiceImpl CustomerLoginServiceImpl;

    @GetMapping("/login")
    public ResponseEntity<CustomerInf> login(String userName,String password){

        return CustomerLoginServiceImpl.customerLogin(userName,password);
    }


    @PostMapping("/register")
    public ResponseEntity<CustomerInf> login(CustomerInf customerInf,String userName, String password){

        return CustomerLoginServiceImpl.customerRegister(customerInf,userName,password);
    }


}
