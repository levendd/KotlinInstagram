package com.levojuk.kotlininstagram.v.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Timestamp
import com.levojuk.kotlininstagram.databinding.RecyclerRowBinding
import com.levojuk.kotlininstagram.v.model.Post
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Date


class FeedAdapter (private val postList: ArrayList<Post>): RecyclerView.Adapter<FeedAdapter.PostHolder>() {
    class PostHolder(val binding: RecyclerRowBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
       val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.recylerEmailText.text = postList[position].email
        holder.binding.commenttext.text = postList[position].comment
        Picasso.get().load(postList[position].downloadUrl).into(holder.binding.imageView)
        val date = convert(postList[position].timestamp)
        holder.binding.datetext.text = date

    }

    override fun getItemCount(): Int {
        return postList.size
    }

fun convert(date:Timestamp) :String{
    val simpleDate = SimpleDateFormat("dd/M/yyyy")
     val date= simpleDate.format(Date())
    return date;
}
}