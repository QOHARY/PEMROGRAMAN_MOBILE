package com.example.footballapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.ui.TeamAdapter
import com.example.footballapp.ui.TeamViewModel

class MainActivity : AppCompatActivity() {

    private val teamViewModel: TeamViewModel by viewModels()
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        teamAdapter = TeamAdapter { team ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TEAM_ID", team.id)
            intent.putExtra("TEAM_NAME", team.name)
            intent.putExtra("TEAM_LOGO", team.imagePath)
            startActivity(intent)
        }
        recyclerView.adapter = teamAdapter

        teamViewModel.teams.observe(this, Observer { teams ->
            if (teams != null) {
                Log.d("MainActivity", "Teams data received: ${teams.size} items")
                teamAdapter.setTeams(teams)
            } else {
                Log.d("MainActivity", "No teams data received")
            }
        })
    }
}