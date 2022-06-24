package com.example.contact

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var recyclerView: RecyclerView
private lateinit var itemAdapter: ItemAdapter
class DataViewModel: ViewModel() {


    var dataList = MutableLiveData<ResultList>()
    var datalist2 = mutableListOf<ResultList>()



    fun getApiData(){
        val service=RetrofitHelper.getInstance().create(Api::class.java)
        service.getResults().enqueue(object: Callback<ResultList>{
            override fun onResponse(
                call: Call<ResultList>,
                response: Response<ResultList>

            ) {
                if (response.isSuccessful) {


                    for(elements in 1..10) {
                        datalist2.add(response.body()!!)
                        Log.d("List 2", datalist2.toString() + datalist2.size.toString())
                        Log.d("List 2 size", datalist2.size.toString())
                        dataList.value = response.body()

                    }

                   // Log.d("Success",response.body().toString())

                }
            }

            override fun onFailure(call: Call<ResultList>, t: Throwable) {
                //Log.d("Error",t.printStackTrace().toString())

            }

        })
    }

}