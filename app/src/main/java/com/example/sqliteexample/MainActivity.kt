package com.example.sqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        var db = DataBaseHandler(context)

        btn_insert.setOnClickListener{
            if(etName.text.toString().length > 0 && etAge.text.toString().length > 0){
                var user = User(etName.text.toString(),etAge.text.toString().toInt())
                db.insertData(user)
            }
            else{
                Toast.makeText(context,"Please Fill All Data's", Toast.LENGTH_LONG).show()
            }
        }

        btn_read.setOnClickListener{
            var data = db.readData()
            tvResult.text = ""
            for(i in 0..(data.size-1)){
                //tvResult.append(data.get(i).id.toString()+" "+data.get(i).name+" "+data.get(i).age+ "\n")
                tvResult.append(data.get(i).name+" "+data.get(i).age+ "\n")
            }
        }

        btn_update.setOnClickListener{
            db.updateData()
            btn_read.performClick()
        }
        btn_delete.setOnClickListener{
            db.deleteData()
            btn_read.performClick()
        }
    }
}
