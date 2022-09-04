package com.example.dipractice.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.dipractice.databinding.FragmentMemeBinding
import com.example.dipractice.ui.adapter.MemeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MemeFragment : Fragment() {

    private var _binding: FragmentMemeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MemeViewModel by viewModels()

    private val adapter by lazy {
        MemeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMemeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter


        viewLifecycleOwner.lifecycleScope.launch{
            viewModel.getMeme().collect{
                adapter.submitList(it)

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}