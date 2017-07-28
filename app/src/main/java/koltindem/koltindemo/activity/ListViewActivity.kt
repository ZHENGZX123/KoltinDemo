package koltindem.koltindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import koltindem.koltindemo.R
import koltindem.koltindemo.adapter.ListViewAdapter
import koltindem.koltindemo.data.listViewData
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    var adapter: ListViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        adapter = ListViewAdapter(getListData()!!)
        list_item.adapter = adapter
    }

    private fun getListData(): ArrayList<listViewData>? {
        var list = ArrayList<listViewData>()
        for (i in 0..50) {
            list.add(listViewData(i, "海贼王", "http://img4.imgtn.bdimg.com/it/u=672862869,3904324775&fm=26&gp=0.jpg"))
        }
        return list
    }
}
