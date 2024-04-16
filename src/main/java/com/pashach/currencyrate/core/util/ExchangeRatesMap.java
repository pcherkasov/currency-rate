package com.pashach.currencyrate.core.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ExchangeRatesMap {
  private final HashMap<String, String> exchangeRates;

  public ExchangeRatesMap() {
    this.exchangeRates = new HashMap<>();
  }

  public String getExchangeRates(final String currencyCode) {
    return exchangeRates.get(currencyCode);
  }

  public void addExchangeRates(final String currencyCode, final String exchangeRates) {
    this.exchangeRates.put(currencyCode, exchangeRates);
  }
}
