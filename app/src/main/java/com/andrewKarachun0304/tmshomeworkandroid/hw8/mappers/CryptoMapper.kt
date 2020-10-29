package com.andrewKarachun0304.tmshomeworkandroid.hw8.mappers

import com.andrewKarachun0304.tmshomeworkandroid.hw8.dto.Data
import com.andrewKarachun0304.tmshomeworkandroid.hw8.entity.Crypto

object CryptoMapper {
    fun map(from: Data) = Crypto(
        name = from.name.orEmpty(),
        price = from.quote?.uSD?.price ?: 0.0,
        change = from.quote?.uSD?.percentChange1h ?: 0.0
    )
}