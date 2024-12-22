package com.openx.qrcode;

import com.openx.qrcode.generator.repo.HistoryRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.openx.qrcode.repo")
public class QrcodeApplication {



	public static void main(String[] args) {
		SpringApplication.run(QrcodeApplication.class, args);
	}

}
