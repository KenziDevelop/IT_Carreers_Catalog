package com.pab.it_carreers_catalog

data class CareerItem(
    val name: String,
    val iconRes: Int,
    val gradientRes: Int,  // drawable gradient background
    val description: String,  // <-- tambah ini!
    val detailActivity: Class<*>
)