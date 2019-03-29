package net.xiaomotou.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.user.entity.CustomerInf;
import net.xiaomotou.user.entity.CustomerLogin;
import net.xiaomotou.user.mapper.CustomerInfMapper;
import net.xiaomotou.user.mapper.CustomerLoginMapper;
import net.xiaomotou.user.service.ICustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.xiaomotou.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;


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


    @Autowired
    CustomerLoginMapper customerLoginMapper;

    @Autowired
    CustomerInfMapper customerInfMapper;

    @Override
    public ResponseEntity<CustomerInf> customerLogin(String userName, String password) {

        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userName);
        CustomerLogin customerLogin = customerLoginMapper.selectOne(queryWrapper);
        if(customerLogin==null){
            throw new BusinessException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        if(DigestUtils.md5DigestAsHex((customerLogin.getSalt()+password).getBytes())
                .toLowerCase().equals(customerLogin.getPassword())){
            QueryWrapper<CustomerInf> wrapper = new QueryWrapper<>();
            wrapper.eq("customer_id",customerLogin.getCustomerId());
           return ResponseEntity.ok(customerInfMapper.selectOne(wrapper));
        }else{
            throw new BusinessException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<CustomerInf> customerRegister(CustomerInf customerInf,String userName, String password) {


        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName(userName);
        String salt = NumberUtils.randomCode(4).toLowerCase();
        customerLogin.setSalt(salt);
        password = DigestUtils.md5DigestAsHex((customerLogin.getSalt()+password).getBytes()).toLowerCase();
        customerLogin.setPassword(password);
        try {
            customerLoginMapper.insert(customerLogin);
        }catch (Exception e){
            throw new BusinessException(ExceptionEnum.USER_NAME_DUPLICATE);
        }
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userName);
        customerLogin = customerLoginMapper.selectOne(queryWrapper);
        customerInf.setCustomerId(customerLogin.getCustomerId());
        if(StringUtils.isEmpty(customerInf.getCustomerName())) {
            customerInf.setCustomerName(customerLogin.getLoginName());
        }
        customerInf.setRegisterTime(LocalDateTime.now());
        customerInf.setModifiedTime(LocalDateTime.now());
        customerInfMapper.insert(customerInf);

        return ResponseEntity.ok(customerInf);
    }

    @Override
    @Transactional
    public void removeUser(String userName) {
        CustomerLogin customerLogin =null;
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userName);
        customerLogin = customerLoginMapper.selectOne(queryWrapper);
        if(customerLogin==null){
            return;
        }
        QueryWrapper<CustomerInf> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",customerLogin.getCustomerId());
        customerInfMapper.delete(wrapper);
        customerLoginMapper.delete(queryWrapper);
    }


}
