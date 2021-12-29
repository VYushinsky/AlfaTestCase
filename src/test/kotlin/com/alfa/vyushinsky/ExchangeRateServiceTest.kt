package com.alfa.vyushinsky


import com.alfa.vyushinsky.clients.ExchangeRatesClient
import com.alfa.vyushinsky.exception.CurrencyException
import com.alfa.vyushinsky.services.ExchangeService
import com.alfa.vyushinsky.dto.ExchangeRateDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.ResponseEntity
import java.math.BigDecimal


@SpringBootTest
class ExchangeRateServiceTest {

    @MockBean
    private val exchangeRatesClient: ExchangeRatesClient? = null

    @Autowired
    private var exchangeService: ExchangeService? = null

    @Test
    fun getRate() {
        val personsHashMap: MutableMap<String, BigDecimal> =
            mutableMapOf("RUB" to BigDecimal.valueOf(73.523))
        val exchangeRateDTO = ExchangeRateDTO(rates = personsHashMap)
        Mockito.`when`(exchangeRatesClient!!.getLatestCurrency(Mockito.anyString(), Mockito.anyString()))
            .thenReturn(ResponseEntity.ok(exchangeRateDTO))
            .thenThrow(CurrencyException::class.java)
        Assertions.assertThrows(
            CurrencyException::class.java) {exchangeService!!.getGifExchangeRate("RUBS")
        }
    }
}
