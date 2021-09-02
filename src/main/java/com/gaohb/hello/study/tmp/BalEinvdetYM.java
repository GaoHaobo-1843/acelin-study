package com.gaohb.hello.study.tmp;

import javax.persistence.*;

@Table(name = "bal_einvdet_202101")
public class BalEinvdetYM {
    /**
     * 发票请求流水号         
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 订单号             
     */
    private String ddh;

    /**
     * 防伪码             
     */
    private String fwm;

    /**
     * 二维码             
     */
    private String ewm;

    /**
     * 开票类型            
     */
    private String kplx;

    /**
     * 发票平台pdf下载地址     
     */
    @Column(name = "pdf_url")
    private String pdfUrl;

    /**
     * 网厅pdf下载地址       
     */
    @Column(name = "wt_pdf_url")
    private String wtPdfUrl;

    /**
     * 发票pdf文件hbase存储索引
     */
    @Column(name = "hbase_rowkey")
    private String hbaseRowkey;

    /**
     * 集团名称            
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 展示名称            
     */
    @Column(name = "show_name")
    private String showName;

    /**
     * 发票接收服务号码        
     */
    @Column(name = "msg_recv_phone")
    private String msgRecvPhone;

    /**
     * 发票接收邮箱          
     */
    @Column(name = "recv_email")
    private String recvEmail;

    /**
     * 纳税人识别号          
     */
    private String bak1;

    /**
     * 开票region_id     
     */
    private String bak2;

    /**
     * 纳税人识别号          
     */
    private String nsrsbh;

    /**
     * 购货方地址           
     */
    private String ghfdz;

    /**
     * 购货方银行账户         
     */
    private String ghfyhzh;

    /**
     * 备用              
     */
    private String bak3;

    /**
     * 备用              
     */
    private String bak4;

    /**
     * 获取发票请求流水号         
     *
     * @return order_sn - 发票请求流水号         
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置发票请求流水号         
     *
     * @param orderSn 发票请求流水号         
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取订单号             
     *
     * @return ddh - 订单号             
     */
    public String getDdh() {
        return ddh;
    }

    /**
     * 设置订单号             
     *
     * @param ddh 订单号             
     */
    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    /**
     * 获取防伪码             
     *
     * @return fwm - 防伪码             
     */
    public String getFwm() {
        return fwm;
    }

    /**
     * 设置防伪码             
     *
     * @param fwm 防伪码             
     */
    public void setFwm(String fwm) {
        this.fwm = fwm;
    }

    /**
     * 获取二维码             
     *
     * @return ewm - 二维码             
     */
    public String getEwm() {
        return ewm;
    }

    /**
     * 设置二维码             
     *
     * @param ewm 二维码             
     */
    public void setEwm(String ewm) {
        this.ewm = ewm;
    }

    /**
     * 获取开票类型            
     *
     * @return kplx - 开票类型            
     */
    public String getKplx() {
        return kplx;
    }

    /**
     * 设置开票类型            
     *
     * @param kplx 开票类型            
     */
    public void setKplx(String kplx) {
        this.kplx = kplx;
    }

    /**
     * 获取发票平台pdf下载地址     
     *
     * @return pdf_url - 发票平台pdf下载地址     
     */
    public String getPdfUrl() {
        return pdfUrl;
    }

    /**
     * 设置发票平台pdf下载地址     
     *
     * @param pdfUrl 发票平台pdf下载地址     
     */
    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    /**
     * 获取网厅pdf下载地址       
     *
     * @return wt_pdf_url - 网厅pdf下载地址       
     */
    public String getWtPdfUrl() {
        return wtPdfUrl;
    }

    /**
     * 设置网厅pdf下载地址       
     *
     * @param wtPdfUrl 网厅pdf下载地址       
     */
    public void setWtPdfUrl(String wtPdfUrl) {
        this.wtPdfUrl = wtPdfUrl;
    }

    /**
     * 获取发票pdf文件hbase存储索引
     *
     * @return hbase_rowkey - 发票pdf文件hbase存储索引
     */
    public String getHbaseRowkey() {
        return hbaseRowkey;
    }

    /**
     * 设置发票pdf文件hbase存储索引
     *
     * @param hbaseRowkey 发票pdf文件hbase存储索引
     */
    public void setHbaseRowkey(String hbaseRowkey) {
        this.hbaseRowkey = hbaseRowkey;
    }

    /**
     * 获取集团名称            
     *
     * @return unit_name - 集团名称            
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置集团名称            
     *
     * @param unitName 集团名称            
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取展示名称            
     *
     * @return show_name - 展示名称            
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 设置展示名称            
     *
     * @param showName 展示名称            
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * 获取发票接收服务号码        
     *
     * @return msg_recv_phone - 发票接收服务号码        
     */
    public String getMsgRecvPhone() {
        return msgRecvPhone;
    }

    /**
     * 设置发票接收服务号码        
     *
     * @param msgRecvPhone 发票接收服务号码        
     */
    public void setMsgRecvPhone(String msgRecvPhone) {
        this.msgRecvPhone = msgRecvPhone;
    }

    /**
     * 获取发票接收邮箱          
     *
     * @return recv_email - 发票接收邮箱          
     */
    public String getRecvEmail() {
        return recvEmail;
    }

    /**
     * 设置发票接收邮箱          
     *
     * @param recvEmail 发票接收邮箱          
     */
    public void setRecvEmail(String recvEmail) {
        this.recvEmail = recvEmail;
    }

    /**
     * 获取纳税人识别号          
     *
     * @return bak1 - 纳税人识别号          
     */
    public String getBak1() {
        return bak1;
    }

    /**
     * 设置纳税人识别号          
     *
     * @param bak1 纳税人识别号          
     */
    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    /**
     * 获取开票region_id     
     *
     * @return bak2 - 开票region_id     
     */
    public String getBak2() {
        return bak2;
    }

    /**
     * 设置开票region_id     
     *
     * @param bak2 开票region_id     
     */
    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    /**
     * 获取纳税人识别号          
     *
     * @return nsrsbh - 纳税人识别号          
     */
    public String getNsrsbh() {
        return nsrsbh;
    }

    /**
     * 设置纳税人识别号          
     *
     * @param nsrsbh 纳税人识别号          
     */
    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    /**
     * 获取购货方地址           
     *
     * @return ghfdz - 购货方地址           
     */
    public String getGhfdz() {
        return ghfdz;
    }

    /**
     * 设置购货方地址           
     *
     * @param ghfdz 购货方地址           
     */
    public void setGhfdz(String ghfdz) {
        this.ghfdz = ghfdz;
    }

    /**
     * 获取购货方银行账户         
     *
     * @return ghfyhzh - 购货方银行账户         
     */
    public String getGhfyhzh() {
        return ghfyhzh;
    }

    /**
     * 设置购货方银行账户         
     *
     * @param ghfyhzh 购货方银行账户         
     */
    public void setGhfyhzh(String ghfyhzh) {
        this.ghfyhzh = ghfyhzh;
    }

    /**
     * 获取备用              
     *
     * @return bak3 - 备用              
     */
    public String getBak3() {
        return bak3;
    }

    /**
     * 设置备用              
     *
     * @param bak3 备用              
     */
    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    /**
     * 获取备用              
     *
     * @return bak4 - 备用              
     */
    public String getBak4() {
        return bak4;
    }

    /**
     * 设置备用              
     *
     * @param bak4 备用              
     */
    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }
}