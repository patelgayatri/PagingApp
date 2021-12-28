package com.techand.pagingapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.techand.pagingapp.CharacterPagingSource
import com.techand.pagingapp.data.model.CharResult
import com.techand.pagingapp.data.network.RetroInstance
import com.techand.pagingapp.data.network.RetroService
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    var retroService: RetroService = RetroInstance.getRetroIn().create(RetroService::class.java)

    fun getListData(): Flow<PagingData<CharResult>> {

        return Pager(config = PagingConfig(pageSize = 34,maxSize=200),pagingSourceFactory = {CharacterPagingSource(retroService)}).flow.cachedIn(viewModelScope)
    }
}