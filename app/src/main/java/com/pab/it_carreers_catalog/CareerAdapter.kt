package com.pab.it_carreers_catalog

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CareerAdapter(private val careerList: List<CareerItem>) :
    RecyclerView.Adapter<CareerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        val tvName: TextView = itemView.findViewById(R.id.tv_career_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)  // kalau sudah ada deskripsi
        val cardBackground: LinearLayout = itemView.findViewById(R.id.card_background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_career_path, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = careerList[position]

        // Set nama karier
        holder.tvName.text = item.name

        // Set icon
        holder.ivIcon.setImageResource(item.iconRes)

        // Set background gradient (pakai resource drawable gradient)
        try {
            val gradient = holder.itemView.context.getDrawable(item.gradientRes)
            holder.cardBackground.background = gradient
        } catch (e: Exception) {
            // Fallback kalau gradient ga ditemukan
            holder.cardBackground.setBackgroundColor(Color.parseColor("#6366F1"))  // warna default
        }

        holder.tvDescription.text = item.description
        // Set deskripsi kalau ada (opsional, kalau XML lu sudah punya tv_description)
        // holder.tvDescription.text = item.description ?: "Deskripsi karier"

        // Klik card → buka detail activity
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, item.detailActivity)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = careerList.size
}