package com.openx.qrcode.generator.repo;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {


    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create("mongodb+srv://ankitraidev:$Udegora@1@cluster0.wh4bh.mongodb.net/qr_code_generator?retryWrites=true&w=majority&appName=Cluster0"), "your_database");
    }
}
