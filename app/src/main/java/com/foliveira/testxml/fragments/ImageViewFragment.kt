package com.foliveira.testxml.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.foliveira.testxml.R

class ImageViewFragment : Fragment() {
    var imageView: ImageView? = null

    var alphaValue = 1.0F

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.imageView)

        setupImageView()
    }

    private fun setupImageView() {
        imageView?.setOnClickListener {
            val newAlpha = alphaValue - 0.1F
            it.alpha = newAlpha
            alphaValue = newAlpha
            it.invalidate()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ImageViewFragment()
    }
}