package com.pashach.currencyrate.core.service;

import com.pashach.currencyrate.core.model.Currency;
import com.pashach.currencyrate.core.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

  private final CurrencyRepository currencyRepository;

  public Currency save(Currency currency) {
    return currencyRepository.save(currency);
  }
}
