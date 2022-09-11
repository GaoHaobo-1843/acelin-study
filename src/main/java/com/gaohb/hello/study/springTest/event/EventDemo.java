package com.gaohb.hello.study.springTest.event;

import org.springframework.context.ApplicationEvent;

/**
 * <Description><br>
 *
 * @author acelin<br>
 * @CreateDate 2022/4/11 15:08<br>
 * @see com.gaohb.hello.study.springTest.event <br>
 * @since R9.0<br>
 */
public class EventDemo extends ApplicationEvent {

    private String message;
    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}