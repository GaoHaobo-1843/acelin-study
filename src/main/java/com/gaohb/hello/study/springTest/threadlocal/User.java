package com.gaohb.hello.study.springTest.threadlocal;

import com.gaohb.hello.study.springTest.cache.LocalData;
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
public class User extends LocalData {
    private Integer userId;
    private String name;
    private LocalDate birthday;
}

