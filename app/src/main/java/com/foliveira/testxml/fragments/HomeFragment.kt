package com.foliveira.testxml.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.foliveira.testxml.R
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    var checkboxBtn: Button? = null
    var seekBarBtn: Button? = null
    var ratingBarBtn: Button? = null
    var imageviewBtn: Button? = null
    var alertDialogBtn: Button? = null
    var snackbarBtn: Button? = null

    var botoesClicados: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("HomeFragment", "Executei o método onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "Executei o método onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "Executei o método onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("HomeFragment", "Executei o método onViewCreated")

        checkboxBtn = view.findViewById(R.id.checkboxBtn)
        seekBarBtn = view.findViewById(R.id.seekBarBtn)
        ratingBarBtn = view.findViewById(R.id.ratingBarBtn)
        imageviewBtn = view.findViewById(R.id.imageviewBtn)
        alertDialogBtn = view.findViewById(R.id.alertDialogBtn)
        snackbarBtn = view.findViewById(R.id.snackbarBtn)

        setupButtons()
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeFragment", "Executei o método onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeFragment", "Executei o método onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeFragment", "Executei o método onPause")
    }

    override fun onStop() {
        Log.d("HomeFragment", "Executei o método onStop")
        super.onStop()
    }

    private fun setupButtons() {
        checkboxBtn?.setOnClickListener {
            val fragment = CheckBoxFragment.newInstance("Estou aprendendo a programar para o Android!")
            parentFragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .addToBackStack(null)
                .commit()
            botoesClicados++
            updateBotoesClicados()
        }

        seekBarBtn?.setOnClickListener {
            val fragment = SeekBarFragment.newInstance()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .addToBackStack(null)
                .commit()
            botoesClicados++
            updateBotoesClicados()
        }

        ratingBarBtn?.setOnClickListener {
            val fragment = RatingBarFragment.newInstance()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .addToBackStack(null)
                .commit()
            botoesClicados++
            updateBotoesClicados()
        }

        imageviewBtn?.setOnClickListener {
            val fragment = ImageViewFragment.newInstance()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment)
                .addToBackStack(null)
                .commit()
            botoesClicados++
            updateBotoesClicados()
        }

        alertDialogBtn?.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Título do Dialog")
                .setMessage("Mensagem do Dialog")
                .setPositiveButton("OK") { _, _ ->
                    Toast.makeText(requireContext(), "Botão OK pressionado", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar") { _, _ ->
                    Toast.makeText(requireContext(), "Botão Cancelar pressionado", Toast.LENGTH_SHORT).show()
                }
                .create()

            dialog.show()
            botoesClicados++
            updateBotoesClicados()
        }

        snackbarBtn?.setOnClickListener {
            val snackbar = Snackbar.make(requireView(), "Mensagem da Snackbar", Snackbar.LENGTH_SHORT).setAction("Ação") {
                Toast.makeText(requireContext(), "Ação da Snackbar", Toast.LENGTH_SHORT).show()
            }
            snackbar.show()

            botoesClicados++
            updateBotoesClicados()
        }
    }

    fun updateBotoesClicados() {
        val texto = "Botões clicados: $botoesClicados"
        Toast.makeText(requireContext(), texto, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}