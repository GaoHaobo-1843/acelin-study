package com.gaohb.hello.study.springTest.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <Description><br>
 *
 * @author acelin<br>
 * @CreateDate 2022/4/11 15:10<br>
 * @see com.gaohb.hello.study.springTest.event <br>
 * @since R9.0<br>
 */
@Component
public class EventDemoPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        EventDemo demo = new EventDemo(this, message);
        applicationEventPublisher.publishEvent(demo);
    }
}

