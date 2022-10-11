package com.gaohb.hello.study.basicKnowledge.extend;

/**
 * @author H
 * 2022/9/24 11:14
 */
public abstract class Creature {

    private String header;

    private String Body;

    public Creature() {
        System.out.println("生物诞生！");
    }

    public Creature(String header, String body) {
        this.header = header;
        this.Body = body;
        System.out.println("生物诞生！生成头【" + header + "】和身体【" + body + "】");

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
