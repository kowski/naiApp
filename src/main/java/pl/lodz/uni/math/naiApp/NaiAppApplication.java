package pl.lodz.uni.math.naiApp;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NaiAppApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(NaiAppApplication.class, args);
	}
}
//heroq
/*
-spring boot
   -itnterceptors(3)
   -scheduler(2)
   -internaclization
   -spirng security
   -spring session
   -public: angurlar + nodeJs
   -private: thymlead + jquery
-MyBatis - orm
   -over 5 tables
-FlyWay
-Repo Git
   -2 Branches
 */
