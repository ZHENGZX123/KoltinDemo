package koltindem.koltindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import koltindem.koltindemo.App

/**
 * Created by Administrator on 2017/5/26.
 */

open class BaseActivity : AppCompatActivity() {

    var app: App? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = applicationContext as App?
    }
}
