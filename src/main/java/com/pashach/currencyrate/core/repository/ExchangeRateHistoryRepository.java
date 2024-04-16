package com.pashach.currencyrate.core.repository;

import com.pashach.currencyrate.core.model.ExchangeRateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateHistoryRepository extends JpaRepository<ExchangeRateHistory, Long> {
  Optional<ExchangeRateHistory> findFirstByBaseCurrencyCodeOrderByTimestampDesc(final String baseCurrencyCode);
}
