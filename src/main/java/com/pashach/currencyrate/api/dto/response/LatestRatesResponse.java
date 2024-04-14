package com.pashach.currencyrate.api.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LatestRatesResponse {
  private String code;
  private String value;
}
