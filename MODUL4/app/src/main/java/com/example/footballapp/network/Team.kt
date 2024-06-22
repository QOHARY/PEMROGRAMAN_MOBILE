package com.example.footballapp.network

import com.squareup.moshi.Json

data class Team(
    @Json(name = "id") val id: Int,
    @Json(name = "sport_id") val sportId: Int,
    @Json(name = "country_id") val countryId: Int,
    @Json(name = "venue_id") val venueId: Int,
    @Json(name = "gender") val gender: String,
    @Json(name = "name") val name: String,
    @Json(name = "short_code") val shortCode: String?,
    @Json(name = "image_path") val imagePath: String,
    @Json(name = "founded") val founded: Int,
    @Json(name = "type") val type: String,
    @Json(name = "placeholder") val placeholder: Boolean,
    @Json(name = "last_played_at") val lastPlayedAt: String
)
