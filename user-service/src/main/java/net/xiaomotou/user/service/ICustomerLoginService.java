package net.xiaomotou.user.service;

import net.xiaomotou.user.entity.CustomerInf;
import net.xiaomotou.user.entity.CustomerLogin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
public interface ICustomerLoginService extends IService<CustomerLogin> {

    ResponseEntity<CustomerInf> customerLogin(String userName, String Password);

    ResponseEntity<CustomerInf> customerRegister(CustomerInf  customerInf,String userName, String password);

    void removeUser(String userName);

}
