package com.example.footballapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val teamName = intent.getStringExtra("TEAM_NAME")
        val teamLogo = intent.getStringExtra("TEAM_LOGO")
        val countryId = intent.getIntExtra("COUNTRY_ID", -1)
        val venueId = intent.getIntExtra("VENUE_ID", -1)
        val gender = intent.getStringExtra("GENDER")
        val founded = intent.getIntExtra("FOUNDED", -1)
        val type = intent.getStringExtra("TYPE")
        val lastPlayedAt = intent.getStringExtra("LAST_PLAYED_AT")

        val detailTeamName: TextView = findViewById(R.id.detailTeamName)
        val detailTeamLogo: ImageView = findViewById(R.id.detailTeamLogo)
        val detailCountryId: TextView = findViewById(R.id.detailCountryId)
        val detailVenueId: TextView = findViewById(R.id.detailVenueId)
        val detailGender: TextView = findViewById(R.id.detailGender)
        val detailFounded: TextView = findViewById(R.id.detailFounded)
        val detailType: TextView = findViewById(R.id.detailType)
        val detailLastPlayedAt: TextView = findViewById(R.id.detailLastPlayedAt)

        detailTeamName.text = teamName
        Glide.with(this)
            .load(teamLogo)
            .into(detailTeamLogo)

        detailCountryId.text = "Country ID: $countryId"
        detailVenueId.text = "Venue ID: $venueId"
        detailGender.text = "Gender: $gender"
        detailFounded.text = "Founded: $founded"
        detailType.text = "Type: $type"
        detailLastPlayedAt.text = "Last Played At: $lastPlayedAt"
    }
}
