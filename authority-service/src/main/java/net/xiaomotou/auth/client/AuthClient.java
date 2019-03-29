package net.xiaomotou.auth.client;


import net.xiaomotou.auth.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface AuthClient {

    @RequestMapping(method = RequestMethod.GET,path = "/customer-login/login")
    ResponseEntity<User> queryUserByNamePwd(@RequestParam("userName")String userName,
                                            @RequestParam("password")String password);

    @RequestMapping(method = RequestMethod.POST,path = "/customer-login/register")
    ResponseEntity<User> register(@RequestBody User customerInf, @RequestParam("userName") String userName,@RequestParam("password") String password);

}
