package com.example.coffemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailOrderActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        if (intent.hasExtra("order")){
            String ordertext=intent.getStringExtra("order");
            textView.setText(ordertext);
        }else{
            Intent back=new Intent(this,LoginActivity.class);
            startActivity(back);
        }
    }
}