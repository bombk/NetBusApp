package com.example.netbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MyTicketBook extends AppCompatActivity {

    TextView travelName,busNo,seatNo,price,source,destination,date,departureTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket_book);
        getSupportActionBar().setTitle("Confrom Ticket");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        travelName=(TextView)findViewById(R.id.tvShowTravelName);
        busNo=(TextView)findViewById(R.id.tvShowBusNo);
        seatNo=(TextView)findViewById(R.id.tvShowSeatNo);
        price=(TextView)findViewById(R.id.tvShowPrice);
        source=(TextView)findViewById(R.id.tvShowSource);
        destination=(TextView)findViewById(R.id.tvShowDestination);
        date=(TextView)findViewById(R.id.tvShowDate);
        departureTime=(TextView)findViewById(R.id.tvShowDepartureTime);
        Bundle bn=getIntent().getExtras();
        String travelName1=bn.getString("travelName2");
        travelName.setText(String.valueOf(travelName1));
        String busNo1=bn.getString("busNo2");
        busNo.setText(String.valueOf(busNo1));
        String price1=bn.getString("price2");
        price.setText(String.valueOf(price1));
        String source1=bn.getString("source2");
        source.setText(String.valueOf(source1));
        String destination1=bn.getString("destination2");
        destination.setText(String.valueOf(destination1));
        String seatNo1=bn.getString("seatNo2");
        seatNo.setText(String.valueOf(seatNo1));
        String date1=bn.getString("date2");
        date.setText(String.valueOf(date1));
        String departureTime1=bn.getString("departureTime2");
        departureTime.setText(String.valueOf(departureTime1));

    }
    public void btnConformTicket(View view){
        String s_userName=SharedPrefManager.getInstance(this).getUsername();
        String s_travelName = this.travelName.getText().toString();
        String s_busNo = this.busNo.getText().toString();
        String s_price = this.price.getText().toString();
        String s_seatNo = this.seatNo.getText().toString().trim();
        String s_source = this.source.getText().toString();
        String s_destination = this.destination.getText().toString();
        String s_date=this.date.getText().toString();
        String s_departureTime = this.departureTime.getText().toString();

        String type = "bookTicket";

        AdminBackgroundWorker adminBackgroundWorker = new AdminBackgroundWorker(this);
        adminBackgroundWorker.execute(type,s_userName, s_travelName, s_busNo,s_price, s_seatNo, s_source, s_destination,s_date, s_departureTime);

        Intent intent=new Intent(MyTicketBook.this,MyTicket.class);
        startActivity(intent);
        finish();
    }

}
