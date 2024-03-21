package com.y1forcode.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImlp implements TrafficFortuneService{


    @Override
    public String getFortune() {
        //simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //return a fortune
        return "Expect heavy traffic this morning";
    }
}
