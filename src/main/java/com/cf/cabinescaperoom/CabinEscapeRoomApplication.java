package com.cf.cabinescaperoom;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class CabinEscapeRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabinEscapeRoomApplication.class, args);
	}

}
