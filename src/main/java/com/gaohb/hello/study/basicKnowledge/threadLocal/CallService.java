package com.gaohb.hello.study.basicKnowledge.threadLocal;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <Description><br>
 *
 * @author acelin <br>
 * @CreateDate 2022/3/23 12:14<br>
 * @see com.gaohb.hello.study.basicKnowledge.threadLocal <br>
 * @since R9.0<br>
 */
public class CallService {

    //用户编号创建器
    private static final AtomicInteger creator = new AtomicInteger(1);
    //备选生日
    private static final LocalDate[] birthdays = {LocalDate.of(1988, 9, 11),
            LocalDate.of(1989, 11, 10),
            LocalDate.of(1990, 3, 7),
            LocalDate.of(1995, 7, 26),
            LocalDate.of(2000, 10, 1)
    };
    private static final int birthdayLength = birthdays.length;

    public static void main(String[] args) {
        UserService userService = new UserService();
        //同时10个调用
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                UserContext.set(initUser(Thread.currentThread().getName()));
                //进行调用
                userService.addUser();
            }, "callService-" + i).start();
        }
    }

    /**
     * 初始化用户信息(模拟请求)
     * @param name  -- 用户名
     * @return  -- 用户信息
     */
    private static User initUser(String name) {
        User user = new User();
        user.setUserId(creator.getAndIncrement());
        user.setName(name);
        user.setBirthday(birthdays[user.getUserId() % birthdayLength]);
        return user;
    }

}
