package com.example.android.trackmysleepquality.sleeptracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android.trackmysleepquality.R

class SleepDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sleep_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = SleepDetailFragmentArgs.fromBundle(arguments!!)
        val nightByArguments = arguments.sleepNightKey

        Toast.makeText(activity, nightByArguments.toString(), Toast.LENGTH_LONG).show()

    }
}