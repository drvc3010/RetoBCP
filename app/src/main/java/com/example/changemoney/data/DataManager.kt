package com.example.changemoney.data

import android.content.Context
import com.example.changemoney.model.CountryMoneyModel

class DataManager {


fun loadDataMoneyCountry( context:Context) {
    val dbHelper = DBHelper(context)
    dbHelper.fillTable()

}

    fun getModelByCodes( context:Context , codeFrom:String , codeTo:String) :CountryMoneyModel {
        val dbHelper = DBHelper(context)
       return dbHelper.getCountryModelbyMoneys(codeFrom,codeTo)

    }



}