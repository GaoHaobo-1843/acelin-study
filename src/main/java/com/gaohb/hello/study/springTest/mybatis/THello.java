package com.gaohb.hello.study.springTest.mybatis;

import javax.persistence.*;

@Table(name = "t_hello")
public class THello {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Integer pk;

    private String col1;

    private String col2;

    /**
     * @return pk
     */
    public Integer getPk() {
        return pk;
    }

    /**
     * @param pk
     */
    public void setPk(Integer pk) {
        this.pk = pk;
    }

    /**
     * @return col1
     */
    public String getCol1() {
        return col1;
    }

    /**
     * @param col1
     */
    public void setCol1(String col1) {
        this.col1 = col1;
    }

    /**
     * @return col2
     */
    public String getCol2() {
        return col2;
    }

    /**
     * @param col2
     */
    public void setCol2(String col2) {
        this.col2 = col2;
    }

    @Override
    public String toString() {
        return "THello{" +
                "pk=" + pk +
                ", col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}