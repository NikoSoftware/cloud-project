package net.xiaomotou.custom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("user-server")
public interface CustomClient {


    @RequestMapping(method = RequestMethod.GET,path = "/user")
    String getQueryById(@RequestParam("id") Integer id);

}
