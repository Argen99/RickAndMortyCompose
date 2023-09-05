package com.example.data.utils

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.model.BasePagingResponse
import retrofit2.HttpException
import java.io.IOException

private const val BASE_STARTING_PAGE = 1

abstract class BasePagingSource<ValueDto : DataMapper<Value>, Value : Any>(
    private val request: suspend (position: Int) -> BasePagingResponse<ValueDto>,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val page = params.key ?: BASE_STARTING_PAGE
        return try {
            val response = request(page)
            val nextPage = response.info.next?.let {
                val uri = Uri.parse(it)
                uri.getQueryParameter("page")?.toInt()
            }
            val prevPage = response.info.prev?.let {
                val uri = Uri.parse(it)
                uri.getQueryParameter("page")?.toInt()
            }

            LoadResult.Page(
                data = response.results.map { it.toDomain() },
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}