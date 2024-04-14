package com.pashach.currencyrate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.pashach.currencyrate")
@Import(FeignClientsConfiguration.class)
public class CurrencyApiFeignConfig {

  @Value("${feign.url.currency-api-key}")
  private String apiKey;

  @Bean
  public CurrencyClientInterceptor currencyClientInterceptor() {
    return new CurrencyClientInterceptor(apiKey);
  }
}
