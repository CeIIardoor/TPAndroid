package com.example.tpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String HTTP_URL = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998";

    private static final String HTTP_URL_NOTES = "https://belatar.name/rest/profile.php?login=test&passwd=test&id=9998&notes=true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getResources().getConfiguration().orientation == 2) {
            Toast.makeText(this, "horizental", Toast.LENGTH_SHORT).show();

            JsonObjectRequest req_notes = new JsonObjectRequest(Request.Method.GET, HTTP_URL_NOTES, null,
                    response -> {
                        Log.d("MainActivity", "onResponse() called with: response = [" + response + "]");
                        ListView list = findViewById(R.id.listeNotes);
                        List<String> data = new ArrayList<>();
                        try {
                            JSONArray notesArray = response.getJSONArray("notes");
                            for (int i = 0; i < notesArray.length(); i++) {
                                JSONObject note = notesArray.getJSONObject(i);
                                String matiere = note.getString("matiere");
                                String score = note.getString("score");
                                data.add(matiere + " : " + score);
                            }
                        } catch (Exception e) {
                            Log.d("MainActivity", "onResponse() called with: response = [" + response + "]");
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(list.getContext(), R.layout.notes_line, data);
                        list.setAdapter(adapter);
                    },
                    error -> Log.d("MainActivity", "onErrorResponse() called with: error = [" + error + "]")
            );
            VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(req_notes);

        } else {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_URL, null,
                    response -> Log.d("MainActivity", "onResponse() called with: response = [" + response + "]"),
                    error -> Log.d("MainActivity", "onErrorResponse() called with: error = [" + error + "]")
            );
            VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
        }
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
//        Etudiant etudiant = new Etudiant(findViewById(R.id.EditNom).getId(), findViewById(R.id.EditPrenom).toString(), findViewById(R.id.EditClasse).toString());
//        EditText txtNom = findViewById(R.id.EditNom);
        Toast.makeText(this, "Register Clicked", Toast.LENGTH_SHORT).show();
    }

}