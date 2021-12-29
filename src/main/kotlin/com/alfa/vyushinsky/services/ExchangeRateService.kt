package com.alfa.vyushinsky.services

import org.springframework.http.ResponseEntity
import com.alfa.vyushinsky.dto.ExchangeRateDTO

interface ExchangeRateService {
    fun getYestCurrency(date: String, symbols: String): ResponseEntity<ExchangeRateDTO>
    fun getLatestCurrency(symbols: String): ResponseEntity<ExchangeRateDTO>
    fun getAllRates(): ResponseEntity<ExchangeRateDTO>
}