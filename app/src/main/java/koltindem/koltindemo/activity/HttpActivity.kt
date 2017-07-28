package koltindem.koltindemo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import koltindem.koltindemo.IContants
import koltindem.koltindemo.R
import koltindem.koltindemo.utile.MessageWhat.handerMessage
import kotlinx.android.synthetic.main.activity_http.*
import okhttp3.Request

class HttpActivity : BaseActivity(), okhttp3.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)
        val call = app!!.httpClient.newCall(Request.Builder()
                .url(IContants.isCon)
                .build())
        call.enqueue(this)
    }

    override fun onResponse(call: okhttp3.Call?, response: okhttp3.Response?) {
        when (call?.request()?.url().toString().substringBeforeLast("/")) {
            IContants.isCon -> {
                var message: Message = Message()
                message.what = handerMessage
                message.obj = "我请求了" + IContants.isCon + "得到\n" + response!!.body().string()
                hander.sendMessage(message)
            }
        }
    }

    override fun onFailure(call: okhttp3.Call?, e: java.io.IOException?) {
    }

    internal var hander: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg!!.what) {
                handerMessage -> httptext.text = msg.obj.toString()
            }
        }
    }
}
