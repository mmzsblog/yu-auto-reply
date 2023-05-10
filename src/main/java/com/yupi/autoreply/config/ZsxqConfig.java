package com.yupi.autoreply.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 知识星球配置
 *
 * @author
 * @from
 */
@Configuration
@ConfigurationProperties(prefix = "zsxq")
@Data
public class ZsxqConfig {

    /**
     * 登录 cookie
     */
    private String cookie;

    /**
     * 星球 id
     */
    private String groupId;

    /**
     * 是否提醒提问者
     */
    private Boolean silenced = true;
}
