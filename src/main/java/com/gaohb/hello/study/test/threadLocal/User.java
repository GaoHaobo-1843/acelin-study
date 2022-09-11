package com.gaohb.hello.study.test.threadLocal;

import lombok.Data;

import java.time.LocalDate;

/**
 * <Description><br>
 *
 * @author acelin <br>
 * @CreateDate 2022/3/23 12:11<br>
 * @see com.gaohb.hello.study.test.threadLocal <br>
 * @since R9.0<br>
 */

@Data
public class User {
    private Integer userId;
    private String name;
    private LocalDate birthday;
}

