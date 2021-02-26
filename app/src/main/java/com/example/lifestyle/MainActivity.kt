package com.example.lifestyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(
                Model ("HOME TOUR", "https://i.pinimg.com/564x/4f/89/ab/4f89ab8891e22655177d053f495b72c5.jpg", "https://www.pinterest.co.kr/pin/119415827606871420/"),
                Model ("Company Craftsmanship", "https://i.pinimg.com/564x/f4/74/d1/f474d10d913ff152e5a3a110abe6d6ec.jpg","https://www.pinterest.co.kr/pin/119908408817257961/"),
                Model("The best neutral color scheme", "https://i.pinimg.com/564x/60/5b/4f/605b4f4252b7e3332a68c6a2fd3abadf.jpg", "https://www.pinterest.co.kr/pin/10203536645093510/")
        )

        val mAdapter = MainRvAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter

        mAdapter.itemClick = object : MainRvAdapter.ItemClick {
             override fun onClick(view: View, position: Int){
                Log.e("position: ", position.toString())

                 val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                 intent.putExtra("url", modelList.get(position).url)
                 startActivity(intent)
            }
        }

        /*val imgUrl = "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/435d656c54c2469bade7fd49f534293f.png"
        Picasso.get().load(imgUrl).into(imageView_test)*/

        mRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }
}