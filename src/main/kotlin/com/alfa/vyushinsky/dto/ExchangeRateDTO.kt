package com.alfa.vyushinsky.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExchangeRateDTO(
    @JsonProperty(value = "rates")
    val rates: MutableMap<String, BigDecimal>
)
