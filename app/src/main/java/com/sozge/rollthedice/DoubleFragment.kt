package com.sozge.rollthedice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sozge.rollthedice.databinding.FragmentDoubleBinding
import com.sozge.rollthedice.databinding.FragmentSingleBinding

class DoubleFragment : Fragment() {

    private var _binding: FragmentDoubleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDoubleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rollButtonDouble.setOnClickListener {
            rollDices()
        }
    }

    private fun rollDices() {
        val randomNumber1 = (1..6).random()
        val randomNumber2 = (1..6).random()
        val sumRandomNum = randomNumber1 + randomNumber2
        val stringNums = "${randomNumber1} / ${randomNumber2} = ${sumRandomNum}"

        binding.diceNum.text = stringNums

        val drawableResource = when (randomNumber1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (randomNumber2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.firstDice.setImageResource(drawableResource)
        binding.secondDice.setImageResource(drawableResource2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}