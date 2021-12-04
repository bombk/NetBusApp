package com.example.netbus;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AdminBackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;

    AdminBackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];

        String addBus_url = "http://192.168.1.66/NetBus/addBusDetails.php";
        String ticketBook_url = "http://192.168.1.66/NetBus/ticket.php";
        String deleteBus_url = "http://192.168.1.86/NetBus/deleteBus.php";
        String deleteTicket_url = "http://192.168.1.66/NetBus/deleteTicket.php";
        String checkseat_url = "http://192.168.1.66/NetBus/checkseat.php";

        if (type.equals("addBus")) {

            try {

                String bs_travelName = params[1];
                String bs_busNo = params[2];
                String bs_totalSeat = params[3];
                String bs_source = params[4];
                String bs_destinaion = params[5];
                String bs_price = params[6];
                String bs_date = params[7];
                String bs_departureTime = params[8];


                URL url = new URL(addBus_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("travelName", "UTF-8")+"="+URLEncoder.encode(bs_travelName, "UTF-8")+"&"+URLEncoder.encode("busNo", "UTF-8")+"="+URLEncoder.encode(bs_busNo, "UTF-8")+"&"+URLEncoder.encode("totalSeat", "UTF-8")+"="+URLEncoder.encode(bs_totalSeat, "UTF-8")+"&"+URLEncoder.encode("source", "UTF-8")+"="+URLEncoder.encode(bs_source, "UTF-8")+"&"+URLEncoder.encode("destination", "UTF-8")+"="+URLEncoder.encode(bs_destinaion, "UTF-8")+"&"+URLEncoder.encode("price", "UTF-8")+"="+URLEncoder.encode(bs_price, "UTF-8")+"&"+URLEncoder.encode("date", "UTF-8")+"="+URLEncoder.encode(bs_date, "UTF-8")+"&"+URLEncoder.encode("departureTime", "UTF-8")+"="+URLEncoder.encode(bs_departureTime, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("delete")) {
            try {

                String bs_busNo = params[1];

                URL url = new URL(deleteBus_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("busNo", "UTF-8")+"="+URLEncoder.encode(bs_busNo, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (type.equals("bookTicket")) {

            try {
                String bs_userName=params[1];

                String bs_travelName = params[2];
                String bs_busNo = params[3];
                String bs_price = params[4];
                String bs_seatNo = params[5];
                String bs_source = params[6];
                String bs_destination = params[7];
                String bs_date = params[8];
                String bs_departureTime = params[9];



                URL url = new URL(ticketBook_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("userName", "UTF-8")+"="+URLEncoder.encode(bs_userName, "UTF-8")+"&"+URLEncoder.encode("travelName", "UTF-8")+"="+URLEncoder.encode(bs_travelName, "UTF-8")+"&"+URLEncoder.encode("busNo", "UTF-8")+"="+URLEncoder.encode(bs_busNo, "UTF-8")+"&"+URLEncoder.encode("price", "UTF-8")+"="+URLEncoder.encode(bs_price, "UTF-8")+"&"+URLEncoder.encode("seatNo", "UTF-8")+"="+URLEncoder.encode(bs_seatNo, "UTF-8")+"&"+URLEncoder.encode("source", "UTF-8")+"="+URLEncoder.encode(bs_source, "UTF-8")+"&"+URLEncoder.encode("destination", "UTF-8")+"="+URLEncoder.encode(bs_destination, "UTF-8")+"&"+URLEncoder.encode("date", "UTF-8")+"="+URLEncoder.encode(bs_date, "UTF-8")+"&"+URLEncoder.encode("departureTime", "UTF-8")+"="+URLEncoder.encode(bs_departureTime, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (type.equals("deleteTicket")) {
            try {

                String bs_busNo = params[1];

                URL url = new URL(deleteTicket_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("busNo", "UTF-8")+"="+URLEncoder.encode(bs_busNo, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (type.equals("checkseat")) {

            try {
                String bs_busNo=params[1];
                String bs_seatNo = params[2];

                URL url = new URL(checkseat_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("busNo", "UTF-8")+"="+URLEncoder.encode(bs_busNo, "UTF-8")+"&"+URLEncoder.encode("seatNo", "UTF-8")+"="+URLEncoder.encode(bs_seatNo, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;


    }

    @Override
    protected void onPreExecute() {


    }


    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
