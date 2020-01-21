package com.ahmad.mvvm_retrofit.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmad.mvvm_retrofit.model.Wisata
import com.ahmad.mvvm_retrofit.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WisataViewModel : ViewModel() {

    private var data = MutableLiveData<Wisata>()
    private var status = MutableLiveData<Boolean>()

    init {

        getData()
    }

    private fun getData() {

        status.value = true

        NetworkConfig().api().wisata().enqueue(object :Callback<Wisata>{
            override fun onFailure(call: Call<Wisata>, t: Throwable) {
                status.value = true
                data.value = null
            }

            override fun onResponse(call: Call<Wisata>, response: Response<Wisata>) {
                status.value = false

                if(response.isSuccessful){
                    data.value = response.body()
                }
                else{
                    status.value = true
                }



            }
        })
    }

    fun setData() : MutableLiveData<Wisata> {

        return data
    }

    fun getStatus():MutableLiveData<Boolean>{

        status.value = true

        return status


    }
}