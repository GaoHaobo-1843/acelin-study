package com.gaohb.hello.study.basicKnowledge.extend;

/**
 * @author H
 * 2022/9/24 11:17
 */
public class LandCreature extends Creature{

    private String foot;

    public LandCreature() {
//        super();
        System.out.println("陆地生物诞生！");
    }

    public LandCreature (String foot, String header, String body  ) {
        super(header, body);
        this.foot = foot;
        System.out.println("陆地生物生成头【" + header + "】和身体【" + body + "】，长出脚【" + foot + "】");
    }

    public LandCreature(String foot) {
        this.foot = foot;
        System.out.println("陆地生物长出脚【" + foot + "】");
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
