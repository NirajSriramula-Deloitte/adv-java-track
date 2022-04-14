package com.hashedin.currencyexchangeservice.repos;

import com.hashedin.currencyexchangeservice.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CurrencyRepo extends JpaRepository<Currency, Integer> {
    @Query("SELECT u FROM Currency u WHERE u.cur_name = ?1")
    Currency findCurrencyByCurname(String cur_name);
}
