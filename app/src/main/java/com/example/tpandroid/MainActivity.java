package com.example.tpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String HTTP_URL = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //test volley connection
        VolleySingleton.getInstance(this).addToRequestQueue(
                new JsonObjectRequest(Request.Method.GET, HTTP_URL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("MainActivity", "onResponse() called with: response = [" + response + "]");
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("MainActivity", "onErrorResponse() called with: error = [" + error + "]");
                            }
                        }
                )
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void onRegisterClick(View view) {
        Log.d(TAG, "onRegisterClick() called");
        Toast.makeText(this, "Register Clicked", Toast.LENGTH_SHORT).show();
    }
}