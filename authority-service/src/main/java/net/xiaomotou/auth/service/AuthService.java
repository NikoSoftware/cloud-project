package net.xiaomotou.auth.service;


import feign.FeignException;
import net.xiaomotou.auth.JwtProperties;
import net.xiaomotou.auth.client.AuthClient;
import net.xiaomotou.auth.model.User;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.utils.JsonUtils;
import net.xiaomotou.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class AuthService {

    @Autowired
    AuthClient authClient;

    @Autowired
    private JwtProperties properties;

    public String login(String userName,String password){
        User user = authClient.queryUserByNamePwd(userName,password).getBody();
        if(user==null){
            throw new BusinessException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        return createToken(user);
    }

    public String register(User userInfo,String userName, String password){
        User user = authClient.register(userInfo,userName,password).getBody();

        if(user==null){
            throw new BusinessException(ExceptionEnum.REGISTER_ERROR);
        }
        return createToken(user);
    }


    /**
     * 创建token
     * @param user
     * @return
     */
    public String createToken(User user){

        String token  = JwtUtil.createJWT(user,properties.getPriKey(),properties.getExpire());
        return token;
    }


    public User parseToken(String token){
        String claims = JwtUtil.parseJWT(token, properties.getPriKey());
        System.out.println(claims);
        return JsonUtils.parse(claims,User.class);
    }


}
