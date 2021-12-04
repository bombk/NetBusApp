package com.example.netbus;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminBusDetails extends AppCompatActivity {
ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bus_details);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        listview=(ListView) findViewById(R.id.listView);

        listview = (ListView)findViewById(R.id.listView);

        getData();

    }

    private void getData() {


        String url = Constants.AdminShowBus_URL;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AdminBusDetails.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Constants.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);

                String travelName = jo.getString(Constants.KEY_TRAVELNAME);
                String busNo = jo.getString(Constants.KEY_BUSNO);
                String totalSeat = jo.getString(Constants.KEY_TOTALSEAT);
                String source = jo.getString(Constants.KEY_SOURCE);
                String destination = jo.getString(Constants.KEY_DESTINATION);
                String price = jo.getString(Constants.KEY_PRICE);
                String date = jo.getString(Constants.KEY_DATE);
                String departureTime = jo.getString(Constants.KEY_DEPARTURETIME);



                final HashMap<String, String> ticket = new HashMap<>();
                ticket.put(Constants.KEY_TRAVELNAME,travelName);
                ticket.put(Constants.KEY_BUSNO, busNo);
                ticket.put(Constants.KEY_TOTALSEAT, totalSeat);
                ticket.put(Constants.KEY_SOURCE, source);
                ticket.put(Constants.KEY_DESTINATION, destination);
                ticket.put(Constants.KEY_PRICE, price);
                ticket.put(Constants.KEY_DATE, date);
                ticket.put(Constants.KEY_DEPARTURETIME, departureTime);

                list.add(ticket);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                AdminBusDetails.this, list, R.layout.adminbuslist,
                new String[]{Constants.KEY_TRAVELNAME, Constants.KEY_BUSNO, Constants.KEY_TOTALSEAT,Constants.KEY_SOURCE,Constants.KEY_DESTINATION,Constants.KEY_PRICE,Constants.KEY_DATE,Constants.KEY_DEPARTURETIME },
                new int[]{ R.id.tvTravelName, R.id.tvBusNo, R.id.tvTotalseat,R.id.tvSource,R.id.tvDestination,R.id.tvShowPrice,R.id.tvDate,R.id.tvDepartureTime});

        listview.setAdapter(adapter);
    }
}
