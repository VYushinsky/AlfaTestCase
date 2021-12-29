package com.alfa.vyushinsky.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.alfa.vyushinsky.clients.ExchangeRatesClient
import com.alfa.vyushinsky.dto.ExchangeRateDTO
import com.alfa.vyushinsky.services.ExchangeRateService
import com.alfa.vyushinsky.settings.ExchangeSetting

@Service
class ExchangeRateServiceImpl(val exchangeRatesClient: ExchangeRatesClient,
                              val exchangeSetting: ExchangeSetting
): ExchangeRateService {

    override fun getYestCurrency(date: String, symbols: String): ResponseEntity<ExchangeRateDTO> {
        return exchangeRatesClient.getYestCurrency(date = date, app_id = exchangeSetting.api_key, symbols = symbols)
    }

    override fun getLatestCurrency(symbols: String): ResponseEntity<ExchangeRateDTO> {
        return exchangeRatesClient.getLatestCurrency(app_id = exchangeSetting.api_key, symbols = symbols)
    }

    override fun getAllRates(): ResponseEntity<ExchangeRateDTO> {
        return exchangeRatesClient.getAllRates(app_id = exchangeSetting.api_key)
    }

}
