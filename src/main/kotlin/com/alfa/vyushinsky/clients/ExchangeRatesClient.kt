package com.alfa.vyushinsky.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import com.alfa.vyushinsky.dto.ExchangeRateDTO

@FeignClient(url = "\${exchangerates.url}", name = "exchangeRatesClient")
interface ExchangeRatesClient {

    @GetMapping("/historical/{date}.json")
    fun getYestCurrency(@PathVariable("date") date: String,
                      @RequestParam app_id: String,
                      @RequestParam symbols: String): ResponseEntity<ExchangeRateDTO>

    @GetMapping("/latest.json")
    fun getLatestCurrency(@RequestParam app_id: String,
                        @RequestParam symbols: String): ResponseEntity<ExchangeRateDTO>

    @GetMapping("/latest.json")
    fun getAllRates(@RequestParam app_id: String): ResponseEntity<ExchangeRateDTO>
}