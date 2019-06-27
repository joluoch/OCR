package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import java.util.ArrayList;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.models.Events;

/**
 * Created by jakin on 21/03/2018.
 */

public class LogsAdapter extends ArrayAdapter<Events> {
    public LogsAdapter(Context context, ArrayList<Events> reportses) {
        super(context, 0, reportses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position


        Configuration dbconfig = new Configuration.Builder(getContext())
                .setDatabaseName("parking.db")
                .addModelClass(Events.class)
                .create();
        ActiveAndroid.initialize(getContext());
        Events user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.logs, parent, false);
        }
        // Lookup view for data population

        TextView plateee = (TextView) convertView.findViewById(R.id.plateee);

        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView time = (TextView) convertView.findViewById(R.id.time);


        // Populate the data into the template view using the data object

        plateee.setText(user.Number_Plate);

        //date.setText(user.Date);
        time.setText(user.Arrival_Time);

        // Return the completed view to render on screen
        return convertView;
    }
}
