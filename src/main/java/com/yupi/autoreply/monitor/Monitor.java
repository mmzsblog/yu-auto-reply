package com.yupi.autoreply.monitor;

import com.yupi.autoreply.answerer.Answerer;
import com.yupi.autoreply.model.TaskListItem;

/**
 * 抽象监控者
 *
 * @author
 * @from
 */
public abstract class Monitor {

    TaskListItem taskListItem;

    Monitor(TaskListItem taskListItem) {
        this.taskListItem = taskListItem;
    }

    /**
     * 触发监控
     *
     * @param answerer
     */
    public abstract void onMonitor(Answerer answerer);
}
