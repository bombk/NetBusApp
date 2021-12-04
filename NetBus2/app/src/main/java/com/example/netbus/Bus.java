package com.example.netbus;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bus extends AppCompatActivity {
    TextView showDate,showSource,showDestination;


    private static final String BusDetails_URL = "http://192.168.1.66/NetBus/showbus.php?source=";

    RecyclerView recyclerView;
    BusAdapter adapter;
    List<BusDetails> busList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        getSupportActionBar().setTitle("Bus");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        showDate=(TextView)findViewById(R.id.tvShowDate);
        showSource=(TextView)findViewById(R.id.tvSourcePalace);
        showDestination=(TextView)findViewById(R.id.tvDestinaionPalace);
        Bundle bn=getIntent().getExtras();
        String date=bn.getString("dateData1");
        showDate.setText(String.valueOf(date));


        String sData=bn.getString("sourceData1");
        showSource.setText(String.valueOf(sData));
        String dData=bn.getString("destinaitonData1");
        showDestination.setText(String.valueOf(dData));

        busList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadBusDetails();


    }

    private void loadBusDetails() {
        String source1=showSource.getText().toString();
       String destination1=showDestination.getText().toString();
        String Bus_url=BusDetails_URL+source1+"&destination="+destination1;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Bus_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray busDetails = new JSONArray(response);

                            for (int i = 0; i < busDetails.length(); i++) {

                                JSONObject busDetailsObj = busDetails.getJSONObject(i);

                                String travelName = busDetailsObj.getString("travelName");
                                String source=busDetailsObj.getString("source");
                                String destination=busDetailsObj.getString("destination");
                                int busNo = busDetailsObj.getInt("busNo");
                                int totalSeat = busDetailsObj.getInt("totalSeat");
                                int price = busDetailsObj.getInt("price");
                                String date=busDetailsObj.getString("date");
                                String departureTime = busDetailsObj.getString("departureTime");

                                BusDetails busDetailslist = new BusDetails(travelName,source,destination, busNo, totalSeat, price,date, departureTime);
                                busList.add(busDetailslist);

                            }
                            adapter = new BusAdapter(Bus.this, busList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Bus.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }


}
