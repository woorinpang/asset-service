package io.woorinpang.assetservice.storage.db.core.electronic

import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate
import java.math.BigDecimal

@Entity
@Table(name = "ElectronicDevice")
@DynamicUpdate
class ElectronicDeviceEntity(
    @Column(name = "assetId", columnDefinition = "bigint not null comment '자산 고유번호'")
    val assetId: Long,

    @Column(name = "electronicDeviceType", columnDefinition = "varchar(30) not null comment '전자기기 타입'")
    val type: String,

    @Column(name = "manufacturer", columnDefinition = "varchar(255) not null comment '제조사'")
    val manufacturer: String,

    @Column(name = "model", columnDefinition = "varchar(255) null comment '모델명'")
    val model: String,

    @Column(name = "serialNumber", columnDefinition = "varchar(255) null comment '시리얼 번호'")
    val serialNumber: String,

    @Column(name = "price", columnDefinition = "decimal(10,0) null comment '가격'")
    val price: BigDecimal,

    @Column(name = "deleted")
    private var deleted: Boolean,

) : BaseEntity() {
    companion object {
        fun of(assetId: Long, type: String, manufacturer: String, model: String, serialNumber: String, price: BigDecimal): ElectronicDeviceEntity {
            return ElectronicDeviceEntity(
                assetId = assetId,
                type = type,
                manufacturer = manufacturer,
                model = model,
                serialNumber = serialNumber,
                price = price,
                deleted = false,
            )
        }
    }

    fun delete() {
        this.deleted = true
    }
}
