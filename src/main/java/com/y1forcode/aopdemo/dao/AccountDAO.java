package com.y1forcode.aopdemo.dao;


import com.y1forcode.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts(boolean tripWire);

    //add a new method findAccounts()
    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
