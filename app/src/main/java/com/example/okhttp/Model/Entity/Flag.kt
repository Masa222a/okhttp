package com.example.okhttp.Model.Entity

import java.io.Serializable

data class Flag(
    val id: Int,
    val pictureId: Int,
    val name: String?,
    val engName: String?,
    val population: String?,
    val language: String?,
    val capital: String?,
    val currency: String?
): Serializable