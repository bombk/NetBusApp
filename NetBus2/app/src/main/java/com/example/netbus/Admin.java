package com.example.netbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    Button addBusDetails,showBusDetails,showTicketDetails,deleteTicket,DeleteBusDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Admin");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        addBusDetails=(Button)findViewById(R.id.btnAddBusDetails1);
        showBusDetails=(Button)findViewById(R.id.btnShowBusDetials);
        showTicketDetails=(Button)findViewById(R.id.btnShowTicketDetails);
        deleteTicket=(Button)findViewById(R.id.btnDeleteTicket);
        DeleteBusDetails=(Button)findViewById(R.id.btnDeleteBusDetails1);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeMenu:
                Intent intent1=new Intent(Admin.this,HomeNav.class);
                startActivity(intent1);
                break;
            case R.id.ticketMenu:
                Intent intent2=new Intent(Admin.this,MyTicket.class);
                startActivity(intent2);
                break;
            case R.id.contactMenu:
                Intent intent3=new Intent(Admin.this,ContactUs.class);
                startActivity(intent3);
                break;

            case R.id.shareMenu:
                Intent intent4=new Intent(Admin.this,Share.class);
                startActivity(intent4);
                break;
            case R.id.logOut:
                Intent intent5=new Intent(Admin.this,MainActivity.class);
                startActivity(intent5);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnAddBusDetails(View view){

        Intent intent=new Intent(Admin.this,AddBusDetails.class);
        startActivity(intent);
    }
    public void btnDeleteTicket(View viev){

        Intent intent1=new Intent(Admin.this,UpdateBusDetails.class);
        startActivity(intent1);
    }

    public void btnShowBusDetails(View view){
        Intent intent4=new Intent(Admin.this,AdminBusDetails.class);
        startActivity(intent4);
    }
    public void showTicketDetails(View viev){

        Intent intent3=new Intent(Admin.this,AdminShowTicketDetails.class);
        startActivity(intent3);
    }
    public void btnDeleteBusDetails(View view){

        Intent intent2=new Intent(Admin.this,DeleteBusDetails.class);
        startActivity(intent2);
    }


}
