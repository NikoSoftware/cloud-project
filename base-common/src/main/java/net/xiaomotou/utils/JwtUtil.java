package net.xiaomotou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    /**
     * 解密
     *
     * @param jsonWebToken
     * @param pubKey
     * @return
     */
    public static <T> T parseJWT(String jsonWebToken, String pubKey, Class<T> tClass) throws Exception {
        Claims claims = Jwts.parser()
                .setSigningKey(pubKey.getBytes())
                .parseClaimsJws(jsonWebToken).getBody();
        ObjectMapper mapper = new ObjectMapper();

        return JsonUtils.parse(mapper.writeValueAsString(claims), tClass);

    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     *
     * @param model
     * @param priKey
     * @return
     */
    public static String createJWT(Object model, String priKey, int time) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> hashMap = new HashMap<>();


        try {
            String user = objectMapper.writeValueAsString(model);
            hashMap = JsonUtils.parseMap(user, String.class, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setClaims(hashMap)
                .setIssuedAt(new Date())
                .setExpiration(new DateTime().plusMinutes(time).toDate())
                .signWith(signatureAlgorithm, priKey.getBytes());

        //生成JWT
        return builder.compact();
    }

}
