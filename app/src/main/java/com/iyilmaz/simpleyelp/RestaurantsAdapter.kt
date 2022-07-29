package com.iyilmaz.simpleyelp

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import android.widget.TextView as TextView1


class RestaurantsAdapter(val context: Context, val restaurants: List<YelpRestaurant>) :
    RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    override fun getItemCount() = restaurants.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bind(restaurant: YelpRestaurant) {
            itemView.findViewById<TextView1>(R.id.tvName).text = restaurant.name
            itemView.findViewById<RatingBar>(R.id.ratingBar).rating = restaurant.rating.toFloat()
            itemView.findViewById<TextView1>(R.id.tvNumReviews).text = "${restaurant.numReviews} Reviews"
            itemView.findViewById<TextView1>(R.id.tvAddress).text = restaurant.location.address
            itemView.findViewById<TextView1>(R.id.tvCategory).text = restaurant.categories[0].title
            itemView.findViewById<TextView1>(R.id.tvDistance).text = restaurant.displayDistance()
            itemView.findViewById<TextView1>(R.id.tvPrice).text = restaurant.price
            Glide.with(context).load(restaurant.imageURL).apply(RequestOptions().transform(
                CenterCrop(), RoundedCorners(20)
            )).into(itemView.findViewById<ImageView>(R.id.imageView))
        }

    }
}
