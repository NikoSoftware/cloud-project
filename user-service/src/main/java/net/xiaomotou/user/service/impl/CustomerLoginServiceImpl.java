package net.xiaomotou.user.service.impl;

import net.xiaomotou.user.entity.CustomerLogin;
import net.xiaomotou.user.mapper.CustomerLoginMapper;
import net.xiaomotou.user.service.ICustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements ICustomerLoginService {

}
