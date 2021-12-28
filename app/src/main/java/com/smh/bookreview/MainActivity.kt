package com.smh.bookreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.smh.bookreview.api.BookService
import com.smh.bookreview.model.BestSellerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)
        bookService.getBestSellerBooks("99E31C8BE5814906499928BD2C9A94109473D7689F8FAE11F065A2447568DBAE")
            .enqueue(object: Callback<BestSellerDto>{
                override fun onResponse(
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>
                ) {
                    // TODO 성공처리
                    if (response.isSuccessful.not()) {
                        Log.e(TAG,"not Success!!")
                        return
                    }

                    response.body()?.let {
                        Log.e(TAG,it.toString())
                        it.books.forEach { book ->
                            Log.e(TAG, book.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                    // TODO 실패처리
                }

            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}