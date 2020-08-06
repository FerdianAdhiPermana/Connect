package com.manu.connect.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.manu.connect.R
import com.manu.connect.model.Users
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_item.view.*

class UserAdapter(mContext: Context, mUsers : List<Users>, isChatCheck : Boolean) : RecyclerView.Adapter<ItemViewHolder>() {

    private val mContext : Context = mContext
    private val mUsers : List<Users> = mUsers
    private val isChatCheck : Boolean = isChatCheck

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val view : View = LayoutInflater.from(mContext).inflate(R.layout.search_item, viewGroup, false)
        return ItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindView(mUsers[position])
    }


    override fun getItemCount(): Int {
        return mUsers.size
    }

}
class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    //        var usernameTextView : TextView = itemView.findViewById(R.id.username_search_item)
//        var profileImageView : CircleImageView = itemView.findViewById(R.id.profile_image_search_item)
//        var onlineImageView : CircleImageView = itemView.findViewById(R.id.image_online_search_item)
//        var offlineImageView : CircleImageView = itemView.findViewById(R.id.image_offline_search_item)
//        var lastMessageTextView : TextView = itemView.findViewById(R.id.message_last_search_item)
//
    fun bindView(user : Users){
        itemView.username_search_item.text = user.getUsername()

        Picasso.get().load(user.getProfile())
            .placeholder(R.drawable.profile_image)
            .into(itemView.profile_image_search_item)
    }
}