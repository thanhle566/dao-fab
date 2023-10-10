package com.assignment.daofab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CodingAssignmentDaofabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingAssignmentDaofabApplication.class, args);
    }

}
