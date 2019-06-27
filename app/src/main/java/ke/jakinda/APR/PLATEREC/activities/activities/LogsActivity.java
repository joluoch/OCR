package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Adapter;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.models.Events;


/**
 * Created by jakin on 21/03/2018.
 */

public class LogsActivity extends AppCompatActivity {

    Context context = LogsActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView();


        setContentView(R.layout.log);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Configuration dbconfig = new Configuration.Builder(context)
                .setDatabaseName("parking.db")
                .addModelClass(Events.class)
                .create();
        ActiveAndroid.initialize(context);


        ArrayList<Events> arrayOfUsers = new ArrayList<Events>();
// Create the adapter to convert the array to views
        LogsAdapter adapter = new LogsAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView




        List<Events> queryResults = new Select().from(Events.class)
                // .where("service_category_id=?", 3)
                .orderBy("Date ASC").limit(100).execute();
        adapter.addAll(queryResults);

        ListView listView = (ListView) findViewById(R.id.item);
        // Assign adapter to ListView
        listView.setAdapter(adapter);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
    }

}
