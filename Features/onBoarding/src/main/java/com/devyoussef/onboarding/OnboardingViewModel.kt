package com.devyoussef.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devyoussef.local.datastore.DataStoreManager
import com.devyoussef.local.datastore.PreferencesKeys.IS_WATCHING_ONBOARDING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

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