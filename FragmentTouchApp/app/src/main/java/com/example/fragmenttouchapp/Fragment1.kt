package com.example.fragmenttouchapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //picture inflated
        val screen1 = inflater.inflate(R.layout.fragment_1, container, false)

        val lv: ListView = screen1.findViewById(R.id.lv)

        val arrayTitle = arrayOf("title0","title1","title2","title3","title4")

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            arrayTitle

        )

        lv.adapter= adapter


        val fcvLand2 = requireActivity().findViewById<View>(R.id.fcvLand2)
        if(fcvLand2==null){
            lv.setOnItemClickListener { _, _, i, _ ->

                val intent = Intent(requireContext(),SecondActivity::class.java)
                intent.putExtra("POSITION", i)
                startActivity(intent)
            }

        }else {

            lv.setOnItemClickListener { _, _, i, _ ->

                val bundle= Bundle()
                bundle.putInt("POSITION", i)
                val fragment2= Fragment2()
                fragment2.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fcvLand2, fragment2)
                    .commit()
            }


        }


        return screen1

    }
}