package io.woorinpang.assetservice.admin.support.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AdminBaseEntity() : AdminBaseTimeEntity() {

    @Column(updatable = false)
    val createdBy: String? = null

    @Column
    var updatedBy: String? = null
        protected set
}