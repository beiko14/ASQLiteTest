package com.example.asqlitetest;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonViewAll, buttonAdd;
    private EditText editTextName, editTextAge, editTextSearchField;
    private Switch buttonSwitch;
    private ListView listViewCustomerList;

    private ArrayAdapter adapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViewAll = findViewById(R.id.buttonViewAll);
        buttonAdd = findViewById(R.id.buttonAdd);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextSearchField = findViewById(R.id.editTextSearchField);

        buttonSwitch = findViewById(R.id.buttonSwitch);
        listViewCustomerList = findViewById(R.id.ListViewCustomerList);

        // get the db directly when the app gets started
        showCustomersOnListView();


        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                if(!editTextSearchField.getText().toString().equals("")){
                    List<CustomerModel> tempList = new ArrayList<>();

                    tempList = dataBaseHelper.searchCustomer(editTextSearchField.getText().toString());

                    adapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, tempList);
                    listViewCustomerList.setAdapter(adapter);

                } else{
                    showCustomersOnListView();
                }

            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                try {
                    customerModel = new CustomerModel(-1, editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString()), buttonSwitch.isChecked());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel(-1, "Error", -1, false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(customerModel);

                showCustomersOnListView();

            }
        });


        listViewCustomerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel clickedCustomer = (CustomerModel)parent.getItemAtPosition(position);
                dataBaseHelper.deleteOne(clickedCustomer);
                Toast.makeText(MainActivity.this, clickedCustomer.getName() + " deleted", Toast.LENGTH_SHORT).show();
                showCustomersOnListView();
            }
        });
    }


    private void showCustomersOnListView() {
        dataBaseHelper = new DataBaseHelper(MainActivity.this);

        List<CustomerModel> customerList = new ArrayList<>();
        customerList = dataBaseHelper.getEveryone();

        adapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, customerList);
        listViewCustomerList.setAdapter(adapter);
    }
}




















