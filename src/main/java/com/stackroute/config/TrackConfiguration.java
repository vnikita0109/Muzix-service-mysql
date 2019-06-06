package com.stackroute.config;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan("com.stackroute.*")
public class TrackConfiguration {

   @Autowired
   private Environment environment;

}
