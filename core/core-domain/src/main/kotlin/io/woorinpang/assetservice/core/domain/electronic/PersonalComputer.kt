package io.woorinpang.assetservice.core.domain.electronic

data class PersonalComputer private constructor(
    val manufacturer: String,
    val model: String,
    val operationSystem: String,
    val processor: String,
    val memory: String,
    val storage: String,
    val graphicsCard: String,
    val serialNumber: String,
    val price: Int
) {
    companion object {
        fun of(
            manufacturer: String,
            model: String,
            operationSystem: String,
            processor: String,
            memory: String,
            storage: String,
            graphicsCard: String,
            serialNumber: String,
            price: Int
        ): PersonalComputer {
            return PersonalComputer(
                manufacturer = manufacturer,
                model = model,
                operationSystem = operationSystem,
                processor = processor,
                memory = memory,
                storage = storage,
                graphicsCard = graphicsCard,
                serialNumber = serialNumber,
                price = price
            )
        }
    }
}
