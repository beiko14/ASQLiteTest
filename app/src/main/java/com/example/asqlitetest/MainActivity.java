package com.example.asqlitetest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonViewAll, buttonAdd;
    private EditText editTextName, editTextAge;
    private Switch buttonSwitch;
    private ListView ListViewCustomerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViewAll = findViewById(R.id.buttonViewAll);
        buttonAdd = findViewById(R.id.buttonAdd);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);

        buttonSwitch = findViewById(R.id.buttonSwitch);
        ListViewCustomerList = findViewById(R.id.ListViewCustomerList);


        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    CustomerModel customerModel = new CustomerModel(-1, editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString()), buttonSwitch.isChecked());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}




















