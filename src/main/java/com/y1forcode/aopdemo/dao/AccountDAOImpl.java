package com.y1forcode.aopdemo.dao;

import com.y1forcode.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire == true){
            throw new RuntimeException("Suleyman cakir OLDU!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        //CREATE SAMPLE ACCOUNT
        Account temp1=new Account("Suleyman", "cakir");
        Account temp2=new Account("cerrahpasali", "halit");
        Account temp3=new Account("Faris", "sariyayla");
        Account temp4=new Account("kurt", "bedo");
        Account temp5=new Account("ustun", "kisa");
        Account temp6=new Account("demir", "gorkemli");
        Account temp7=new Account("freud", "fethi");


        //ADD THEM TO OUR ACCOUNTS LIST
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        myAccounts.add(temp4);
        myAccounts.add(temp5);
        myAccounts.add(temp6);
        myAccounts.add(temp7);



        return myAccounts;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass()+"DOING MY DB WORK: ADDING AN ACOOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" : doWork()");
        return false;
    }


    public String getName() {
        System.out.println(getClass()+" :in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" :in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" :in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" :in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
