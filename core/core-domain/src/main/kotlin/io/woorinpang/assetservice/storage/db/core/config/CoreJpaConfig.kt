package io.woorinpang.assetservice.storage.db.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["io.woorinpang.assetservice.storage.db.core"])
@EnableJpaRepositories(basePackages = ["io.woorinpang.assetservice.storage.db.core"])
internal class CoreJpaConfig
