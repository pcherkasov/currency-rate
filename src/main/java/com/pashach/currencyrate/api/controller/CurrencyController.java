package com.pashach.currencyrate.api.controller;

import com.pashach.currencyrate.api.dto.request.NewCurrencyRequest;
import com.pashach.currencyrate.api.dto.response.CurrencyInfoResponse;
import com.pashach.currencyrate.api.dto.response.CurrencyRatesResponse;
import com.pashach.currencyrate.api.facade.CurrencyFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/currencies")
public class CurrencyController {

  private final CurrencyFacade facade;

  @PostMapping
  public ResponseEntity<CurrencyInfoResponse> addCurrency(@RequestBody final NewCurrencyRequest r) {
    log.info("REST request. Add currency: {}", r.getCode());
    return ResponseEntity.status(HttpStatus.CREATED).body(facade.addCurrency(r));
  }

  @GetMapping
  public ResponseEntity<List<CurrencyInfoResponse>> getCurrencies() {
    log.info("REST request get currencies");
    return ResponseEntity.ok(facade.getAllCurrencies());
  }

  @GetMapping("/{code}/rates")
  public ResponseEntity<CurrencyRatesResponse> getCurrencyRates(@PathVariable final String code) {
    log.info("REST request get currency rates for: {}", code.toUpperCase());
    return ResponseEntity.ok(facade.getCurrencyRates(code.toUpperCase()));
  }
}
