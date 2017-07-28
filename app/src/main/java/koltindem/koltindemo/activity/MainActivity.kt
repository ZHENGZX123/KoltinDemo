package koltindem.koltindemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import koltindem.koltindemo.R
import koltindem.koltindemo.utile.ViewUtils
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView1.setOnClickListener(this)
        cancel_button.setOnClickListener(this)
        next_button.setOnClickListener(this)
        recyclerView_button.setOnClickListener(this)
        list_view_button.setOnClickListener(this)
        dialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            next_button -> startActivity(Intent(this, HttpActivity::class.java))
            cancel_button -> {
                textView1.text = "我点了按钮"
                ViewUtils.getMyInfo()
                Toast.makeText(this, textView1.text, Toast.LENGTH_SHORT).show()
            }
            textView1 -> textView1.text = "重新回来了"
            recyclerView_button -> startActivity(Intent(this, RecyclerViewActivity::class.java))
            list_view_button -> startActivity(Intent(this, ListViewActivity::class.java))
            dialog -> startActivity(Intent(this, DialogActivity::class.java))
        }
    }


}
