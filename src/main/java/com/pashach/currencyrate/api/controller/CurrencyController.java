package com.pashach.currencyrate.api.controller;

import com.pashach.currencyrate.api.dto.request.NewCurrencyRequest;
import com.pashach.currencyrate.api.dto.response.CurrencyInfoResponse;
import com.pashach.currencyrate.api.facade.CurrencyFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/currencies")
public class CurrencyController {

  private final CurrencyFacade facade;

  @PostMapping
  public ResponseEntity<CurrencyInfoResponse> addCurrency(@RequestBody NewCurrencyRequest r) {
    log.info("REST request. Add currency: {}", r.getCode());
    return ResponseEntity.ok(facade.addCurrency(r));
  }
}
