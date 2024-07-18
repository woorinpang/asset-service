package io.woorinpang.assetservice.storage.db.core

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment

@MappedSuperclass
abstract class BaseEntity : BaseTimeEntity() {
    @Column(updatable = false) @Comment("생성자")
    val createdBy: String? = null

    @Column @Comment("수정자")
    var updatedBy: String? = null
        protected set
}
