package com.example.housinite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class ApartmentsAdapter(var context: Context, var data:ArrayList<UploadApartments>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mAptLocation:TextView
        var mAptBedrooms:TextView
        var mAptFloor:TextView
        var mAptRent:TextView
        var mAptImage:ImageView
        init {
            this.mAptLocation = row?.findViewById(R.id.mAptLocation) as TextView
            this.mAptBedrooms = row?.findViewById(R.id.mAptBedrooms) as TextView
            this.mAptFloor = row?.findViewById(R.id.mAptFloor) as TextView
            this.mAptRent = row?.findViewById(R.id.mAptRent) as TextView
            this.mAptImage = row?.findViewById(R.id.mAptPic) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.apartment_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:UploadApartments = getItem(position) as UploadApartments
        viewHolder.mAptLocation.text = item.location
        viewHolder.mAptBedrooms.text = item.bedrooms
        viewHolder.mAptFloor.text = item.floor
        viewHolder.mAptRent.text = item.rent
        Glide.with(context).load(item.image).into(viewHolder.mAptImage)
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