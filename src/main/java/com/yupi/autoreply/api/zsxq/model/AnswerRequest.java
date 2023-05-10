package com.yupi.autoreply.api.zsxq.model;

import lombok.Data;

import java.util.List;

/**
 * 回答请求
 *
 * @author
 * @from
 */
@Data
public class AnswerRequest {

    private String topicId;

    private ReqData req_data;

    @Data
    public static class ReqData {

        private String text;

        private List<String> image_ids;

        private Boolean silenced;
    }
}
