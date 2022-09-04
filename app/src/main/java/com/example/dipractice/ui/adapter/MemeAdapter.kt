package com.example.dipractice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dipractice.databinding.MemeLayoutBinding
import com.example.dipractice.domain.model.MemeModel
import com.example.dipractice.extensions.setImage

class MemeAdapter:ListAdapter<MemeModel.Data.Meme,MemeAdapter.ViewHolder>(DiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MemeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<MemeModel.Data.Meme>() {
        override fun areItemsTheSame(oldItem: MemeModel.Data.Meme, newItem: MemeModel.Data.Meme): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MemeModel.Data.Meme, newItem: MemeModel.Data.Meme): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: MemeLayoutBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var currentMeme: MemeModel.Data.Meme

        fun bind(){
            currentMeme = getItem(adapterPosition)

            binding.apply {
                imageView.setImage(currentMeme.url!!)
                imageView.layoutParams.width = currentMeme.width!!
                imageView.layoutParams.height = currentMeme.height!!
                textView.text = currentMeme.name
            }
        }

    }

}


