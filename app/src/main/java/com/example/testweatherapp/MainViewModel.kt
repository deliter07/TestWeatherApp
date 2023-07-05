package com.example.testweatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testweatherapp.adapters.DayItem

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<DayItem>()
    val liveDataList = MutableLiveData<List<DayItem>>()
}