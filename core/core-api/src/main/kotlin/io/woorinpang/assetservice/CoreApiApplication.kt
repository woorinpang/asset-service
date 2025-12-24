package io.woorinpang.assetservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class CoreApiApplication

fun main(args: Array<String>) {
    runApplication<CoreApiApplication>(*args)
}
