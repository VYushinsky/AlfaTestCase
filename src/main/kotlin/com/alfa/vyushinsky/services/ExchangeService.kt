package com.alfa.vyushinsky.services

import org.springframework.http.ResponseEntity

interface ExchangeService {
    fun getGifExchangeRate(currency: String): ResponseEntity<ByteArray>
}