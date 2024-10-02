package com.foliveira.testxml.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import com.foliveira.testxml.R

class CheckBoxFragment : Fragment() {
    var check1: CheckBox? = null
    var check2: CheckBox? = null
    var check3: CheckBox? = null
    var check4: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            val frase = it.getString(ID) ?: "Sem frase"

            Toast.makeText(requireContext(), frase, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check_box, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        check1 = view.findViewById(R.id.optionOne)
        check2 = view.findViewById(R.id.optionTwo)
        check3 = view.findViewById(R.id.optionThree)
        check4 = view.findViewById(R.id.optionFour)

        setupCheckBox()
    }

    private fun setupCheckBox() {
        check1?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Opção 1 selecionada", Toast.LENGTH_SHORT).show()
            }
        }
        check2?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Opção 2 selecionada", Toast.LENGTH_SHORT).show()
            }
        }
        check3?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Opção 3 selecionada", Toast.LENGTH_SHORT).show()
            }
        }
        check4?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Opção 4 selecionada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        val ID = "FRASE"

        fun newInstance(frase: String) = CheckBoxFragment().apply {
            arguments = Bundle().apply {
                putString(ID, frase)
            }
        }
    }
}