package net.xiaomotou;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = "net.xiaomotou.user")
public class UserService {

    public static void main(String[] args) {
        SpringApplication.run(UserService.class);
    }


}
