package com.example.spacerepository.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SpaceViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<List<SpaceObject>>(emptyList())
    val uiState: StateFlow<List<SpaceObject>> =  _uiState.asStateFlow()
    init {
        _uiState.value = SpaceRepository.getSpaceObjects()
    }
}