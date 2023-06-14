package com.example.randompassword

class PasswordManager {
    private val characters ="abcdefghıijklmnoöprsştuüvyzwxq1234567890!#$%&/=?*,;+-"

    fun generatePassword(length:Int,specialWord:String):String{
        val stringBuilder=StringBuilder(length)
        for (x in 0 until length){
            val random=characters.random()
            stringBuilder.append(random)
        }
        stringBuilder.insert((0 until length).random(),specialWord)
        return stringBuilder.toString()
    }
}