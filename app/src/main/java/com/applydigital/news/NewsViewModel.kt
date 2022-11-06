package com.applydigital.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applydigital.core.result.State
import com.applydigital.domain.model.News
import com.applydigital.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {


    private var _fetchNews = MutableLiveData<State<News>>()
    val fetchNews: LiveData<State<News>> get() = _fetchNews


    fun fetchData() {
        viewModelScope.launch {
            val result = with(Dispatchers.IO) {
                newsUseCase.fetchNews().single()
            }
            when (result) {
                is State.Success -> {
                    _fetchNews.value = State.Success(result.data!!)
                }

                is State.Error -> {
                    _fetchNews.value = State.Error(result.message.toString(), result.data)
                }
            }
        }
    }

    fun deleteNewsItem(newsId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase.deleteNewsItem(newsId)
        }
    }
}