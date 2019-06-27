package ke.jakinda.APR.PLATEREC.activities.config;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


import com.activeandroid.ActiveAndroid;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.activities.Login;
import ke.jakinda.APR.PLATEREC.activities.activities.ReportActivity;
import ke.jakinda.APR.PLATEREC.activities.activities.ReportAdapter;
import ke.jakinda.APR.PLATEREC.activities.activities.registration_Form;

/**
 * Created by Geraldiste on 1/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    Button btnScan,btnNewm,btnLogout,btnMember;
    EditText eTxtSBPNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbp);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnScan = (Button) findViewById(R.id.btnScan);


        Intent i = new Intent(getApplicationContext(), OCRActivity.class);
        startActivityForResult(i, 007); // Activity is started with requestCode 007


        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(), OCRActivity.class);
                startActivityForResult(i, 007); // Activity is started with requestCode 007

            }
        });

        btnNewm=(Button) findViewById(R.id.btnNewm);

        btnNewm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(getApplicationContext(),registration_Form.class);
                startActivity(y);
            }
        });

        ActiveAndroid.initialize(this);

        btnLogout=(Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(getApplicationContext(), Login.class);
                startActivity(l);
                finish();



            }

        });
        btnMember=(Button) findViewById(R.id.btnMember);
        btnMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(getApplicationContext(),ReportActivity.class);
                startActivity(u);
            }
        });




    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Check if any data is available
        if(data != null) {
            // check if the request code is same as what is passed  here it is 2
            if (requestCode == 007) {
                String message = data.getStringExtra("SCANNED_DATA");


                //eTxtSBPNumber.setText(phone);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Go back?
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
