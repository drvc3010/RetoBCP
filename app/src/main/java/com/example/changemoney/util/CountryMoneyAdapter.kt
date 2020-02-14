package com.example.changemoney.util

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.changemoney.model.CountryMoneyModel
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*


class CountryMoneyAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

     lateinit  var TYPE_MONEY :String
     private var items : List<CountryMoneyModel> = ArrayList()
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun getItemCount(): Int {
         return items.size
     }

     override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

        class ModelMoney constructor(
            itemView: View
        ) :RecyclerView.ViewHolder(itemView)
        {
            val countryName = itemView.tvCountryName
            val countrychange = itemView.tvTypeChange
            val  mageCountry = itemView.imgCountry

            fun bind(countryMoneyModel: CountryMoneyModel){
                countryName.setText(countryMoneyModel.description_money_from)

            }
        }
 }


