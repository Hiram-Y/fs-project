package com.iisquare.fs.site.bbs.wap;

import com.iisquare.fs.base.web.mvc.BeanNameGenerator;
import com.iisquare.fs.web.core.mvc.FeignInterceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.iisquare.fs.base.core.*",
        "com.iisquare.fs.web.core.*",
        "com.iisquare.fs.site.bbs.wap",
})
@EnableFeignClients(basePackages = {
        "com.iisquare.fs.web.core.rpc"
}, defaultConfiguration = { FeignInterceptor.class })
public class BBSWapApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BBSWapApplication.class).beanNameGenerator(new BeanNameGenerator()).run(args);
    }

}
