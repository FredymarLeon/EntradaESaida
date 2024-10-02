package com.foliveira.testxml.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.foliveira.testxml.R

class RatingBarFragment : Fragment() {
    var ratingBar: RatingBar? = null
    var ratingValue: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rating_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ratingBar = view.findViewById(R.id.ratingBar)
        ratingValue = view.findViewById(R.id.ratingValue)

        setupRatingBar()
    }

    private fun setupRatingBar() {
        ratingBar?.setOnRatingBarChangeListener { _, rating, _ ->
            ratingValue?.text = "Nota: $rating"
        }
    }

    companion object {
        fun newInstance() = RatingBarFragment()
    }
}