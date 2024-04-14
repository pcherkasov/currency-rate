package com.pashach.currencyrate.core.repository;

import com.pashach.currencyrate.core.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
