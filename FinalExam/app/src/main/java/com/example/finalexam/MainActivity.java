package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int dum = 0;
    String LU;
    int available;
    int registered;
    int dummyVal;
    EditText crn;
    EditText luID;
    TextView success1;
    private Gson gson;
    Button checkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    success1 = findViewById(R.id.success);
        checkStatus = findViewById(R.id.checkStatus);
        gson = new Gson();

    }


    public void checkStatus(View view){
        crn = findViewById(R.id.crnID);
        dummyVal =  Integer.parseInt(crn.getText().toString());
        new DoTask().execute();
dum++;
    }






    private class DoTask extends AsyncTask<String, Void, String> {
        private String uri;

        // CHANGE THE VARIABLE QUOTES========================================
        DoTask() {
            uri = "http://" + URIHandler.hostName + "/courses?crn="+dummyVal;
        }

        @Override
        protected String doInBackground(String... urls) {
            return URIHandler.doGet(uri, "");
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Log.d(result, "onPostExecute: ");
            showResult(result);
        }
    }


    private void showResult(String json) {

        Log.d(json, "given json: ");


        Course[] A = gson.fromJson(json, Course[].class);


        List<Course> one = Arrays.asList(A);

        Course optionA = one.get(0);

            available = optionA.getSeats();
            registered = optionA.getEnrolled();
            TextView quoteText = (TextView) this.findViewById(R.id.diaplayMsg);
            quoteText.setText(available+" available/ "+registered+" registered");
          }



    public void register(View view) {

        luID = findViewById(R.id.luID);
        LU = luID.getText().toString();
        if (dum > 0){
            if (available > 0) {
                if (dummyVal != 0) {
                    new RegisterTask().execute();
                } else {
                    success1.setText("Enter valid CRN first");
                }
            } else {

                success1.setText("Class full");

            }
    } else {
            success1.setText("Select CRN first");
        }

    }


    private class RegisterTask extends AsyncTask<String, Void, String> {
        private String uri;

        // CHANGE THE VARIABLE QUOTES========================================
        RegisterTask() {
            uri = "http://" + URIHandler.hostName + "/registrations";
        }

        @Override
        protected String doInBackground(String... urls) {

            return URIHandler.doPost(uri, "{\"crn\":\"" + dummyVal+ "\",\"id\":\"" + LU + "\"}");
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
    success1.setText("Success");
        }
    }
}