package com.gaohb.hello.study.test.pass;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author acelin
 * @createDate 2022/4/1 15:17
 */
public class ValueAndReference {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        map.put("test", list);

        List list1 = (List) map.get("test");

        System.out.println(list.toString());
        System.out.println(map.get("test").toString());


        list1.add("111");

        System.out.println(JSONObject.toJSONString(map.get("test")));
    }
}
