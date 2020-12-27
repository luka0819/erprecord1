package com.example.erprecord.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.erprecord.R
import com.example.erprecord.entities.Statistic
import com.example.erprecord.utils.inflate

/*
* Created by ნიკოლოზ კაციტაძე on 12/27/20
*/

class StatisticsAdapter(private var statisticList: ArrayList<Statistic>) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    class StatisticsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var recordNameTextView: TextView
        private lateinit var recordDateTextView: TextView
        private lateinit var recordTimeTextView: TextView

        fun bind(statistic: Statistic) {

            recordNameTextView = itemView.findViewById(R.id.recordTextView)
            recordDateTextView = itemView.findViewById(R.id.recordDate)
            recordTimeTextView = itemView.findViewById(R.id.recordTime)

            recordNameTextView.text = statistic.name
            recordDateTextView.text = statistic.date
            recordTimeTextView.text = statistic.time

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        return StatisticsViewHolder(parent.inflate(R.layout.item_statistic))
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        holder.bind(statisticList[position])
    }

    override fun getItemCount(): Int = statisticList.size

    fun update(statisticList: List<Statistic>) {
        this.statisticList.clear()
        this.statisticList.addAll(statisticList)
        notifyDataSetChanged()
    }

}