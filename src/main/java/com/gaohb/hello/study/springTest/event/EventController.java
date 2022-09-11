package com.gaohb.hello.study.springTest.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description><br>
 *
 * @author acelin<br>
 * @CreateDate 2022/4/11 15:12<br>
 * @see com.gaohb.hello.study.springTest.event <br>
 * @since R9.0<br>
 */
@RestController
public class EventController {

    @Autowired
    private EventDemoPublish eventDemoPublish;

    @RequestMapping("/event")
    public void testEvent(){
        eventDemoPublish.publish("event 1");
    }
}
