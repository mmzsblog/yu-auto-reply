package com.yupi.autoreply.config;

import com.yupi.autoreply.api.openai.model.ModelConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAi 配置
 *
 * @author
 * @from
 */
@Configuration
@ConfigurationProperties(prefix = "openai")
@Data
public class OpenAiConfig {

    /**
     * 模型
     */
    private String model = ModelConstant.TEXT_DAVINCI_003;

    /**
     * apiKey
     */
    private String apiKey;
}
