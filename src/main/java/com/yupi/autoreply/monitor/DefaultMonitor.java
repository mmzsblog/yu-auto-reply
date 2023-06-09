package com.yupi.autoreply.monitor;

import com.yupi.autoreply.answerer.Answerer;
import com.yupi.autoreply.model.TaskListItem;

/**
 * 默认监控者
 *
 * @author
 * @from
 */
public class DefaultMonitor extends Monitor {

    public DefaultMonitor(TaskListItem taskListItem) {
        super(taskListItem);
    }

    @Override
    public void onMonitor(Answerer answerer) {
        String mockMessage = "我是一个新的消息";
        System.out.println(answerer.doAnswer(mockMessage));
    }

}
