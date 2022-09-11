package com.gaohb.hello.study.springTest.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <Description><br>
 *
 * @author acelin<br>
 * @CreateDate 2022/4/11 15:09<br>
 * @see com.gaohb.hello.study.springTest.event <br>
 * @since R9.0<br>
 */
@Component
public class EventDemoListener implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("receiver " + event.getMessage());
    }
}
