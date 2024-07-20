package io.woorinpang.assetservice.storage.db.core

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreationTimestamp
    @Column(updatable = false) @Comment("생성일시")
    val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    @Column @Comment("수정일시")
    var updatedAt: LocalDateTime? = null
        protected set
}
