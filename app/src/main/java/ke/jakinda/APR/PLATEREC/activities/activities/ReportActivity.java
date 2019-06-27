package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.models.RegistrationDetails;

/**
 * Created by jakin on 15/03/2018.
 */

public class ReportActivity extends AppCompatActivity {

    Context context = ReportActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView();


        setContentView(R.layout.report);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Configuration dbconfig = new Configuration.Builder(context)
                .setDatabaseName("parking.db")
                .addModelClass(RegistrationDetails.class)
                .create();
        ActiveAndroid.initialize(context);


        ArrayList<RegistrationDetails> arrayOfUsers = new ArrayList<RegistrationDetails>();
// Create the adapter to convert the array to views
        ReportAdapter adapter = new ReportAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView




        List<RegistrationDetails> queryResults = new Select().from(RegistrationDetails.class)
                // .where("service_category_id=?", 3)
                .orderBy("date ASC").limit(100).execute();
        adapter.addAll(queryResults);

        ListView listView = (ListView) findViewById(R.id.items);
        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }
}


