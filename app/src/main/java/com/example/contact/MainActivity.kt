package com.example.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DataViewModel

   private lateinit var recyclerView: RecyclerView

   private  lateinit var itemAdapter: ItemAdapter

   //private  lateinit var layoutManager:StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

         initApi()
    }
    fun initApi(){


         viewModel=ViewModelProvider(this).get(DataViewModel::class.java)
         viewModel.getApiData()

        viewModel.dataList.observe(this, Observer {
            initAdapter(listOf(it))
        })
    }
    private  fun initAdapter(datas:List<ResultList>){

         recyclerView = findViewById(R.id.recyclerView)

         recyclerView.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
         itemAdapter= ItemAdapter(datas,this)
         recyclerView.adapter = itemAdapter

     }
}























































    //lateinit var  binding: ActivityMainBinding

//    private lateinit var recyclerView: RecyclerView
//
//    private lateinit var itemList: ArrayList<Int>
//
//
//
//    private lateinit var itemAdapter: ItemAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        val api = RetrofitHelper.getInstance().create(Api::class.java)
//        val call =api.getResults()
//
////        call.enqueue(object : retrofit2.Callback<MutableList<ResultList>>{
////            override fun onResponse(
////                call: Call<MutableList<ResultList>>,
////                response: Response<MutableList<ResultList>>
////            ) {
////                if(response.isSuccessful){
////                    Log.d("ali: ", response.body().toString())
////                }
////            }
////
////            override fun onFailure(call: Call<MutableList<ResultList>>, t: Throwable) {
////
////            }
////
////        })
//
//
//
//
//         //launching a new coroutine
//        GlobalScope.launch {
//            val result = Api.getResults()
//            if (result.isSuccessful)
//            // Checking the results
//                Log.d("ali: ", result.body().toString())
//            else
//                Log.d("ali not succ: ", result.body().toString())
//        }
//
//        init()
//    }
//
//    private fun init() {
//        itemList = ArrayList()
//
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager =
//            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//
//        addToList()
//        itemAdapter = ItemAdapter(itemList,this)
//
//
//
//        recyclerView.adapter = itemAdapter
//    }
//
//
//    private fun addToList() {
//        itemList.add(R.drawable.img1)
//        itemList.add(R.drawable.img5)
//        itemList.add(R.drawable.img2)
//        itemList.add(R.drawable.img6)
//        itemList.add(R.drawable.img3)
//        itemList.add(R.drawable.img7)
//        itemList.add(R.drawable.img4)
//        itemList.add(R.drawable.img8)
//        itemList.add(R.drawable.img6)
//        itemList.add(R.drawable.img3)
//        itemList.add(R.drawable.img7)
//        itemList.add(R.drawable.img4)
//        itemList.add(R.drawable.img8)
//        itemList.add(R.drawable.img6)
//        itemList.add(R.drawable.img3)
//    }
//
//
//}