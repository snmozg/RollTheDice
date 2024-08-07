package com.sozge.rollthedice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sozge.rollthedice.databinding.FragmentSingleBinding

class SingleFragment : Fragment() {

    private var _binding: FragmentSingleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomNumber = (1..6).random()
        binding.diceNumber.text = randomNumber.toString()

        val drawableResource = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(drawableResource)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

