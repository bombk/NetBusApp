package com.example.netbus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Seats extends AppCompatActivity implements View.OnClickListener {

    ViewGroup layout;
    TextView totalPriceCalculation;

    String seats = "UU_AA/"
            + "AA_AA/"
            + "AA_AA/"
            + "AA_AA/"
            + "AA_AA/"
            + "AA_AA/"
            + "AA_AA/"
            + "AA_AA/";

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 90;
    int seatGaping = 8;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    String selectedIds = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        getSupportActionBar().setTitle("Seat Details");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }





        layout = findViewById(R.id.layoutSeat);
        totalPriceCalculation=findViewById(R.id.totalPriceCalculation);

        seats = "/" + seats;

        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;

        int count = 0;

        for (int index = 0; index < seats.length(); index++) {
            if (seats.charAt(index) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            } else if (seats.charAt(index) == 'U') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_BOOKED);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'A') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.BLACK);
                view.setTag(STATUS_AVAILABLE);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setText("");
                layout.addView(view);
            }
        }
    }

    @Override
    public void onClick(View view) {

        if ((int) view.getTag() == STATUS_AVAILABLE) {
            if (selectedIds.contains(view.getId() + ",")) {
                selectedIds = selectedIds.replace(+view.getId() + ",", "");
                view.setBackgroundResource(R.drawable.ic_seats_book);
            } else {
                selectedIds = selectedIds + view.getId() + ",";
                view.setBackgroundResource(R.drawable.ic_seats_selected);

                int price1 = Integer.parseInt(getIntent().getStringExtra("price"));

                String s_busNo = getIntent().getStringExtra("busNo");
                String s_seatNo=String.valueOf(selectedIds);

                String type = "checkseat";
                AdminBackgroundWorker adminBackgroundWorker = new AdminBackgroundWorker(this);
                adminBackgroundWorker.execute(type,s_busNo,s_seatNo);



                for (int count=0;count<selectedIds.length();count++) {

                   int c= (count)*price1;
                    totalPriceCalculation.setText(String.valueOf(c));



                }

            }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnBookSeats(View view) {

        String seatNo=String.valueOf(selectedIds);
        String travelName1=getIntent().getStringExtra("travelName");
        String busNo1=getIntent().getStringExtra("busNo");
        String source1=getIntent().getStringExtra("source");
        String destination1=getIntent().getStringExtra("destination");
        String date1=getIntent().getStringExtra("date");String departureTime1=getIntent().getStringExtra("departureTime");


        Intent intent = new Intent(this, MyTicketBook.class);
        intent.putExtra("travelName2",travelName1);
        intent.putExtra("busNo2",busNo1);
        intent.putExtra("price2",totalPriceCalculation.getText().toString());
        intent.putExtra("source2",source1);
        intent.putExtra("destination2",destination1);
        intent.putExtra("date2",date1);
        intent.putExtra("departureTime2",departureTime1);
        intent.putExtra("seatNo2",seatNo);
        startActivity(intent);


    }

}
