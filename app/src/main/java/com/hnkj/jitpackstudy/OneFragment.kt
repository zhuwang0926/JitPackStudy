package com.hnkj.jitpackstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val views = inflater.inflate(R.layout.fragment_one, container, false)
        val textView = views.findViewById<TextView>(R.id.tv_one)
        /*textView?.setOnClickListener {
            findNavController().navigate(R.id.twoFragment)
        }*/
        //等同于上面的点击事件
//        textView?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.twoFragment, null))
        textView?.setOnClickListener {
            val snNameArg = "test"
            val action = OneFragmentDirections.actionOneFragmentToTwoFragment(snNameArg)
            //java 代码  ConfirmationAction action =
            //           SpecifyAmountFragmentDirections.confirmationAction();
            // action.setSnName(snNameArg);
            //   Navigation.findNavController(view).navigate(action);
            findNavController().navigate(action)


        }
        return views
    }
}