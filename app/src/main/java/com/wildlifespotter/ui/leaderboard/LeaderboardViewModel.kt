package com.wildlifespotter.ui.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildlifespotter.data.repository.UserRepository
import com.wildlifespotter.domain.model.User

class LeaderboardViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _leaderboard = MutableLiveData<List<User>>()
    val leaderboard: LiveData<List<User>> get() = _leaderboard

    fun fetchLeaderboard() {
        // Fetch leaderboard data from the repository
        _leaderboard.value = userRepository.getLeaderboard()
    }
}