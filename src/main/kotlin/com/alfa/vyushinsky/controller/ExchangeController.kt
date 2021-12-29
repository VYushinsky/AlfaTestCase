package com.alfa.vyushinsky.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.alfa.vyushinsky.services.ExchangeService

@RestController
@RequestMapping("/api")
class ExchangeController(val exchangeService: ExchangeService) {

    @GetMapping("gif/{currency}")
    fun getGifByRate(@PathVariable currency: String): ResponseEntity<ByteArray> {
        return exchangeService.getGifExchangeRate(currency)
    }

}