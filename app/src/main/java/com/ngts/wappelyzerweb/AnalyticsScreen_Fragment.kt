package com.ngts.wappelyzerweb

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.ngts.wappelyzerweb.databinding.FragmentAnalyticsScreenBinding
import com.ngts.wappelyzerweb.databinding.FragmentHomeScreenBinding

class AnalyticsScreen_Fragment : Fragment() {

    private lateinit var binding: FragmentAnalyticsScreenBinding
    lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalyticsScreenBinding.inflate(inflater, container, false)
        barChart= binding.idBarChart

        val list:ArrayList<BarEntry> = ArrayList()

        list.add(BarEntry(50f,40f))
        list.add(BarEntry(55f,10f))
        list.add(BarEntry(60f,50f))
        list.add(BarEntry(65f,80f))
        list.add(BarEntry(70f,100f))
        list.add(BarEntry(75f,40f))
        list.add(BarEntry(80f,90f))

        val barDataSet= BarDataSet(list,"list")
        barDataSet.setColor(Color.rgb(32,208,195))
        barDataSet.valueTextColor = Color.BLACK

        val barData= BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.legend.isEnabled =(true)
        barChart.data=barData
        barChart.description.text="Bar Chart"
        barChart.animateY(2500)
        // Inflate the layout for this fragment

        //barChart.getPaint(barChart.PAINT_VALUES).setColor(Color.BLUE);
        return binding.root
    }

}



