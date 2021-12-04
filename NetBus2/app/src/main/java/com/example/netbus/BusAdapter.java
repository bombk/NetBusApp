package com.example.netbus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.BusViewHolder> {

    private Context mCtx;
    private List<BusDetails> busList;

    public BusAdapter(Context mCtx, List<BusDetails> busList) {
        this.mCtx = mCtx;
        this.busList = busList;
    }

    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.layout,null);

        return new BusViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final BusViewHolder holder, int position) {

        final BusDetails busDetails=busList.get(position);
        holder.travelName.setText(busDetails.getTravelName());
        holder.busNo.setText(String.valueOf(busDetails.getBusNo()));
        holder.totalSeat.setText(String.valueOf(busDetails.getTotalSeat()));
        holder.price.setText(String.valueOf(busDetails.getPrice()));
        holder.source.setText(busDetails.getSource());
        holder.destination.setText(busDetails.getDestination());
        holder.date.setText(busDetails.getDate());
        holder.departureTime.setText(busDetails.getDepartureTime());
        holder.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mCtx,Seats.class);
                intent.putExtra("travelName",busDetails.getTravelName());
                intent.putExtra("busNo",String.valueOf(busDetails.getBusNo()));
                intent.putExtra("price",String.valueOf(busDetails.getPrice()));
                intent.putExtra("source",busDetails.getSource());
                intent.putExtra("destination",busDetails.getDestination());
                intent.putExtra("date",busDetails.getDate());
                intent.putExtra("departureTime",busDetails.getDepartureTime());
               mCtx.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return busList.size();
    }

    class BusViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        RecyclerView recyclerView;

        TextView travelName,busNo,price,totalSeat,source,destination,date,departureTime;
        Button btnBook;


        public BusViewHolder(@NonNull View itemView) {
            super(itemView);


            travelName=itemView.findViewById(R.id.tvDbTravelName);
            busNo=itemView.findViewById(R.id.tvDbBusNo);
            totalSeat=itemView.findViewById(R.id.tvDbTotalSeat);
            price=itemView.findViewById(R.id.tvDbPrice);
            source=itemView.findViewById(R.id.tvDBSource);
            destination=itemView.findViewById(R.id.tvDBDestination);
            date=itemView.findViewById(R.id.tvDBDate);
            departureTime=itemView.findViewById(R.id.tvDbDepartureTime);
            recyclerView=itemView.findViewById(R.id.recycleView);
            btnBook=itemView.findViewById(R.id.btnBook);


        }
    }


}
