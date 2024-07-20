package io.woorinpang.assetservice.core.domain.electronic

import java.math.BigDecimal

data class Price private constructor(
    val value: BigDecimal
) {
    companion object {
        val ZERO = of(0L)

        fun of(value: Long): Price {
            return Price(BigDecimal.valueOf(value))
        }

        fun of(value: BigDecimal): Price {
            return Price(value)
        }
    }

    fun plus(price: Price): Price {
        return Price(this.value.add(price.value))
    }

    fun minus(price: Price): Price {
        return Price(this.value.subtract(price.value))
    }

    fun times(percent: Double): Price {
        return Price(this.value.multiply(BigDecimal.valueOf(percent)))
    }

    fun isLessThan(other: Price): Boolean {
        return this.value.compareTo(other.value) < 0
    }

    fun isGreaterThanOrEqual(other: Price): Boolean {
        return this.value.compareTo(other.value) >= 0
    }
}