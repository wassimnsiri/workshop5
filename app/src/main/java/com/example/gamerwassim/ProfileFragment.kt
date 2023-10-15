package com.example.gamerwassim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamerwassim.databinding.FragmentProfileBinding
import com.google.android.material.appbar.MaterialToolbar

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)

        enableShoppingCartIcon(toolbar)

    }

    fun enableShoppingCartIcon(toolbar: MaterialToolbar) {
        val menu = toolbar.menu
        val cartIem = menu.findItem(R.id.cart)

        cartIem.isVisible = false
    }
}