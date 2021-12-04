package com.example.netbus;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class HomeNav extends AppCompatActivity {

    Button selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year, month, dayOfMonth;
    Calendar calendar;
    Button searchBus;


    String[] sourceList = {"Kathmandu", "Pokhara","Muglin","Narayanghat", "Baglung", "Beni", "Burtibang", "Ilam", "Jhapa", "Morang",
            "Sunsari", "Butwal", "Kaski", "Nawalparasi", "Biratnagar", "Birjung", "Dharan", "Kailali",
            "Dhangadi"};

    String[] destinationList = {"Kathmandu", "Pokhara","Muglin","Narayanghat", "Baglung", "Beni", "Burtibang", "Ilam", "Jhapa", "Morang",
            "Sunsari", "Butwal", "Kaski", "Nawalparasi", "Chitwan", "Biratnagar", "Birjung", "Dharan", "Kailali",
            "Dhangadi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nav);
        String userName=SharedPrefManager.getInstance(this).getUsername();
        getSupportActionBar().setTitle("Home "+userName);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        searchBus=(Button)findViewById(R.id.btnBookTicket);

        final AutoCompleteTextView autoCompleteTVSource = (AutoCompleteTextView) findViewById(R.id.actSouce);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sourceList);

        autoCompleteTVSource.setThreshold(1);
        autoCompleteTVSource.setAdapter(adapter);


        final AutoCompleteTextView autoCompleteTVDestination = (AutoCompleteTextView) findViewById(R.id.actDestination);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, destinationList);

        autoCompleteTVDestination.setThreshold(1);
        autoCompleteTVDestination.setAdapter(adapter1);

        selectDate = (Button) findViewById(R.id.calendaerImage);
        date = (TextView) findViewById(R.id.tvDate);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(HomeNav.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        searchBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sourceData=autoCompleteTVSource.getText().toString();
                String destinaitonData=autoCompleteTVDestination.getText().toString();
                String dateData=date.getText().toString();
                if(sourceData.isEmpty()){
                    autoCompleteTVSource.setError("Please Enter Source");
                    autoCompleteTVSource.requestFocus();
                }
              else if(destinaitonData.isEmpty()){
                    autoCompleteTVDestination.setError("Please Enter Source");
                    autoCompleteTVDestination.requestFocus();
                }
                else if(sourceData.equals(destinaitonData)){
                    Toast.makeText(HomeNav.this, "Choose right source and destination", Toast.LENGTH_SHORT).show();
                }
              else if(dateData.isEmpty()){
                    Toast.makeText(HomeNav.this, "Please Choose Date", Toast.LENGTH_SHORT).show();
                }

                else {

                Intent intent = new Intent(HomeNav.this, Bus.class);
                intent.putExtra("sourceData1",sourceData);
                intent.putExtra("destinaitonData1",destinaitonData);
                intent.putExtra("dateData1",dateData);
                startActivity(intent);
                }
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeMenu:
                break;
            case R.id.ticketMenu:
                Intent intent2 = new Intent(HomeNav.this, MyTicket.class);
                startActivity(intent2);
                break;
            case R.id.contactMenu:
                Intent intent3 = new Intent(HomeNav.this, ContactUs.class);
                startActivity(intent3);
                break;

            case R.id.shareMenu:
                Intent intent4 = new Intent(HomeNav.this, Share.class);
                startActivity(intent4);
                break;
            case R.id.logOut:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
