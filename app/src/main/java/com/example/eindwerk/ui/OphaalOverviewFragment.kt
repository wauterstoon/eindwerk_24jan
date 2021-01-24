package com.example.eindwerk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.eindwerk.OphaalOverviewFragmentDirections
import com.example.eindwerk.adapters.OphaalAdapter
import com.example.eindwerk.adapters.OphaalClickListener
import com.example.eindwerk.data.remote.GhentApi
import com.example.eindwerk.databinding.FragmentOphaalOverviewBinding
import com.example.eindwerk.models.Ophaal
import com.example.eindwerk.repos.ReposUtils
import com.example.eindwerk.viewmodels.OphaalOverviewViewModel
import com.example.eindwerk.viewmodels.OphaalOverviewViewModelFactory


class OphaalOverviewFragment: Fragment() ,OphaalClickListener{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOphaalOverviewBinding.inflate(inflater,container,false)
        val factory = OphaalOverviewViewModelFactory(ReposUtils.createOphaalRepo(requireContext()))
        val viewModel =ViewModelProvider(this, factory).get(OphaalOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = OphaalAdapter(this)
        binding.adapter = adapter



        viewModel.ophaals.observe(viewLifecycleOwner, Observer {
            
        })

        return binding.root
    }

    override fun onOphaalClicked(ophaal: Ophaal) {
        val direction = OphaalOverviewFragmentDirections.actionOphaalOverviewFragmentToOphaalDetailFragment(ophaal)
        findNavController().navigate(direction)
    }
}