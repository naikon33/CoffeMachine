package com.example.coffemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateMachine extends AppCompatActivity {
    private TextView TextViewHello;
    private TextView TextViewAddition;
    private CheckBox TeaSugar;
    private CheckBox TeaMilk;
    private CheckBox TeaLemon;
    private Spinner Spinnertype;
    private Spinner SpinnertypeTea;
    private String drink;
    private String name;
    private String password;
    private StringBuilder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_machine);
        Intent intent=getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("password")) {
            name = intent.getStringExtra("name");
            password = intent.getStringExtra("password");
        }else{
            name=getString(R.string.default_name);
            password=getString(R.string.default_password);
        }

        TextViewHello=findViewById(R.id.TextViewHello);
        TextViewAddition =findViewById(R.id.TextViewAddition);
        TeaSugar=findViewById(R.id.TeaSugar);
        drink=getString(R.string.radiotea);
        TeaMilk=findViewById(R.id.TeaMilk);
        TeaLemon=findViewById(R.id.TeaLemon);
        Spinnertype=findViewById(R.id.Spinnertype);
        SpinnertypeTea=findViewById(R.id.SpinnertypeTea);

        String hello=String.format(getString(R.string.hello), name);
        TextViewHello.setText(hello);
        String additions=String.format(getString(R.string.adding), drink);
        TextViewAddition.setText(additions);
        builder=new StringBuilder();
    }

    public void OnclickRadioDrink(View view) {
        RadioButton button=(RadioButton) view;
        int id=button.getId();
        if (id==R.id.radioTea){
            drink=getString(R.string.radiotea);
            SpinnertypeTea.setVisibility(View.VISIBLE);
            Spinnertype.setVisibility(View.INVISIBLE);
            TeaLemon.setVisibility(View.VISIBLE);
        }else if (id==R.id.radioCoffe){
            drink=getString(R.string.radiocoffee);
            SpinnertypeTea.setVisibility(View.INVISIBLE);
            Spinnertype.setVisibility(View.VISIBLE);
            TeaLemon.setVisibility(View.INVISIBLE);
        }
        String additions=String.format(getString(R.string.adding),drink);
        TextViewAddition.setText(additions);
    }

    public void OClickImage(View view) {
        builder.setLength(0);
        if (TeaSugar.isChecked()){
            builder.append(getString(R.string.sugar)).append(" ");
        }
        if (TeaMilk.isChecked()){
            builder.append(getString(R.string.milk)).append(" ");
        }
        if (TeaLemon.isChecked() && drink.equals(getString(R.string.radiotea))){
            builder.append(getString(R.string.lemon)).append(" ");
        }
        String option="";
        if (drink.equals(getString(R.string.radiotea))){
            option=SpinnertypeTea.getSelectedItem().toString();
        }else{
            option=Spinnertype.getSelectedItem().toString();
        }
        String order=String.format(getString(R.string.order),name,password,drink,option);
        String additionsorder;
        if (builder.length()>0){
            additionsorder="\n"+getString(R.string.order_additions)+builder.toString();
        }else{
            additionsorder="";
        }
        String fullorder=order+additionsorder;
        Intent intent=new Intent(this,DetailOrderActivity.class);
        intent.putExtra("order",fullorder);
        startActivity(intent);
    }
}