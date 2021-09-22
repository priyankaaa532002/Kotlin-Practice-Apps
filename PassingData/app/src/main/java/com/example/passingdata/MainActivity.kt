package com.example.passingdata

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnApply.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()
            val person = Person(name,age,country)
            Intent(this,SecondActivity::class.java).also {
//                it.putExtra("EXTRA_NAME",name)
//                it.putExtra("EXTRA_AGE",age)
//                it.putExtra("EXTRA_COUNTRY",country)
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }
        }

        //PERMISSIONS ->SENSITIVE(DON'T NEED ACCEPTANCE) / LESS SENSITIVE(NEEDS ACCEPTANCE)
        btnRequestPermission.setOnClickListener {
            requestPermissons()
        }

        //DIALOG AND ALERT BOXES----->>>>>

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to continue adding?")
            .setIcon(R.drawable.ic_person2)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this,"You added contact",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){ _, _ ->
                Toast.makeText(this,"You didn't add contact",Toast.LENGTH_SHORT).show()
            }.create()

        btnOne.setOnClickListener {
            addContactDialog.show()
        }

        //RADIO AND DIALOG BOXES
        val options = arrayOf("One","Two","Three")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Chose one of these options")
            .setSingleChoiceItems(options,0){ dialogInterface, i ->
                Toast.makeText(this,"You clicked ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this,"You accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Declined"){ _, _ ->
                Toast.makeText(this,"You declined",Toast.LENGTH_SHORT).show()
            }.create()

        btnTwo.setOnClickListener {
            singleChoiceDialog.show()
        }

        //CHECKBOX AND DIALOG BOXES
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Chose from these options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){_,i,isChecked->
                if (isChecked){
                    Toast.makeText(this,"You checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this,"You accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Declined"){ _, _ ->
                Toast.makeText(this,"You declined",Toast.LENGTH_SHORT).show()
            }.create()

        btnThree.setOnClickListener {
            multiChoiceDialog.show()
        }


        //SPINNER------>>>>>>

        val customList = listOf("one","two","three","four")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,customList)
        spMonth.adapter = adapter


        spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            //ctrl + i ---> add em all
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"you selected ${adapterView?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun hasWriteExternalStoragePermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestPermissons(){
        var permissionsToRequest = mutableListOf<String>()
        if (!hasWriteExternalStoragePermission()){
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationForegroundPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLocationBackgroundPermission()){
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissionsToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionsToRequest.toTypedArray(),0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("PermissionRequest","${permissions[i]} granted")
                }
            }
        }
    }



    //MENU ----->>>>
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this, "add contact?", Toast.LENGTH_SHORT).show()
            R.id.miFavourites -> Toast.makeText(this, "favy favy?", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "setting hui?", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "add feedback?", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()

        }
        return true
    }
}