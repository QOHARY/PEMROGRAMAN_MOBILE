package com.example.footballapp.network

import com.squareup.moshi.Json

data class TeamResponse(
    @Json(name = "data") val data: List<Team>
)
