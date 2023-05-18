package com.example.housinite


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class HousesAdapter(var context: Context, var data:ArrayList<UploadHouses>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mHseLocation:TextView
        var mHseBedrooms:TextView
        var mHseDescription:TextView
        var mHseRent:TextView
        var mHsePic:ImageView
        init {
            this.mHseLocation = row?.findViewById(R.id.mHseLocation) as TextView
            this.mHseBedrooms = row?.findViewById(R.id.mHseBedrooms) as TextView
            this.mHseDescription = row?.findViewById(R.id.mHseDescription) as TextView
            this.mHseRent = row?.findViewById(R.id.mHseRent) as TextView
            this.mHsePic = row?.findViewById(R.id.mHsePic) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.houses_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:UploadHouses = getItem(position) as UploadHouses
        viewHolder.mHseLocation.text = item.location
        viewHolder.mHseBedrooms.text = item.bedrooms
        viewHolder.mHseDescription.text = item.description
        viewHolder.mHseRent.text = item.rent
        Glide.with(context).load(item.image).into(viewHolder.mHsePic)
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}