package net.xiaomotou.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpConfig {

    private String host;
    private String username;
    private String password;
    private int port;
    private String fileUpdatePath;

}
