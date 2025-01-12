package com.iisquare.fs.web.govern;

import com.iisquare.fs.base.web.mvc.BeanNameGenerator;
import com.iisquare.fs.web.core.mvc.FeignInterceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.iisquare.fs.base.core.*",
        "com.iisquare.fs.base.jpa.*",
        "com.iisquare.fs.base.neo4j.*",
        "com.iisquare.fs.web.core.*",
        "com.iisquare.fs.web.govern",
})
@EnableFeignClients(basePackages = {
        "com.iisquare.fs.web.core.rpc"
}, defaultConfiguration = { FeignInterceptor.class })
public class GovernApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GovernApplication.class).beanNameGenerator(new BeanNameGenerator()).run(args);
    }

}
