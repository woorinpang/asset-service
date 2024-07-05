package io.woorinpang.assetservice.core.domain.support.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity() : BaseTimeEntity() {

    @Column(updatable = false)
    val createdBy: String? = null

    @Column
    var updatedBy: String? = null
        protected set
}