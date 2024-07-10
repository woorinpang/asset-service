package io.woorinpang.assetservice.storage.db.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class CoreDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "storage.datasource.core")
    fun coreHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun coreDataSource(
        @Qualifier("coreHikariConfig") hikariConfig: HikariConfig?,
    ): HikariDataSource {
        return HikariDataSource(hikariConfig)
    }
}
