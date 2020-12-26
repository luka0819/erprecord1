package com.example.erprecord.adapters

import android.app.AlertDialog
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.config.App
import com.example.erprecord.entities.Buttons
import com.example.erprecord.entities.Statistic
import com.example.erprecord.utils.inflate
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/*
* Created by ნიკოლოზ კაციტაძე on 12/26/20
*/

class ButtonsAdapter(private val buttonsList: ArrayList<Buttons>) :
    RecyclerView.Adapter<ButtonsAdapter.ButtonsViewHolder>() {

    class ButtonsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var button: Button

        fun bindButton(buttons: Buttons) {

            this.button = itemView.findViewById(R.id.a)

            this.button.text = buttons.buttonName

            button.setOnClickListener {

                val builder = AlertDialog.Builder(itemView.context)
                //set title for alert dialog
                builder.setTitle(R.string.dialogTitle)
                //set message for alert dialog
                builder.setMessage(R.string.dialogMessage)


                //performing positive action
                builder.setPositiveButton("Yes") { dialogInterface, which ->

                    val sdf1 = SimpleDateFormat("dd/M/yyyy")
                    val currentDate = sdf1.format(Date())
                    val sdf2 = SimpleDateFormat("hh:mm")
                    val currentTime = sdf2.format(Date())

                    val bName = this.button.text.toString()

                    App.instance.db.statisticDao()
                        .insertAll(Statistic(name = bName, date = currentDate, time = currentTime))

                    dialogInterface.dismiss()
                }

                //performing negative action
                builder.setNegativeButton("No") { dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
                alertDialog.setCanceledOnTouchOutside(false)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonsViewHolder {
        return ButtonsViewHolder(parent.inflate(R.layout.item_buttons))
    }

    override fun onBindViewHolder(holder: ButtonsViewHolder, position: Int) {
        holder.bindButton(buttonsList[position])
    }

    override fun getItemCount(): Int = buttonsList.size

    fun updateButtons(fixes: List<Buttons>) {
        this.buttonsList.clear()
        this.buttonsList.addAll(fixes)
        notifyDataSetChanged()
    }

}