package com.example.netbus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteBusDetails extends AppCompatActivity {

    EditText editTextBusNumber;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_bus_details);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        editTextBusNumber=(EditText)findViewById(R.id.etBusNuber);
        btnDelete=(Button)findViewById(R.id.btnDelete);

    }
    public void btnDeleteBus(View view) {


        String s_busNo = this.editTextBusNumber.getText().toString();

        String type = "delete";

        AdminBackgroundWorker adminBackgroundWorker = new AdminBackgroundWorker(this);
        adminBackgroundWorker.execute(type,s_busNo);


    }
}
