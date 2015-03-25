package com.mygola.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    public static final String U_URL = "http://jsonplaceholder.typicode.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(U_URL)
                .build();

        JsonPlaceHolder jsonPlaceHolder = restAdapter.create(JsonPlaceHolder.class);
        final List<String> lst = new ArrayList<>();
        jsonPlaceHolder.getUsers(new Callback<List<Users>>() {
            @Override
            public void success(List<Users> users, Response response) {
                Log.e("LIST COUNT IS", String.valueOf(users.size()));
                for (int i=0;i<users.size();i++) {
                    lst.add(users.get(i).getName());
                    Log.e("NAME iS ", users.get(i).getName());
                    Log.e("USER NAME iS ", users.get(i).getUsername());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,lst);
                ListView listView = (ListView) findViewById(R.id.listContainer);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR IS",error.toString());
            }
        });

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
}
