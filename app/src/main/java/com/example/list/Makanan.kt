package com.example.list

import  android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Makanan(
    val name: String,
    val desc: String,
    val photo: Int,
) : Parcelable
