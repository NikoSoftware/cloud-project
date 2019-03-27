package net.xiaomotou.user.service.impl;

import net.xiaomotou.user.entity.CustomerLoginLog;
import net.xiaomotou.user.mapper.CustomerLoginLogMapper;
import net.xiaomotou.user.service.ICustomerLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登陆日志表 服务实现类
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
@Service
public class CustomerLoginLogServiceImpl extends ServiceImpl<CustomerLoginLogMapper, CustomerLoginLog> implements ICustomerLoginLogService {

}
