package com.pashach.currencyrate.api.facade;

import com.pashach.currencyrate.api.dto.request.NewCurrencyRequest;
import com.pashach.currencyrate.api.dto.response.CurrencyInfoResponse;
import com.pashach.currencyrate.client.CurrencyApiClient;
import com.pashach.currencyrate.core.model.Currency;
import com.pashach.currencyrate.core.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyFacade {

  private final CurrencyService currencyService;
  private final CurrencyApiClient currencyApiClient;

  public CurrencyInfoResponse addCurrency(NewCurrencyRequest r) {
    CurrencyInfoResponse currencyInfo;
    try {
      currencyInfo = currencyApiClient.getCurrencyByCode(r.getCode()).get("data").get(r.getCode());
    } catch (Exception e) {
      log.error("Error getting currency info", e);
      throw new RuntimeException(e.getMessage());
    }

    var newCurrency = currencyService.save(
        new Currency(null, currencyInfo.getCode(), currencyInfo.getName())
    );
    log.debug("New currency was saved with Id: {}", newCurrency.getId());

    return new CurrencyInfoResponse(
        newCurrency.getCode(), newCurrency.getFullName()
    );
  }

  public List<CurrencyInfoResponse> getAllCurrencies() {
    return currencyService.findAll().stream()
        .map(currency -> new CurrencyInfoResponse(currency.getCode(), currency.getFullName()))
        .toList();
  }
}
