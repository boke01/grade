package com.vz04.grade.pojo.login;

/**
 * 账户信息的数据bean
 *
 * @author vz04
 * @date 7/27/2019 9:56 AM
 **/

public class AccountBean {

    private Integer accountId;
    private String accountNumber;
    private String password;
    private Integer identity;
    private Integer classesId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "AccountBean{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                ", classesId=" + classesId +
                '}';
    }
}
