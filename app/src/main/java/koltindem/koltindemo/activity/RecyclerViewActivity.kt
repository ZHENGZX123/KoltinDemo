package koltindem.koltindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import koltindem.koltindemo.R
import koltindem.koltindemo.adapter.RecyclerViewAdapter
import koltindem.koltindemo.data.recyeviewData
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        adapter = RecyclerViewAdapter(initData()!!)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }


    private fun initData(): ArrayList<recyeviewData>? {
        var list = ArrayList<recyeviewData>()
        for (i in 0..50) {
            list.add(recyeviewData(i, "罗", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4259568960,4497078&fm=26&gp=0.jpg"))
        }
        return list
    }
}
