@file:Suppress("ktlint:standard:no-wildcard-imports")

package io.woorinpang.assetservice.storage.db.core.electronic

import com.querydsl.jpa.impl.JPAQueryFactory
import io.woorinpang.assetservice.storage.db.core.electronic.QElectronicDeviceEntity.electronicDeviceEntity
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class ElectronicDeviceEntityQueryRepository(
    val queryFactory: JPAQueryFactory
) {
    fun findElectronicDevices(
        condition: ElectronicDeviceSearchCondition,
        pageable: Pageable,
    ): List<ElectronicDeviceEntity> =
        queryFactory
            .select(electronicDeviceEntity)
            .from(electronicDeviceEntity)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .orderBy(electronicDeviceEntity.id.desc())
            .fetch()
}
