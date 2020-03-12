package com.peterkrauz.home.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.peterkrauz.home.R
import com.peterkrauz.home.model.RpgView
import kotlinx.android.synthetic.main.item_rpg.view.*
import kotlinx.android.synthetic.main.item_welcome_header.view.*

sealed class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view)

class RpgViewHolder(view: View) : HomeViewHolder(view) {

    fun bind(item: RpgItem, onItemClick: (RpgView) -> Unit) = with(itemView) {
        item.rpg.run {
            textViewRpgTitle.text = title
            textViewRpgDescription.text = description
            itemBackground.setOnClickListener {
                onItemClick(item.rpg)
            }
        }
    }
}

class WelcomeHeaderViewHolder(view: View) : HomeViewHolder(view) {

    fun bind(playerName: String) = with(itemView) {
        textViewWelcomeHeader.text = context.getString(R.string.welcome_player, playerName)
    }
}
