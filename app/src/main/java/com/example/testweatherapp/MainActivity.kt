package com.example.testweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.Volley
import com.example.testweatherapp.databinding.ActivityMainBinding
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

const val API_KEY = "66a565094709460985d145052232206"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("Moscow")
        }
    }
    private fun getResult(name: String){
        val url = "http://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,url,
            {
                response->
                val obj = JSONObject(response)
                Log.d("MyLog","Response: $response")
            },
            {
                Log.d("MyLog","Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }


}