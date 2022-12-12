package com.example.optionmenus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction
    var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItems.add("ssss")

        // assign and get the object for the FragmentManager by using the below statements
        // supportFragmentManager.beginTransaction().add(R.id.frame1, HomeFragment()).commit()
        fmanager = supportFragmentManager
        //get the object for FragmentTransaction and Initialize the transaction
        val fragment = HomeFragment()
        val args = Bundle()
        args.putStringArrayList("items", listItems)
        fragment.arguments = args
        tx = fmanager.beginTransaction()
        /* by default we are going to show the HomeFragment in onCreate() method using add() method
            * add() method accepts two parameters -
            * 1. id of fragment 2.object of Fragment class*/
        tx.add(R.id.frame1, fragment)
        // Commit the fragment transaction
        tx.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
       // Code to get the title and icon on the option overflow
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean {
        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    fun home(view: View) {
        val fragment = HomeFragment()
        val args = Bundle()
        args.putStringArrayList("items", listItems)
        fragment.arguments = args

        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, fragment)
        tx.commit()
    }
    fun about(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, AboutFragment())
        tx.commit()
    }

    fun work(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, WorkFragment())
        tx.commit()
    }

    fun contact(view: View) {
        tx = fmanager.beginTransaction()
        // when the user selects the Home button, we are replacing the HomeFragment
        tx.replace(R.id.frame1, ContactFragment())
        tx.commit()
    }
}
/*
val fragment = HomeFragment()
val args = Bundle()
args.putStringArrayList("items", listItems)
//args.putExtra("items", listItems)
fragment.arguments = args

 */