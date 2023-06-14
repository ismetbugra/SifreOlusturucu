package com.example.randompassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.randompassword.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            olustur(it)
        }
    }

    fun olustur(view:View){
        var uzunluk=binding.uzunlukEdittext.text.toString()
        var specialWord=binding.kelimeEdittext.text.toString()
        if(inputCheck(uzunluk, specialWord)){
            var length=uzunluk.toInt()
            var password=PasswordManager()
            var sifre=password.generatePassword(length,specialWord)
            binding.sifreTextview.text="Şifreniz:${sifre}"
        }else{
            Toast.makeText(this,"Lütfen istenenleri giriniz!",Toast.LENGTH_LONG).show()
        }
    }

    fun inputCheck(uzunluk: String,specialWord:String):Boolean {
        return !(uzunluk.isEmpty() || specialWord.isEmpty())

    }
}