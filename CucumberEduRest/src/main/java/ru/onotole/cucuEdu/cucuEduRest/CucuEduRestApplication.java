package ru.onotole.cucuEdu.cucuEduRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.onotole.cucuEdu.cucuEduRest.entities.DefaultParams;

@SpringBootApplication
@EnableConfigurationProperties(DefaultParams.class)
public class CucuEduRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CucuEduRestApplication.class, args);
	}
}
