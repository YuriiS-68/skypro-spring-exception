package pro.sky.java.course2.skyprospringexception.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.java.course2.skyprospringexception.model.Basket;

@Configuration
public class ConfigurationApp {
    @Bean
    @SessionScope
    public Basket createBasket(){
        return new Basket();
    }
}
