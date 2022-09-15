package com.maxataliyev_01.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.maxataliyev_01.alertdialog.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addContactDialog=AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want add Mr. Poop to your contact list ?")
            .setIcon(R.drawable.ic_baseline_person_add_24)
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "You added Mr Poop to your contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this, "You didn't add Mr Poop to your contact list", Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }



        val option= arrayOf("First Item","Second Item","Third Item")
        val singleChoiceDialog=AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(option,0){ _,i->
                Toast.makeText(this, "You Clicked on ${option[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept"){_,_->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("Decline"){_,_->
                Toast.makeText(this, "You decline the SingletonChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }


        val multiChoiceDialog=AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(option, booleanArrayOf(false,false,true)){ _, i,isChecked->
                if (isChecked){
                    Toast.makeText(this, "You checked ${option[i]}", Toast.LENGTH_SHORT).show()
                }else
                    Toast.makeText(this, "You unchecked ${option[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept"){_,_->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("Decline"){_,_->
                Toast.makeText(this, "You decline the SingletonChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }

    }
}