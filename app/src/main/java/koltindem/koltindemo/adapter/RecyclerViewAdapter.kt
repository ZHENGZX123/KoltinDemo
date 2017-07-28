package koltindem.koltindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import koltindem.koltindemo.R
import koltindem.koltindemo.data.recyeviewData

/**
 * Created by Administrator on 2017/6/5.
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolde>, View.OnClickListener {


    public var list: ArrayList<recyeviewData>? = null

    constructor(list: ArrayList<recyeviewData>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list?.size as Int
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolde {
        return MyViewHolde(LayoutInflater.from(
                parent!!.context).inflate(R.layout.recycler_view_item, parent,
                false))
    }

    override fun onBindViewHolder(holder: MyViewHolde?, position: Int) {
        holder!!.name!!.text = list?.get(position)?.title
        holder!!.image!!.setImageURI(list?.get(position)?.url)
        holder.name.setOnClickListener(this)
        holder.name.setTag(R.id.bundle_params1, position)
        holder.image.setOnClickListener(this)
        holder.image.setTag(R.id.bundle_params1, position)
    }

    class MyViewHolde : RecyclerView.ViewHolder {
        constructor(view: View) : super(view) {
            name = view.findViewById(R.id.title) as TextView
            image = view.findViewById(R.id.gallery_pic) as SimpleDraweeView
        }

        var name: TextView
        var image: SimpleDraweeView
    }

    override fun onClick(v: View?) {
        var position = Integer.parseInt(v!!.getTag(R.id.bundle_params1).toString())
        if (list!!.get(position).title.equals("罗"))
            list?.set(position, list!!.get(position).copy(title = "索隆", url = "http://img5.imgtn.bdimg.com/it/u=2299609415,2213226454&fm=11&gp=0.jpg"))
        else
            list?.set(position, list!!.get(position).copy(title = "罗", url = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4259568960,4497078&fm=26&gp=0.jpg"))
        notifyDataSetChanged()
    }
}