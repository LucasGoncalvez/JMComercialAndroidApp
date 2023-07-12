package com.example.jmcomercialapp.a_ui.menu.principal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jmcomercialapp.c_data.menu.clases.MenuPrincipalItem
import com.example.jmcomercialapp.databinding.LayoutItemMenuPrincipalBinding

class MenuPrincipalAdapter:
    ListAdapter<MenuPrincipalItem, MenuPrincipalAdapter.MenuPrincipalViewHolder>(DiffCallback) {

    inner class MenuPrincipalViewHolder(private val binding: LayoutItemMenuPrincipalBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuPrincipalItem){
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuPrincipalAdapter.MenuPrincipalViewHolder {
        return MenuPrincipalViewHolder(
            LayoutItemMenuPrincipalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: MenuPrincipalAdapter.MenuPrincipalViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.bind(item)
    }

    object DiffCallback: DiffUtil.ItemCallback<MenuPrincipalItem>() {
        override fun areItemsTheSame(
            oldItem: MenuPrincipalItem,
            newItem: MenuPrincipalItem
        ): Boolean {
            return oldItem.denominacion == newItem.denominacion
        }

        override fun areContentsTheSame(
            oldItem: MenuPrincipalItem,
            newItem: MenuPrincipalItem
        ): Boolean {
            return oldItem.denominacion == newItem.denominacion
                    && oldItem.imageId == newItem.imageId
        }

    }
}