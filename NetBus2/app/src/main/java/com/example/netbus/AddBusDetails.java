package com.example.netbus;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddBusDetails extends AppCompatActivity {

    Button selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year, month, dayOfMonth;
    Calendar calendar;

    EditText travelName,busNo,totalSeat,source,destination,price,departureTime;
    Button addBusDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus_details);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        travelName=(EditText) findViewById(R.id.etTravelName);
        busNo=(EditText) findViewById(R.id.etBusNo);
        totalSeat=(EditText) findViewById(R.id.etTotalSeat);
        source=(EditText) findViewById(R.id.etSource);
        destination=(EditText) findViewById(R.id.etDestination);
        price=(EditText) findViewById(R.id.etPrice);
        selectDate=(Button)findViewById(R.id.btnChoseDate);
        departureTime=(EditText) findViewById(R.id.etDepartureTime);
        addBusDetails=(Button)findViewById(R.id.btnAddbus);
        selectDate = (Button) findViewById(R.id.btnChoseDate);

        date=(TextView) findViewById(R.id.tvDateText);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddBusDetails.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });


    }

    public void btnAddNewBus(View view) {
        String c_travelName = travelName.getText().toString();
        String c_busNo = busNo.getText().toString();
        String c_totalSeat = totalSeat.getText().toString();
        String c_source = source.getText().toString();
        String c_destination = destination.getText().toString();
        String c_price = price.getText().toString();
        String c_date = date.getText().toString();
        String c_departureTime = departureTime.getText().toString();
        if (view == addBusDetails)
            if (c_travelName.isEmpty()) {
                travelName.setError("Please Enter Travel Name");
                travelName.requestFocus();

            } else if (c_busNo.isEmpty()) {
                busNo.setError("Please Enter Bus Number");
                busNo.requestFocus();
            } else if (c_totalSeat.isEmpty()) {
                totalSeat.setError("Please Enter Total Seat");
                totalSeat.requestFocus();
            } else if (c_source.isEmpty()) {
                source.setError("Please Enter Source Palace");
                source.requestFocus();
            }
     else if (c_destination.isEmpty()) {
        destination.setError("Please Enter Destination Palace");
        destination.requestFocus();

} else if (c_price.isEmpty()) {
        price.setError("Please Enter travelling price");
        price.requestFocus();

        } else if (c_date.isEmpty()) {
                Toast.makeText(this, "Please choose date", Toast.LENGTH_SHORT).show();
        }
        else if (c_departureTime.isEmpty()) {
        departureTime.setError("Please Enter Departure time");
        departureTime.requestFocus();
        }
else {
        String s_travelName = this.travelName.getText().toString();
        String s_busNo = this.busNo.getText().toString();
        String s_totalSeat = this.totalSeat.getText().toString();
        String s_source = this.source.getText().toString();
        String s_destination = this.destination.getText().toString();
        String s_price = this.price.getText().toString();
        String s_date = this.date.getText().toString();
        String s_departureTime = this.departureTime.getText().toString();

        String type = "addBus";

        AdminBackgroundWorker adminBackgroundWorker = new AdminBackgroundWorker(this);
        adminBackgroundWorker.execute(type, s_travelName, s_busNo, s_totalSeat, s_source, s_destination, s_price, s_date, s_departureTime);


    }
    }
}
