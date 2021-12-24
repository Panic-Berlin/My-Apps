package com.example.myapps.features.yourapps.presentation.adapter

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapps.R
import com.example.myapps.databinding.ItemAppsBinding

class AppsAdapter(
    private val appList: MutableList<PackageInfo>,
    private val context: Context
) : RecyclerView.Adapter<AppsAdapter.AppsViewHolder>() {

    class AppsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding: ItemAppsBinding by viewBinding(ItemAppsBinding::bind)

        fun bind(app: PackageInfo, context: Context) {
            viewBinding.tvAppName.text = app.applicationInfo.loadLabel(context.packageManager).toString()
            viewBinding.ivAppImage.setImageDrawable(app.applicationInfo.loadIcon(context.packageManager))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        val cellForApps =
            LayoutInflater.from(parent.context).inflate(R.layout.item_apps, parent, false)
        return AppsViewHolder(cellForApps)
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(appList[position], context)
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}
