package com.example.eindwerk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.eindwerk.OphaalDetailFragmentArgs
import com.example.eindwerk.databinding.FragmentOphaalDetailBinding
import com.example.eindwerk.viewmodels.OphaalDetailViewModel

class OphaalDetailFragment:Fragment() {

    val arguments: OphaalDetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
            val binding = FragmentOphaalDetailBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(this).get(OphaalDetailViewModel::class.java)
        viewModel.ophaal.observe(viewLifecycleOwner, Observer { binding.ophaal = it })
        viewModel.updateOphaal(arguments.ophaal)

        return binding.root
    }

}