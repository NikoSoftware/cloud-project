package net.xiaomotou.user.service.impl;

import net.xiaomotou.user.entity.CustomerBalanceLog;
import net.xiaomotou.user.mapper.CustomerBalanceLogMapper;
import net.xiaomotou.user.service.ICustomerBalanceLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户余额变动表 服务实现类
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
@Service
public class CustomerBalanceLogServiceImpl extends ServiceImpl<CustomerBalanceLogMapper, CustomerBalanceLog> implements ICustomerBalanceLogService {

}
