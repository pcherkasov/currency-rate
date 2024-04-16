package com.pashach.currencyrate.core.service;

import com.pashach.currencyrate.api.dto.response.CurrencyInfoResponse;
import com.pashach.currencyrate.core.model.Currency;
import com.pashach.currencyrate.core.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyService {

  private final CurrencyRepository currencyRepository;

  public Currency save(final Currency currency) {
    try {
      return currencyRepository.save(currency);
    } catch (Exception e) {
      log.error("Error saving currency", e);
      throw new RuntimeException("Error saving currency with code: " + currency.getCode());
    }
  }

  public List<Currency> findAll() {
    return currencyRepository.findAll();
  }
}
