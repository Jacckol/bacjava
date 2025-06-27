package com.example.mikro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.vectorstore.mongodb.autoconfigure.MongoDBAtlasVectorStoreAutoConfiguration;

@SpringBootApplication(exclude = {
    MongoDBAtlasVectorStoreAutoConfiguration.class
})
public class MikroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikroApplication.class, args);
    }

}
