package com.hyunday.greenery_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.JsonObject
import kotlinx.coroutines.*


class InfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, null)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.22.8.148:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GreeneryApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                val response = service.getRequest()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        var items = response.body()
                        if (items != null) {
                            for (i in 0 until items.count()) {
                                val id = items[i].id ?: "N/A"
                                val temperature = items[i].temperature ?: "N/A"
                                val humidity = items[i].humidity ?: "N/A"
                                val solid_humidity = items[i].solid_humidity ?: "N/A"
                                val created_at = items[i].created_at ?: "N/A"
                                val info =
                                    "id: $id\ntemperature: $temperature\nhumidity: $humidity\nsolid_humidity: $solid_humidity\ncreated_at: $created_at"
                                Log.d("retrofit", info)
                                (view.findViewById(R.id.textview_info_plant) as TextView).setText(
                                    info
                                )
                            }
                        }
                    }
                }
                delay(1000)
            }
        }

        return view
    }
}