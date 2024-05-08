package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val nameResourceId: Int,
    @StringRes val descResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
