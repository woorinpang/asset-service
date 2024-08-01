package io.woorinpang.assetservice.config

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class SampleTopicListener {
    @KafkaListener(topics = ["foobar"])
    fun consume(
        @Payload data: String,
    ) {
    }
}
