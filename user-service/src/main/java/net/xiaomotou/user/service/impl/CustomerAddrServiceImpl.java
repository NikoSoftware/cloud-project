package net.xiaomotou.user.service.impl;

import net.xiaomotou.user.entity.CustomerAddr;
import net.xiaomotou.user.mapper.CustomerAddrMapper;
import net.xiaomotou.user.service.ICustomerAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author niko
 * @since 2019-03-27
 */
@Service
public class CustomerAddrServiceImpl extends ServiceImpl<CustomerAddrMapper, CustomerAddr> implements ICustomerAddrService {

}
