package com.yupi.autoreply.factory;

import com.yupi.autoreply.answerer.Answerer;
import com.yupi.autoreply.answerer.DefaultAnswerer;
import com.yupi.autoreply.answerer.OpenAiAnswerer;

/**
 * 回答者工厂
 *
 * @author
 * @from
 */
public class AnswererFactory {

    /**
     * 创建回答者
     *
     * @param answerer
     * @return
     */
    public static Answerer createAnswerer(String answerer) {
        switch (answerer) {
            case "openai":
                return new OpenAiAnswerer();
            default:
                return new DefaultAnswerer();
        }
    }
}
