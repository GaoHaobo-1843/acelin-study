package com.gaohb.hello.study.tmp;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bal_invprint_202101")
public class BalInvprintYM {
    /**
     * 打印流水号     
     */
    @Column(name = "print_sn")
    private Long printSn;

    /**
     * 打印数组      
     */
    @Column(name = "print_array")
    private Short printArray;

    /**
     * 服务号码      
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 客户编码      
     */
    @Column(name = "cust_id")
    private Long custId;

    /**
     * 用户ID      
     */
    @Column(name = "id_no")
    private Long idNo;

    /**
     * 账户号码      
     */
    @Column(name = "contract_no")
    private Long contractNo;

    /**
     * 账期        
     */
    @Column(name = "bill_cycle")
    private Integer billCycle;

    /**
     * 发票号码      
     */
    @Column(name = "inv_no")
    private String invNo;

    /**
     * 发票代码      
     */
    @Column(name = "inv_code")
    private String invCode;

    /**
     * IP地址      
     */
    @Column(name = "tcm_code")
    private String tcmCode;

    /**
     * 冲红发票请求流水编号
     */
    @Column(name = "inv_rel_no")
    private String invRelNo;

    /**
     * 发票状态      
     */
    private String state;

    /**
     * 发票类型      
     */
    @Column(name = "inv_type")
    private String invType;

    /**
     * 缴费流水号     
     */
    @Column(name = "pay_sn")
    private Long paySn;

    /**
     * 打印总金额     
     */
    @Column(name = "total_fee")
    private Long totalFee;

    /**
     * 税率        
     */
    @Column(name = "tax_rate")
    private Float taxRate;

    /**
     * 税额        
     */
    @Column(name = "tax_fee")
    private Long taxFee;

    /**
     * 打印金额      
     */
    @Column(name = "print_fee")
    private Long printFee;

    /**
     * 打印次数      
     */
    @Column(name = "print_num")
    private Short printNum;

    /**
     * 操作工号      
     */
    @Column(name = "login_no")
    private String loginNo;

    /**
     * 操作地市代码    
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 操作模块代码    
     */
    @Column(name = "op_code")
    private String opCode;

    /**
     * 操作日期      
     */
    @Column(name = "total_date")
    private Integer totalDate;

    /**
     * 操作时间      
     */
    @Column(name = "op_time")
    private Date opTime;

    /**
     * 备注        
     */
    private String remark;

    /**
     * 发票请求流水编号  
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 数据来源      
     */
    @Column(name = "data_source")
    private String dataSource;

    /**
     * 获取打印流水号     
     *
     * @return print_sn - 打印流水号     
     */
    public Long getPrintSn() {
        return printSn;
    }

    /**
     * 设置打印流水号     
     *
     * @param printSn 打印流水号     
     */
    public void setPrintSn(Long printSn) {
        this.printSn = printSn;
    }

    /**
     * 获取打印数组      
     *
     * @return print_array - 打印数组      
     */
    public Short getPrintArray() {
        return printArray;
    }

    /**
     * 设置打印数组      
     *
     * @param printArray 打印数组      
     */
    public void setPrintArray(Short printArray) {
        this.printArray = printArray;
    }

    /**
     * 获取服务号码      
     *
     * @return phone_no - 服务号码      
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置服务号码      
     *
     * @param phoneNo 服务号码      
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取客户编码      
     *
     * @return cust_id - 客户编码      
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * 设置客户编码      
     *
     * @param custId 客户编码      
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * 获取用户ID      
     *
     * @return id_no - 用户ID      
     */
    public Long getIdNo() {
        return idNo;
    }

    /**
     * 设置用户ID      
     *
     * @param idNo 用户ID      
     */
    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取账户号码      
     *
     * @return contract_no - 账户号码      
     */
    public Long getContractNo() {
        return contractNo;
    }

