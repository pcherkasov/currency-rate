package com.pashach.currencyrate.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CurrencyClientInterceptor implements RequestInterceptor {

  private final String apikey;
  private static final String API_KEY_HEADER_NAME = "apikey";

  @Override
  public void apply(RequestTemplate requestTemplate) {
    requestTemplate.header(API_KEY_HEADER_NAME, apikey);
  }
}
