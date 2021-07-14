package com.hnkj.jitpackstudy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class TwoFragment : Fragment() {
    val safeArgs: TwoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        Log.e("zhuw", "snName = ${safeArgs.snName}")
        Toast.makeText(
            requireActivity(),
            "接收到OneFragment传递的数据 = ${safeArgs.snName}",
            Toast.LENGTH_SHORT
        ).show()

        //java 代码 TwoFragmentArgs.fromBundle(getArguments()).getSnName();
        val textView = view.findViewById<TextView>(R.id.tv_two)
        textView?.setOnClickListener {
            findNavController().navigateUp()
        }
        return view
    }


}