package com.example.erprecord.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.entities.Buttons
import com.example.erprecord.utils.inflate

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