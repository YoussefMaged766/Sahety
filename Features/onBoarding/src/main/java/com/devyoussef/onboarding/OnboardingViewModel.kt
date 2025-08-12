package com.devyoussef.onboarding

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devyoussef.local.datastore.DataStoreManager
import com.devyoussef.local.datastore.PreferencesKeys.IS_WATCHING_ONBOARDING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import androidx.compose.runtime.State
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _currentPageIndex = mutableIntStateOf(0)
    val currentPageIndex: State<Int> = _currentPageIndex

    private val _direction = mutableIntStateOf(1) // 1 for next, -1 for previous
    val direction: State<Int> = _direction

    fun handleNextClick(itemCount: Int, navigateToIntro: () -> Unit) {
        if (_currentPageIndex.intValue < itemCount - 1) {
            nextPage(itemCount)
        } else {
            navigateToIntro()
//            saveOnboardingCompleted()
        }
    }

    fun nextPage(itemCount: Int) {
        if (_currentPageIndex.intValue < itemCount - 1) {
            _direction.intValue = 1
            _currentPageIndex.intValue += 1
        }
    }

    fun previousPage() {
        if (_currentPageIndex.intValue > 0) {
            _direction.intValue = -1
            _currentPageIndex.intValue -= 1
        }
    }

    fun saveOnboardingCompleted() {
        viewModelScope.launch {
            dataStoreManager.put(
                IS_WATCHING_ONBOARDING,
                true
            )
        }
    }

    fun isOnboardingCompleted(): Flow<Boolean> {
        return dataStoreManager.get(IS_WATCHING_ONBOARDING, false)
    }
}