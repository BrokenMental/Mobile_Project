package com.inhatc.eattoday;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase myDB;
    private Button btnMenu1;
    private Button btnMenu2;
    private Button btnMenu3;
    private Button btnRandom;
    private Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu1 = (Button)findViewById(R.id.btnkorea);
        btnMenu1.setOnClickListener(this);
        btnMenu2 = (Button)findViewById(R.id.btnchina);
        btnMenu2.setOnClickListener(this);
        btnMenu3 = (Button)findViewById(R.id.btnjapan);
        btnMenu3.setOnClickListener(this);
        btnRandom = (Button)findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(this);
        btnList = (Button)findViewById(R.id.btnlist);
        btnList.setOnClickListener(this);

        myDB = this.openOrCreateDatabase("PayInformation", MODE_PRIVATE, null);

        myDB.execSQL("Create table if not exists Paylist (" +
                " _id integer primary key autoincrement, " +
                "Name text not null, " +
                "Phone text not null, " +
                "Total text not null);");

        if(myDB != null) myDB.close();
    }

    public void onClick(View v){
        if(v == btnMenu1){
            Intent korea = new Intent(MainActivity.this, Menu1Activity.class);
            startActivity(korea);
        }else if (v == btnMenu2){
            Intent china = new Intent(MainActivity.this, Menu2Activity.class);
            startActivity(china);
        }else if (v == btnMenu3) {
            Intent japan = new Intent(MainActivity.this, Menu3Activity.class);
            startActivity(japan);
        }else if(v == btnRandom){
            Intent Random = new Intent(MainActivity.this, Menu4Activity.class);
            startActivity(Random);
        }else if (v == btnList){
            Intent list = new Intent(MainActivity.this, ListActivity.class);
            startActivity(list);
        }
    }
}
