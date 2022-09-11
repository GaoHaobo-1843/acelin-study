package com.gaohb.hello.study.springTest.threadlocal;

/**
 * <Description><br>
 *
 * @author acelin <br>
 * @CreateDate 2022/3/23 12:10<br>
 * @see com.gaohb.hello.study.test.threadLocal <br>
 * @since R9.0<br>
 */
public class UserContext {

    private static final ThreadLocal<User> context = new ThreadLocal<>();

    /**
     * 设置用户信息
     * @param user  -- 用户信息
     */
    public static void set(User user) {
        context.set(user);
    }

    /**
     * 获取用户信息
     * @return -- 用户信息
     */
    public static User get() {
        return context.get();
    }

    /**
     * 移除用户信息
     */
    public static void remove() {
        context.remove();
    }

}
