package com.y1forcode.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()+"DOING MY DB WORK: ADDING AN Membership ACOOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+": goToSleep()");
    }
}
