package com.example.netbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

public class MyTicket extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }

        String userName=SharedPrefManager.getInstance(this).getUsername();
        getSupportActionBar().setTitle(userName+" Your Ticket");

                listview = (ListView)findViewById(R.id.listView);

        getData();
            }


            private void getData() {

                String userName=SharedPrefManager.getInstance(this).getUsername();



                String url = Constants.ShowTicket_URL + userName;



                StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        showJSON(response);
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MyTicket.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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
                        String ticketNumber = jo.getString(Constants.KEY_TICKETNUMBER);
                        String travelName = jo.getString(Constants.KEY_TRAVELNAME);
                        String busNo = jo.getString(Constants.KEY_BUSNO);
                        String price = jo.getString(Constants.KEY_PRICE);
                        String seatNo = jo.getString(Constants.KEY_SEATNO);
                        String source = jo.getString(Constants.KEY_SOURCE);
                        String destination = jo.getString(Constants.KEY_DESTINATION);
                        String date = jo.getString(Constants.KEY_DATE);
                        String departureTime = jo.getString(Constants.KEY_DEPARTURETIME);



                        final HashMap<String, String> ticket = new HashMap<>();
                        ticket.put(Constants.KEY_TICKETNUMBER,ticketNumber);
                        ticket.put(Constants.KEY_TRAVELNAME,travelName);
                        ticket.put(Constants.KEY_BUSNO, busNo);
                        ticket.put(Constants.KEY_PRICE, price);
                        ticket.put(Constants.KEY_SEATNO, seatNo);
                        ticket.put(Constants.KEY_SOURCE, source);
                        ticket.put(Constants.KEY_DESTINATION, destination);
                        ticket.put(Constants.KEY_DATE, date);
                        ticket.put(Constants.KEY_DEPARTURETIME, departureTime);

                        list.add(ticket);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ListAdapter adapter = new SimpleAdapter(
                        MyTicket.this, list, R.layout.activity_ticket_list,
                        new String[]{Constants.KEY_TICKETNUMBER,Constants.KEY_TRAVELNAME, Constants.KEY_BUSNO, Constants.KEY_PRICE, Constants.KEY_SEATNO,Constants.KEY_SOURCE,Constants.KEY_DESTINATION,Constants.KEY_DATE,Constants.KEY_DEPARTURETIME },
                        new int[]{R.id.tvTicketNo, R.id.tvTravelName, R.id.tvBusNo, R.id.tvPrice,R.id.tvSeatNo,R.id.tvSource,R.id.tvDestination,R.id.tvDate,R.id.tvDepartureTime});

                listview.setAdapter(adapter);
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
                Intent intent3 = new Intent(getApplication(), HomeNav.class);
                startActivity(intent3);
                break;
            case R.id.ticketMenu:

                break;
            case R.id.contactMenu:
                Intent intent2 = new Intent(getApplication(), ContactUs.class);
                startActivity(intent2);

                break;

            case R.id.shareMenu:
                Intent intent4 = new Intent(getApplication(), Share.class);
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
