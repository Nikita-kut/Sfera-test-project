package com.nikita.kut.android.sfera_test_project

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nikita.kut.android.sfera_test_project.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!
    private val userListViewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            binding.tvUserModel.text = userListViewModel.userList.toString()
        } else {
            if (userListViewModel.textViewText != null) {
                binding.tvUserModel.text = userListViewModel.textViewText
            } else {
                binding.tvUserModel.text = userListViewModel.userList.toString()
            }
        }

        binding.btnAll.setOnClickListener {
            binding.tvUserModel.text = userListViewModel.userList.toString()
            userListViewModel.textViewText = binding.tvUserModel.text as String
        }

        binding.btnFilter.setOnClickListener {
            setTextFilter()
            userListViewModel.textViewText = userListViewModel.filterUserList.toString()
        }

    }

    private fun setTextFilter() {
        val handler = Handler()
        val filteredList = userListViewModel.filterUserList
        val maxCount = filteredList.size
        val runnable: Runnable = object : Runnable {
            var count = 0
            override fun run() {
                if (maxCount != 0) {
                    if (count < maxCount) {
                        count++
                        binding.tvUserModel.text =
                            filteredList[count - 1].toString()
                        handler.postDelayed(this, 1000)
                    }
                } else {
                    toast("Not element for show")
                }
            }
        }
        handler.postDelayed(runnable, 1000)
        binding.tvUserModel.text = userListViewModel.filterUserList.toString()
    }

    private fun toast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

fun main() {
    testSetTextFilter(listOf())
}

fun testSetTextFilter(filteredList: List<User>) {
    val maxCount = filteredList.size
    var testTextView: String? = null
    var count = 0

    for (i in 0..maxCount) {
        if (maxCount != 0) {
            if (count < maxCount) {
                count++
                testTextView =
                    filteredList[count - 1].toString()
                println(testTextView)
            }
        } else {
            println("Not element for show")
        }
    }
}
