package com.example.projectweather.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projectweather.R

class SecondDetailFragment : Fragment() {

    lateinit var viewModel : SecondDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SecondDetailViewModel::class.java)
        return inflater.inflate(R.layout.weather_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tv1 = view.findViewById<TextView>(R.id.temperature)
        val tv2 = view.findViewById<TextView>(R.id.wind)

        viewModel.nextThreeDaysWeather.observe(viewLifecycleOwner) { forecastList ->
            if (!forecastList.isNullOrEmpty()) {
                val nextThreeDaysForecast = StringBuilder()
                for (forecast in forecastList) {
                    nextThreeDaysForecast.append("Day: ${forecast.day}, Temperature: ${forecast.temperature}, Wind: ${forecast.wind}\n")
                }
                tv1.text = nextThreeDaysForecast.toString()
            }
        }

        super.onViewCreated(view, savedInstanceState)


        val button = view.findViewById<Button>(R.id.buttonTo1)
        button.setOnClickListener{ findNavController().navigate(R.id.action_weatherDetailFragment_to_weatherListFragment)
        }
    }
}