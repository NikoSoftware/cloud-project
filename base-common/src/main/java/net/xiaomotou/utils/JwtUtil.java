package net.xiaomotou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import org.joda.time.DateTime;

import java.util.Date;

public class JwtUtil {

    /**
     * 解密
     * @param jsonWebToken
     * @param pubKey
     * @return
     */
    public static String parseJWT(String jsonWebToken, String pubKey) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(pubKey.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(claims);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BusinessException(ExceptionEnum.AUTH_TOKEN_ERROR);
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     * @param model
     * @param priKey
     * @return
     */
    public static String createJWT(Object model, String priKey,int time) {
        ObjectMapper mapper = new ObjectMapper();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = null; //估计是第三段密钥
        try {
            builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    .setPayload(mapper.writeValueAsString(model))
                   // .setIssuedAt(new Date())
                   // .setExpiration(new DateTime().plusMinutes(time).toDate())
                    .signWith(signatureAlgorithm,priKey.getBytes());
        } catch (JsonProcessingException e) {
            throw new BusinessException(ExceptionEnum.CREATE_TOKEN_ERROR);
        }
        //生成JWT
        return builder.compact();
    }

}
