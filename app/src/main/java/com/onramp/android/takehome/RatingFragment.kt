package com.onramp.android.takehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_rating.*
import kotlinx.android.synthetic.main.fragment_rating.view.*
import java.util.zip.Inflater

class RatingFragment:DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View= inflater.inflate(R.layout.fragment_rating,container,false)

            rootView.cancel_rating_Button.setOnClickListener {
                dismiss()
            }

        rootView.submit_rating_Button.setOnClickListener {
            val selectedID = radioGroup.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedID)

            var ratingResult = radio.text.toString()

            Toast.makeText(context,"You rated: $ratingResult", Toast.LENGTH_LONG).show()
            dismiss()
        }
        return rootView
    }
}