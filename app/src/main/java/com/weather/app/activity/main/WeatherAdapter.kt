package com.weather.app.activity.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weather.app.R
import com.weather.app.model.WeatherData
import com.weather.app.utils.Constants
import com.weather.app.utils.GlideApp
import kotlinx.android.synthetic.main.item_weather_data.view.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private var items: MutableList<WeatherData> = mutableListOf()

    fun setData(data: List<WeatherData>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_weather_data, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], this)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(item: WeatherData, listAdapter: WeatherAdapter) {
            val weather = item.weather[0]

            itemView.title.text = item.name
            itemView.description.text = weather.main + ": " + weather.description
            itemView.temp.text = item.main.temp.toString()+" C"

            itemView.context.let {
                GlideApp.with(it).load(Constants.BASE_PHOTO_URL + weather.icon + ".png").centerCrop()
                    .into(itemView.thumbnail)
            }
        }
    }
}
