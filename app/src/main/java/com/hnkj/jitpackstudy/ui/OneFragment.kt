package com.hnkj.jitpackstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hnkj.jitpackstudy.MyApplication
import com.hnkj.jitpackstudy.R
import com.hnkj.jitpackstudy.viewModels.UserViewModel
import com.hnkj.jitpackstudy.viewModels.UserViewModelFactory

class OneFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((requireActivity().application as MyApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val views = inflater.inflate(R.layout.fragment_one, container, false)
        val recyclerView = views.findViewById<RecyclerView>(R.id.recyclerview_userList)

        val adapter = UserAdapter(userViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())


        /*textView?.setOnClickListener {
            findNavController().navigate(R.id.twoFragment)
        }*/
        //等同于上面的点击事件
//        textView?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.twoFragment, null))
        /*textView?.setOnClickListener {
            val snNameArg = "test"
            val action = OneFragmentDirections.actionOneFragmentToTwoFragment(snNameArg)
            //java 代码  ConfirmationAction action =
            //           SpecifyAmountFragmentDirections.confirmationAction();
            // action.setSnName(snNameArg);
            //   Navigation.findNavController(view).navigate(action);
            findNavController().navigate(action)


        }*/
        val addUser = views.findViewById<FloatingActionButton>(R.id.add_user)
        addUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.twoFragment, null))
        userViewModel.allUsers.observe(viewLifecycleOwner) { users ->
            users?.let {
                adapter.submitList(it)
            }
        }
        return views
    }
}