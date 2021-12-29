package com.alfa.vyushinsky.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("exchangerates")
data class ExchangeSetting(
    val api_key: String,
    val url: String,
)
