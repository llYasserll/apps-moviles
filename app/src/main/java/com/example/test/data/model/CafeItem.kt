package com.example.test.data.model

import com.example.test.R

data class CafeItem(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val creado_en: String,

    val lat: Double = -12.04318,
    val lng: Double = -77.02824,

    val imagen: Int = R.drawable.im_cafeamericano
)