package com.techand.pagingapp

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.techand.pagingapp.data.model.CharResult
import com.techand.pagingapp.data.network.RetroService

class CharacterPagingSource(val apiService: RetroService) : PagingSource<Int, CharResult>() {
    override fun getRefreshKey(state: PagingState<Int, CharResult>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharResult> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.getDataFromApi(nextPage)
            var nextPageNumber: Int? = null
            if (response.info.next != null) {
                val uri = Uri.parse(response.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            LoadResult.Page(data = response.results, prevKey = null, nextKey = nextPageNumber)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}