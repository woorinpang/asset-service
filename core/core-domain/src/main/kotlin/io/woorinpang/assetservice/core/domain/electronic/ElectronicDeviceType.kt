package io.woorinpang.assetservice.core.domain.electronic

enum class ElectronicDeviceType(val code: String, val description: String) {
    PC("PC", "컴퓨터"),
    MOBILE("MOBILE", "휴대폰"),
    ;

    companion object {
        fun findByCode(code: String): ElectronicDeviceType? {
            return entries.find { it.code == code }
        }
    }
}
