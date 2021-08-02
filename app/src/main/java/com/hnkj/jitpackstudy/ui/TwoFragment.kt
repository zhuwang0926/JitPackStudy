package com.hnkj.jitpackstudy.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hnkj.jitpackstudy.MyApplication
import com.hnkj.jitpackstudy.R
import com.hnkj.jitpackstudy.data.User
import com.hnkj.jitpackstudy.viewModels.UserViewModel
import com.hnkj.jitpackstudy.viewModels.UserViewModelFactory

class TwoFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((requireActivity().application as MyApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        val buttonSave = view.findViewById<TextView>(R.id.button_save)
        val editUserName = view.findViewById<EditText>(R.id.edit_user_name)
        val editUserDescription = view.findViewById<EditText>(R.id.edit_user_description)
        buttonSave?.setOnClickListener {
            if (!TextUtils.isEmpty(editUserName.text.toString()) && !TextUtils.isEmpty(
                    editUserDescription.text.toString()
                )
            ) {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.save_success),
                    Toast.LENGTH_SHORT
                ).show()
                val user = User(
                    editUserName.text.toString(),
                    editUserDescription.text.toString()
                )
                userViewModel.insertUser(user)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireActivity(), getString(R.string.save_fail), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return view
    }


}