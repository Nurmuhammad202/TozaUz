package uz.toza.tozauz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.toza.domain.model.QrInfo
import uz.toza.tozauz.databinding.ItemHisotryLayputBinding

class HistoryAdapter(private val list: ArrayList<QrInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemHisotryLayputBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.binding.apply {
                txtDate.text = list[position].data
                txtPrice.text = list[position].price
                txtTitle.text = list[position].type
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(var binding: ItemHisotryLayputBinding) :
        RecyclerView.ViewHolder(binding.root)
}