package com.vipin.LoginPage.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class CoNectConfigurationBeans {
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
