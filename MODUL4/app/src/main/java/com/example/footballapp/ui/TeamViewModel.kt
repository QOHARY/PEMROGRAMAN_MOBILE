package com.example.footballapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.network.ApiClient
import com.example.footballapp.network.Team
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> get() = _teams

    private val apiToken = "OqA7s8KB7ZvTJXOwHJ2QHFw2GyKCoMlEg0ArwJvODY0RKpQv2y6x18a6tCHf"

    init {
        getTeamData()
    }

    private fun getTeamData() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getTeams(apiToken)
                _teams.value = response.data
                Log.d("TeamViewModel", "Data fetched successfully: ${response.data}")
            } catch (e: Exception) {
                Log.e("TeamViewModel", "Error fetching data: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
