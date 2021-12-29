package com.alfa.vyushinsky

import com.alfa.vyushinsky.settings.ExchangeSetting
import com.alfa.vyushinsky.settings.GiphySetting
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(ExchangeSetting::class, GiphySetting::class)
@ComponentScan("com.alfa")
class TestCaseApplication

fun main(args: Array<String>) {
	runApplication<TestCaseApplication>(*args)
}
