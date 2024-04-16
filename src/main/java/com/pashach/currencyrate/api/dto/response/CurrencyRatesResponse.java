package com.pashach.currencyrate.api.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CurrencyRatesResponse {
  private String baseCurrency;
  private String currencyRates;
}