    /**
     * 设置账户号码      
     *
     * @param contractNo 账户号码      
     */
    public void setContractNo(Long contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * 获取账期        
     *
     * @return bill_cycle - 账期        
     */
    public Integer getBillCycle() {
        return billCycle;
    }

    /**
     * 设置账期        
     *
     * @param billCycle 账期        
     */
    public void setBillCycle(Integer billCycle) {
        this.billCycle = billCycle;
    }

    /**
     * 获取发票号码      
     *
     * @return inv_no - 发票号码      
     */
    public String getInvNo() {
        return invNo;
    }

    /**
     * 设置发票号码      
     *
     * @param invNo 发票号码      
     */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
     * 获取发票代码      
     *
     * @return inv_code - 发票代码      
     */
    public String getInvCode() {
        return invCode;
    }

    /**
     * 设置发票代码      
     *
     * @param invCode 发票代码      
     */
    public void setInvCode(String invCode) {
        this.invCode = invCode;
    }

    /**
     * 获取IP地址      
     *
     * @return tcm_code - IP地址      
     */
    public String getTcmCode() {
        return tcmCode;
    }

    /**
     * 设置IP地址      
     *
     * @param tcmCode IP地址      
     */
    public void setTcmCode(String tcmCode) {
        this.tcmCode = tcmCode;
    }

    /**
     * 获取冲红发票请求流水编号
     *
     * @return inv_rel_no - 冲红发票请求流水编号
     */
    public String getInvRelNo() {
        return invRelNo;
    }

    /**
     * 设置冲红发票请求流水编号
     *
     * @param invRelNo 冲红发票请求流水编号
     */
    public void setInvRelNo(String invRelNo) {
        this.invRelNo = invRelNo;
    }

    /**
     * 获取发票状态      
     *
     * @return state - 发票状态      
     */
    public String getState() {
        return state;
    }

    /**
     * 设置发票状态      
     *
     * @param state 发票状态      
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取发票类型      
     *
     * @return inv_type - 发票类型      
     */
    public String getInvType() {
        return invType;
    }

    /**
     * 设置发票类型      
     *
     * @param invType 发票类型      
     */
    public void setInvType(String invType) {
        this.invType = invType;
    }

    /**
     * 获取缴费流水号     
     *
     * @return pay_sn - 缴费流水号     
     */
    public Long getPaySn() {
        return paySn;
    }

    /**
     * 设置缴费流水号     
     *
     * @param paySn 缴费流水号     
     */
    public void setPaySn(Long paySn) {
        this.paySn = paySn;
    }

    /**
     * 获取打印总金额     
     *
     * @return total_fee - 打印总金额     
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * 设置打印总金额     
     *
     * @param totalFee 打印总金额     
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取税率        
     *
     * @return tax_rate - 税率        
     */
    public Float getTaxRate() {
        return taxRate;
    }

    /**
     * 设置税率        
     *
     * @param taxRate 税率        
     */
    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * 获取税额        
     *
     * @return tax_fee - 税额        
     */
    public Long getTaxFee() {
        return taxFee;
    }

    /**
     * 设置税额        
     *
     * @param taxFee 税额        
     */
    public void setTaxFee(Long taxFee) {
        this.taxFee = taxFee;
    }

    /**
     * 获取打印金额      
     *
     * @return print_fee - 打印金额      
     */
    public Long getPrintFee() {
        return printFee;
    }

    /**
     * 设置打印金额      
     *
     * @param printFee 打印金额      
     */
    public void setPrintFee(Long printFee) {
        this.printFee = printFee;
    }

    /**
     * 获取打印次数      
     *
     * @return print_num - 打印次数      
     */
    public Short getPrintNum() {
        return printNum;
    }

    /**
     * 设置打印次数      
     *
     * @param printNum 打印次数      
     */
    public void setPrintNum(Short printNum) {
        this.printNum = printNum;
    }

    /**
     * 获取操作工号      
     *
     * @return login_no - 操作工号      
     */
    public String getLoginNo() {
        return loginNo;
    }

    /**
     * 设置操作工号      
     *
     * @param loginNo 操作工号      
     */
    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    /**
     * 获取操作地市代码    
     *
     * @return group_id - 操作地市代码    
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置操作地市代码    
     *
     * @param groupId 操作地市代码    
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取操作模块代码    
     *
     * @return op_code - 操作模块代码    
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * 设置操作模块代码    
     *
     * @param opCode 操作模块代码    
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    /**
     * 获取操作日期      
     *
     * @return total_date - 操作日期      
     */
    public Integer getTotalDate() {
        return totalDate;
    }

    /**
     * 设置操作日期      
     *
     * @param totalDate 操作日期      
     */
    public void setTotalDate(Integer totalDate) {
        this.totalDate = totalDate;
    }

    /**
     * 获取操作时间      
     *
     * @return op_time - 操作时间      
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * 设置操作时间      
     *
     * @param opTime 操作时间      
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 获取备注        
     *
     * @return remark - 备注        
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注        
     *
     * @param remark 备注        
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取发票请求流水编号  
     *
     * @return order_sn - 发票请求流水编号  
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置发票请求流水编号  
     *
     * @param orderSn 发票请求流水编号  
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取数据来源      
     *
     * @return data_source - 数据来源      
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据来源      
     *
     * @param dataSource 数据来源      
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}