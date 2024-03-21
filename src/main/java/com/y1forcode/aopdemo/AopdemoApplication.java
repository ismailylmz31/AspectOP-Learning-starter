package com.y1forcode.aopdemo;

import com.y1forcode.aopdemo.dao.AccountDAO;
import com.y1forcode.aopdemo.dao.MembershipDAO;
import com.y1forcode.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
                                               MembershipDAO theMembershipDao,
                                               TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
            //System.out.println("hello world");
            //demoTheBeforeAdvice(theAccountDAO,theMembershipDao);
            //demoTheAfterReturningAdvice(theAccountDAO);
            //demoTheAfterThrowingAdvie(theAccountDAO);
            //demoTheAfterAdvice(theAccountDAO);
            demoTheAroundAdvice(theTrafficFortuneService);
        };
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data= theTrafficFortuneService.getFortune();

        System.out.println("\nMy Fortune is: "+data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            //add a boolean flag to simulate exception
            boolean tripWire = false;

            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exception) {
            System.out.println("\n\n Main Program:  .... caught exception" + exception);
        }

        //display accounts
        System.out.println("\n\n Main Program: demoTheAfterThrowingAdvie");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvie(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            //add a boolean flag to simulate exception
            boolean tripWire = true;

            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exception) {
            System.out.println("\n\n Main Program:  .... caught exception" + exception);
        }

        //display accounts
        System.out.println("\n\n Main Program: demoTheAfterThrowingAdvie");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        //call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();
        //display accounts
        System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("\n");


    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDao) {
        Account myAccount = new Account();
        myAccount.setName("suleyman");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();
        //theMembershipDao.addAccount();
        //lets call it again
        System.out.println("\n lets calll it again! \n");

        //theAccountDAO.addAccount();

        theMembershipDao.addSillyMember();
        theMembershipDao.goToSleep();


        // call account dao getter setter
        theAccountDAO.setName("Suleyman");
        theAccountDAO.setServiceCode("Cakir");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();
    }

}
