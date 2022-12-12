package com.example.optionmenus

import android.app.DatePickerDialog
import android.app.TimePickerDialog

import android.os.Bundle

import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    var adapter: ArrayAdapter<String>? = null
    var listItems: ArrayList<String>? = null

    var undoOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItems?.removeAt(listItems!!.size - 1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.home_fragment, container, false)
        listItems = arguments?.getStringArrayList("items")
        val listView = view.findViewById(R.id.listView) as ListView
        val addButton = view.findViewById(R.id.fab) as FloatingActionButton
        adapter = ArrayAdapter(view.context,android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
        addButton.setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Item added to list", Snackbar.LENGTH_LONG)
                .setAction("Undo", undoOnClickListener).show()
        }
        //println(listItems?.get(0))
        // Inflate the layout for this fragment
        return view
    }


    private fun addListItem() {
        val text = view?.findViewById(R.id.input) as EditText
        val value = text.text.toString()
        listItems?.add(value)
        adapter?.notifyDataSetChanged()
    }

}

