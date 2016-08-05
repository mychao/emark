package com.mychao.emark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author myc
 * @version 2016/8/1
 */
@SpringBootApplication
public class EmarkApplication extends SpringBootServletInitializer{

    public static void main(String[] args){
        SpringApplication.run(EmarkApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EmarkApplication.class);
    }

}
