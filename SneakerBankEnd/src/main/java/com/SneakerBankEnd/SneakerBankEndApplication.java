package com.SneakerBankEnd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(scanBasePackages={"com.SneakerBankEnd"})
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class SneakerBankEndApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SneakerBankEndApplication.class, args);
	
		
		
	}
	


}
