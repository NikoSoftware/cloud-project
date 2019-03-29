package net.xiaomotou.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "filter")
public class FilterProperties {

    private List<String> allowPaths;
}
