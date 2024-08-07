package com.sozge.rollthedice


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.sozge.rollthedice.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.SingleButton.setOnClickListener {
            val action = HomePageFragmentDirections.actionHomePageFragmentToSingleFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
        binding.DoubleButton.setOnClickListener{
            val action = HomePageFragmentDirections.actionHomePageFragmentToDoubleFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
