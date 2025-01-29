package com.example.examapplication2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel : ViewModel() {
    private val _newsDetails = MutableLiveData<List<NewsModel>>(emptyList())
    val newsDetails: LiveData<List<NewsModel>> = _newsDetails
    private var job: Job? = null

    fun getNewsDetails(
        source: String,
        country: String,
    ) {

        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val repository = NewsRepository()
            val response = repository.getNewsInfo(source, country)
            withContext(Main) {
                _newsDetails.value = response
            }
        }
    }
}
