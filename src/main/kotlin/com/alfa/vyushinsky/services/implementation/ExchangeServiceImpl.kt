package com.alfa.vyushinsky.services.implementation

import com.alfa.vyushinsky.exception.CurrencyException
import com.alfa.vyushinsky.services.DownloadGifService
import com.alfa.vyushinsky.services.ExchangeService
import com.alfa.vyushinsky.services.GiphyService
import com.alfa.vyushinsky.services.ExchangeRateService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class ExchangeServiceImpl(val downloadGifService: DownloadGifService,
                          val giphyService: GiphyService,
                          val exchangeRateService: ExchangeRateService
): ExchangeService {

    override fun getGifExchangeRate(currency: String): ResponseEntity<ByteArray> {
        val symbols = "${currency.uppercase()}"

        if(symbols.length != 3) {
            throw CurrencyException("Код валюты должен состоять из 3х символов")
        }

        val allRates = exchangeRateService.getAllRates().body!!.rates.keys
        if(allRates.contains(symbols)) {
        } else throw CurrencyException("Такого кода валюты нет")

        val rateToday = exchangeRateService.getLatestCurrency(symbols).body!!.rates[symbols]!!

        val yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE)
        val rateYesterday = exchangeRateService.getYestCurrency(yesterday, symbols).body!!.rates[symbols]!!

        val tag = if (rateToday > rateYesterday){
            "rich"
        } else "broke"

        val gifURI = URI.create(getGifTag(tag))
        return downloadGifService.getGifByURI(gifURI)
    }

    fun getGifTag(tag: String): String {
        val gifDTO = giphyService.getGif(tag).body
        return gifDTO!!.data.images.original.url
    }
}
