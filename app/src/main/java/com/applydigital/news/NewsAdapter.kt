package com.applydigital.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.applydigital.core.common.Utils
import com.applydigital.domain.model.Hit
import com.applydigital.news.databinding.LayoutItemBinding
import java.time.Duration
import java.time.LocalDateTime
import kotlin.collections.ArrayList

class NewsAdapter(
    private val list: ArrayList<Hit>,
    private val actionClickDetail: (hit: Hit) -> Unit,
    private val actionDeleteNews: (hit: Hit) -> Unit
) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.txtTitle.text = this.storyTitle
                binding.newContainer.setOnClickListener {
                    actionClickDetail.invoke(this)
                }
                binding.ivDeleteNews.setOnClickListener {
                    actionDeleteNews.invoke(this)
                    list.remove(this)
                    notifyDataSetChanged()
                }
                binding.txtSubTitle.text = "${this.author} - ${calculateMinHr(this.createdAt)}"
            }
        }
    }

    private fun calculateMinHr(time: String): String {
        val timelinePoint = LocalDateTime.parse(Utils.transformUtcToLocal(time)?.replace("0Z", ""))
        val now = LocalDateTime.now()

        val elapsedTime = Duration.between(timelinePoint, now)
        return when {
            elapsedTime.toHours() in 1..24 -> {
                elapsedTime.toHours().toString() + "h"
            }
            elapsedTime.toMinutes() in 1..59 -> {
                elapsedTime.toMinutes().toString() + "m"
            }
            else -> {
                "reciente"
            }
        }
    }

    inner class MyViewHolder(val binding: LayoutItemBinding) : ViewHolder(binding.root)

}