package com.ok.ifan.sample_intent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var btnSub1: Button? = null
    private var btnSub2: Button? = null
    private var btnDial: Button? = null
    private var strIntent: String? = null
    private var txtIntent: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setTitle("Belajar Intent")

        btnSub1 = findViewById(R.id.btn_activity_sub_1) as Button
        btnSub2 = findViewById(R.id.btn_activity_sub_2) as Button
        btnDial = findViewById(R.id.btn_activity_dial) as Button

        txtIntent = findViewById(R.id.text_Intent) as EditText

        btnSub1!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Sub1Activity::class.java)
            startActivity(intent)
        }

        btnSub2!!.setOnClickListener {
            strIntent = txtIntent!!.text.toString()
            val intent = Intent(this@MainActivity, Sub2Activity::class.java)
            intent.putExtra(Sub2Activity.KEY_DATA, strIntent)
            startActivityForResult(intent, 0)
        }

        btnDial!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:085360021028"))
            startActivity(intent)
        }
    }
}
