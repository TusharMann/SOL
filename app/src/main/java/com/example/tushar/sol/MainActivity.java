package com.example.tushar.sol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SOL> arrayList;
    SOLAdapter adapter;
    ListView listView;
    String URL="http://10.32.2.52/WebService.asmx/DownloadStudentDocument?tel_no=9599652878&Device_imei_no=868627021248977&Sol_roll_no=04-1-02-000776&download_type=4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.listview);
        arrayList=new ArrayList<SOL>();
        adapter=new SOLAdapter(this,arrayList);

        volley vol=new volley();
        vol.DownloadFeeReceipt();


//        final Call<JsonObject> jsonObjectCall=ApiClient.getInterface().getContacts();
//
//        jsonObjectCall.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                JsonObject jsonObject=(JsonObject)response.body();
//
//                for (int i = 0; i < jsonObject.getData().size(); i++)
//                    arrayList.add(jsonObject.getData().get(i));
//
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"No internet connection ",Toast.LENGTH_LONG).show();
//            }
//        });

         }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class volley{
        public volley() {
        }

        public void DownloadFeeReceipt()
        {
            try
            {

                final RequestQueue requestQueue;
                requestQueue= Volley.newRequestQueue(getApplication());

            //    Global.showProgressBar(Global.context,"Fee Receipt is Downloading", "Processing....");

            String url="http://10.32.2.52/WebService.asmx/DownloadStudentDocument?tel_no=9599652878&Device_imei_no=868627021248977&Sol_roll_no=04-1-02-000776&download_type=4";


                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                        url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());

                        try {


                            //Toast.makeText(this,response.toString(),Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),
                                    response.toString(), Toast.LENGTH_SHORT).show();

                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                        //hidepDialog();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        VolleyLog.d("TAG", "Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
                        // hide the progress dialog

                        //hidepDialog();
                    }
                });

                
                requestQueue.add(jsonObjReq);
            }

            catch (Exception e)
            {
                Log.e( "DownloadFeeReceipt",e.toString() );
            }
        }
        }



}
