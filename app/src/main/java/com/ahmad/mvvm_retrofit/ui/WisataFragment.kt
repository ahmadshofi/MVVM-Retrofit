package com.ahmad.mvvm_retrofit.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ahmad.mvvm_retrofit.R
import com.ahmad.mvvm_retrofit.adapter.WisataAdapter
import com.ahmad.mvvm_retrofit.model.DataItem
import kotlinx.android.synthetic.main.fragment_wisata.*

/**
 * A simple [Fragment] subclass.
 */
class WisataFragment : Fragment() {

    companion object {
        fun newInstance() = WisataFragment()
    }

    private lateinit var viewModel: WisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wisata, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WisataViewModel::class.java)

        viewModel.getStatus().observe(this, Observer { t ->
            if (t ?: true) {
                list.visibility = View.GONE
                textStatus.visibility = View.VISIBLE
            } else {
                list.visibility = View.VISIBLE
                textStatus.visibility = View.GONE
            }

        })

        viewModel.setData().observe(this, Observer { t ->
            t?.data?.let { showData(it as List<DataItem>) }
        })
    }

    private fun showData(data: List<DataItem>) {
        list.adapter = WisataAdapter(data)

    }

}