package com.gaohb.hello.study.basicKnowledge.threadLocal;

/**
 * <Description><br>
 *
 * @author acelin <br>
 * @CreateDate 2022/3/23 12:13<br>
 * @see com.gaohb.hello.study.basicKnowledge.threadLocal <br>
 * @since R9.0<br>
 */
public class UserService {

    /**
     * 执行添加用户
     */
    public void addUser() {
        System.out.println(Thread.currentThread().getName() + "添加用户信息:" + UserContext.get());
    }

}
