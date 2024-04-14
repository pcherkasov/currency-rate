package com.pashach.currencyrate.client;

import com.pashach.currencyrate.api.dto.response.CurrencyInfoResponse;
import com.pashach.currencyrate.api.dto.response.LatestRatesResponse;
import com.pashach.currencyrate.config.CurrencyApiFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
    name = "currencyApiClient",
    url = "https://api.currencyapi.com/v3",
    configuration = CurrencyApiFeignConfig.class)
public interface CurrencyApiClient {

  @GetMapping("/currencies")
  Map<String, Map<String,CurrencyInfoResponse>> getCurrencyByCode(@RequestParam("currencies") String code);

  @GetMapping("/latest")
  Map<String, LatestRatesResponse> getLatestRates(@RequestParam("base_currency") String baseCurrency);
}
