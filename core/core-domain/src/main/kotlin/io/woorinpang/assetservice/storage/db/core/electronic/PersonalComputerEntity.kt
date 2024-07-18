package io.woorinpang.assetservice.storage.db.core.electronic

import io.woorinpang.assetservice.core.domain.electronic.PersonalComputer
import io.woorinpang.assetservice.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "PersonalComputer")
class PersonalComputerEntity(
    @Column(name = "electronicDeviceId", columnDefinition = "bigint not null comment '전자기기 고유번호'")
    val electronicDeviceId: Long,

    @Column(name = "manufacturer", columnDefinition = "varchar(255) not null comment '제조사'")
    val manufacturer: String,

    @Column(name = "model", columnDefinition = "varchar(255) null comment '모델명'")
    val model: String,

    @Column(name = "operationSystem", columnDefinition = "varchar(255) null comment '운영 체제'")
    val operationSystem: String,

    @Column(name = "processor", columnDefinition = "varchar(255) null comment '프로세서'")
    val processor: String,

    @Column(name = "memory", columnDefinition = "varchar(255) null comment '메모리'")
    val memory: String,

    @Column(name = "storage", columnDefinition = "varchar(255) null comment '저장 장치'")
    val storage: String,

    @Column(name = "graphicsCard", columnDefinition = "varchar(255) null comment '그래픽 카드'")
    val graphicsCard: String,

    @Column(name = "serialNumber", columnDefinition = "varchar(255) null comment '시리얼 번호'")
    val serialNumber: String,

    @Column(name = "price", columnDefinition = "decimal(10,0) null comment '가격'")
    val price: Int

) : BaseEntity() {
    companion object {
        fun of(
            electronicDeviceId: Long,
            personalComputer: PersonalComputer
        ): PersonalComputerEntity {
            return PersonalComputerEntity(
                electronicDeviceId = electronicDeviceId,
                manufacturer = personalComputer.manufacturer,
                model = personalComputer.model,
                operationSystem = personalComputer.operationSystem,
                processor = personalComputer.processor,
                memory = personalComputer.memory,
                storage = personalComputer.storage,
                graphicsCard = personalComputer.graphicsCard,
                serialNumber = personalComputer.serialNumber,
                price = personalComputer.price
            )
        }
    }
}