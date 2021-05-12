package com.linzlb.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/5/12 13:51
 * @Function:
 */
public class SendSmsEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SendSmsEvent(Object source) {
        super(source);
    }
}
