/*package com.example.policyadminbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolicyAdminBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyAdminBackendApplication.class, args);
    }
}
*/
package com.example.policyadminbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PolicyAdminBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PolicyAdminBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PolicyAdminBackendApplication.class).properties("server.port=8081");
    }
}
