package com.yupi.autoreply.answerer;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yupi.autoreply.api.openai.OpenAiApi;
import com.yupi.autoreply.api.openai.model.CreateCompletionRequest;
import com.yupi.autoreply.api.openai.model.CreateCompletionResponse;
import com.yupi.autoreply.config.OpenAiConfig;
import com.yupi.autoreply.config.ZsxqConfig;
import com.yupi.autoreply.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.json.JSONUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OpenAi 回答者
 *
 * @author
 * @from
 */
@Slf4j
public class OpenAiAnswerer implements Answerer {

    private final OpenAiApi openAiApi = SpringContextUtils.getBean(OpenAiApi.class);

    private final OpenAiConfig openAiConfig = SpringContextUtils.getBean(OpenAiConfig.class);

    @Override
    public String doAnswer(String prompt) {
        HttpRequest httpRequest = HttpRequest.get("https://api.openai.com/v1/models");
        log.info("================================");
        log.info("OpenAi响应可用模型是：" + JSONUtil.toJsonStr(httpRequest));
        log.info("================================");


        CreateCompletionRequest request = new CreateCompletionRequest();
        request.setPrompt(prompt);
        request.setModel(openAiConfig.getModel());
        request.setTemperature(0);
        request.setMax_tokens(1024);
        CreateCompletionResponse response = openAiApi.createCompletion(request, openAiConfig.getApiKey());
        log.info("================================");
        log.info("OpenAi响应结果是：" + JSONUtil.toJsonStr(response));
        log.info("================================");
        if (StrUtil.isBlank(JSONUtil.toJsonStr(response))) {
            return "";
        }
        List<CreateCompletionResponse.ChoicesItem> choicesItemList = response.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletionResponse.ChoicesItem::getText)
                .collect(Collectors.joining());
        log.info("OpenAiAnswerer 回答成功 \n 答案：{}", answer);
        return answer;
    }
}
