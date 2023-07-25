package com.example.fragmenttouchapp

import android.icu.text.Transliterator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class Fragment2 : Fragment() {


    private var ls = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val fcvLand1 = requireActivity().findViewById<View>(R.id.fcvLand1)
        if(fcvLand1 == null){
            ls= false

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val screen2 = inflater.inflate(R.layout.fragment_2, container, false)

        val tvMessage :TextView = screen2.findViewById(R.id.tvMessage)

        val arrayMessage= arrayOf("Message0","Message1","Message2","Message3","Message4")


        if(ls) {
            val args = requireArguments()
            val argsPosition = args.getInt("POSITION")
            tvMessage.text= arrayMessage[argsPosition]


        }else{

            val itemPosition = requireActivity().intent.getIntExtra("POSITION", 0)
            tvMessage.text = arrayMessage[itemPosition]
        }


        return screen2
    }
}