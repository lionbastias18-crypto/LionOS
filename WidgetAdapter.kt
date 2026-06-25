package com.lionos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetAdapter(
    private val widgetList: List<String>
) : RecyclerView.Adapter<WidgetAdapter.WidgetViewHolder>() {

    class WidgetViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val widgetTitle: TextView =
            view.findViewById(R.id.widgetTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WidgetViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.widget_item, parent, false)

        return WidgetViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: WidgetViewHolder,
        position: Int
    ) {

        holder.widgetTitle.text = widgetList[position]
    }

    override fun getItemCount(): Int {

        return widgetList.size
    }
}