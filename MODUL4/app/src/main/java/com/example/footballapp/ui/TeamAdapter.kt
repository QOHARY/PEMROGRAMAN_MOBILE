package com.example.footballapp.ui

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Person
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballapp.DetailActivity
import com.example.footballapp.R
import com.example.footballapp.network.Team

class TeamAdapter(private val onClick: (Team) -> Unit) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private var teams: List<Team> = listOf()

    fun setTeams(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount() = teams.size

    class TeamViewHolder(itemView: View, val onClick: (Team) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val teamName: TextView = itemView.findViewById(R.id.teamName)
        private val teamLogo: ImageView = itemView.findViewById(R.id.teamLogo)
        private var currentTeam: Team? = null

        init {
            itemView.setOnClickListener {
                currentTeam?.let { onClick(it) }
            }
        }

        fun bind(team: Team) {
            currentTeam = team
            teamName.text = team.name

            // Log URL gambar
            Log.d("TeamAdapter", "Loading image from URL: ${team.imagePath}")

            Glide.with(itemView.context)
                .load(team.imagePath)
                .error(Icons.Outlined.Clear) // Placeholder untuk error
                .into(teamLogo)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra("TEAM_NAME", team.name)
                    putExtra("TEAM_LOGO", team.imagePath)
                    putExtra("COUNTRY_ID", team.countryId)
                    putExtra("VENUE_ID", team.venueId)
                    putExtra("GENDER", team.gender)
                    putExtra("FOUNDED", team.founded)
                    putExtra("TYPE", team.type)
                    putExtra("LAST_PLAYED_AT", team.lastPlayedAt)
                }
                itemView.context.startActivity(intent)
            }
        }
    }
}
