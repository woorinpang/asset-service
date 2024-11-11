package io.woorinpang.assetservice.storage.db.core.asset

import io.woorinpang.assetservice.core.domain.asset.Asset
import io.woorinpang.assetservice.core.domain.asset.AssetRepository
import io.woorinpang.assetservice.core.domain.user.User
import io.woorinpang.assetservice.core.enums.AssetType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class AssetEntityRepository(
    val assetEntityJpaRepository: AssetEntityJpaRepository,
) : AssetRepository {
    @Transactional
    override fun append(userId: Long, type: AssetType, email: String): Long {
        val assetEntity = AssetEntity.of(userId, type, email)
        return assetEntityJpaRepository.save(assetEntity).id
    }

    @Transactional(readOnly = true)
    override fun findAsset(assetId: Long): Asset? {
        val findAssetEntity = assetEntityJpaRepository.findByIdOrNull(assetId)
        return findAssetEntity?.let {
            Asset.of(
                assetId = it.id,
                userId = it.userId,
                assetType = it.type,
                createdBy = it.createdBy,
                createdAt = it.createdAt,
                deleted = it.deleted,
            )
        }
    }

    @Transactional
    override fun removeAsset(assetId: Long, user: User) {
        assetEntityJpaRepository.findByIdOrNull(assetId)?.delete(user.email)
    }

    override fun existsByUserIdAndType(id: Long, type: AssetType): Boolean {
        return assetEntityJpaRepository.existsByUserIdAndType(id, type)
    }
}
