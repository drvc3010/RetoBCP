package com.example.changemoney.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.changemoney.model.CountryMoneyModel
import android.R.attr.name



class DBHelper(context:Context) :SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VER){


    override fun onCreate(db: SQLiteDatabase?) {
        Log.v("SQL QUERY" , "PASO POR ACA")
       val  CREATE_TABLE_QUERY = (
               """CREATE TABLE $TABLE_NAME_COUNTRYMONEY ( $COL_ID INTEGER PRIMARY KEY ,$COL_COD_MON_FROM TEXT ,$COL_DESCRIPTION_MON_FROM TEXT ,$COL_VALUE_MON_FROM REAL ,$COL_COD_MON_TO TEXT ,$COL_DESCRIPTION_MON_TO TEXT ,$COL_VALUE_MON_TO REAL )"""
               )
        Log.v("SQL QUERY" , CREATE_TABLE_QUERY)
        try {


        db?.execSQL(CREATE_TABLE_QUERY)

        } catch (  ex : SQLiteException) {

            Log.v("SQL QUERY" , ex.message)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COUNTRYMONEY)
        onCreate(db)
    }

    companion object  DATA_BASE{
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "bdtest.db"

        // TABLE

        private  val  TABLE_NAME_COUNTRYMONEY ="CountryMoney"
        private  val COL_ID="Id"
        private  val  COL_COD_MON_FROM = "codigo_moneda_from"
        private  val  COL_DESCRIPTION_MON_FROM = "descripcion_moneda_from"
        private  val  COL_VALUE_MON_FROM = "valor_moneda_from"
        private  val  COL_COD_MON_TO = "codigo_moneda_to"
        private  val  COL_DESCRIPTION_MON_TO = "descripcion_moneda_to"
        private  val  COL_VALUE_MON_TO = "valor_moneda_to"



    }

    fun allCountryMoney () : List<CountryMoneyModel> {
        val listCM = ArrayList<CountryMoneyModel>()
        val selectQuery = "SELECT  * FROM ${DATABASE_NAME}"
        val db:SQLiteDatabase  = this.writableDatabase
        val cursor  = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()){
            do{
                val item = CountryMoneyModel()
                item.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                item.code_money_from = cursor.getString(cursor.getColumnIndex(COL_COD_MON_FROM))
                item.description_money_from = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION_MON_FROM))
                item.value_money_from = cursor.getDouble(cursor.getColumnIndex(COL_VALUE_MON_FROM))
                item.code_money_to = cursor.getString(cursor.getColumnIndex(COL_COD_MON_TO))
                item.description_money_to = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION_MON_TO))
                item.value_money_to = cursor.getDouble(cursor.getColumnIndex(COL_VALUE_MON_TO))
                listCM.add(item)
            } while (cursor.moveToNext())
        }

        return listCM
    }

    fun  addMoney(moneycountry: CountryMoneyModel){
        val db :SQLiteDatabase  = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID , moneycountry.id)
        values.put(COL_COD_MON_FROM , moneycountry.code_money_from)
        values.put(COL_DESCRIPTION_MON_FROM , moneycountry.description_money_from)
        values.put(COL_VALUE_MON_FROM , moneycountry.value_money_from)
        values.put(COL_COD_MON_TO , moneycountry.code_money_to)
        values.put(COL_DESCRIPTION_MON_TO , moneycountry.description_money_to)
        values.put(COL_VALUE_MON_TO , moneycountry.value_money_to)
        var res = db.insert(TABLE_NAME_COUNTRYMONEY,null,values)
        Log.v("VALOR INSERT" , res.toString())
        db.close()
    }

    fun fillTable () {
        val moneycountryPE1 = CountryMoneyModel(1,"SOL","SOL",1.0,"USD","DOLAR",3.4)
        val moneycountryPE2 = CountryMoneyModel(2,"SOL","SOL",1.0,"EUR","EURO",4.0)
        addMoney(moneycountryPE1)
        addMoney(moneycountryPE2)


    }

    fun getCountryModelbyMoneys(codeFrom :String , codeTo : String):CountryMoneyModel{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_COUNTRYMONEY WHERE  $COL_COD_MON_FROM = '" + codeFrom + "' and $COL_COD_MON_TO ='$codeTo'", null)
        val  result = CountryMoneyModel()
        if (cursor.moveToFirst()){
            do{

                result.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                result.code_money_from = cursor.getString(cursor.getColumnIndex(COL_COD_MON_FROM))
                result.description_money_from = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION_MON_FROM))
                result.value_money_from = cursor.getDouble(cursor.getColumnIndex(COL_VALUE_MON_FROM))
                result.code_money_to = cursor.getString(cursor.getColumnIndex(COL_COD_MON_TO))
                result.description_money_to = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION_MON_TO))
                result.value_money_to = cursor.getDouble(cursor.getColumnIndex(COL_VALUE_MON_TO))

            } while (cursor.moveToNext())
        }

        return  result;
    }
}