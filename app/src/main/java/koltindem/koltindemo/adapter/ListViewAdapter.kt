package koltindem.koltindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import koltindem.koltindemo.R
import koltindem.koltindemo.data.listViewData

/**
 * Created by Administrator on 2017/5/25.
 */
class ListViewAdapter : BaseAdapter {
    var list: ArrayList<listViewData>? = null
    var holer: baseAdatperHoder? = null

    constructor(list: ArrayList<listViewData>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItem(postion: Int): Any {
        return postion
    }

    override fun getItemId(postion: Int): Long {
        return postion.toLong()
    }

    override fun getCount(): Int {
        return list?.size as Int;
    }

    override fun getView(postion: Int, v: View?, vg: ViewGroup?): View {
        var va: View? = v
        if (v == null) {
            va = LayoutInflater.from(vg!!.context).inflate(R.layout.listview_view_item, null)
            holer = baseAdatperHoder()
            holer!!.name = va.findViewById(R.id.title) as TextView
            holer!!.url = va.findViewById(R.id.gallery_pic) as SimpleDraweeView
            va!!.setTag(holer)
        } else {
            holer = va!!.getTag() as baseAdatperHoder
        }
        holer!!.name!!.text = list?.get(postion)?.title
        holer!!.url!!.setImageURI(list?.get(postion)?.url)
        return va!!
    }

    class baseAdatperHoder() {
        var name: TextView? = null
        var url: SimpleDraweeView? = null
    }
}