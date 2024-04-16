package com.pashach.currencyrate.core.service;

import com.pashach.currencyrate.core.model.ExchangeRateHistory;
import com.pashach.currencyrate.core.repository.ExchangeRateHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateHistoryService {

  private final ExchangeRateHistoryRepository exchangeRateHistoryRepository;

  public ExchangeRateHistory getLatestExchangeRate(final String baseCurrencyCode) {
    return exchangeRateHistoryRepository.findFirstByBaseCurrencyCodeOrderByTimestampDesc(baseCurrencyCode)
        .orElseThrow(() -> new RuntimeException("Could not find exchange rate for currency: " + baseCurrencyCode));
  }
}
