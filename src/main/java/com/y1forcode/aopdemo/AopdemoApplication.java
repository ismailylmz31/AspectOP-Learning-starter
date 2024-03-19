package com.y1forcode.aopdemo;

import com.y1forcode.aopdemo.dao.AccountDAO;
import com.y1forcode.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDao){
		return runner ->{
			//System.out.println("hello world");
			demoTheBeforeAdvice(theAccountDAO,theMembershipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDao) {
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount);
		//theMembershipDao.addAccount();
		//lets call it again
		System.out.println("\n lets calll it again! \n");

		//theAccountDAO.addAccount();

		theMembershipDao.addSillyMember();
	}

}
