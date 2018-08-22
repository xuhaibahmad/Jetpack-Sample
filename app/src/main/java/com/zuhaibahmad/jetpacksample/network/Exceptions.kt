package com.zuhaibahmad.jetpacksample.network

data class NoResultException(override val message: String = "Result not found") : Exception()