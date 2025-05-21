package com.akashicpay.example;

import org.apache.commons.lang3.StringUtils;
import com.akashicpay.example.service.AkashicPayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Environment environment = context.getEnvironment();
        String identity = environment.getProperty("identity");
        String privateKey = environment.getProperty("private_key");
        String apiSecret = environment.getProperty("api_secret");

        if (StringUtils.isEmpty(identity) || StringUtils.isEmpty(privateKey) || StringUtils.isEmpty(apiSecret)) {
            throw new Exception("identity, privateKey and apiSecret should not be empty!!");
        }


        System.out.print("##############################################\n\n");
        System.out.printf("📩 identity: %s\n🔐 privateKey: %s\n🔐 apiSecret: %s\n", identity, privateKey, apiSecret);
        System.out.print("##############################################\n\n");


        AkashicPayService akashicPayService = context.getBean(AkashicPayService.class);
        akashicPayService.init(identity, privateKey, apiSecret);
    }

}