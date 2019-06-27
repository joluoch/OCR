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
import ke.jakinda.APR.PLATEREC.activities.models.RegistrationDetails;

/**
 * Created by jakin on 15/03/2018.
 */

public class ReportAdapter  extends ArrayAdapter<RegistrationDetails> {

    public ReportAdapter(Context context, ArrayList<RegistrationDetails> reportses) {
        super(context, 0, reportses);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position


        Configuration dbconfig = new Configuration.Builder(getContext())
                .setDatabaseName("parking.db")
                .addModelClass(RegistrationDetails.class)
                .create();
        ActiveAndroid.initialize(getContext());
        RegistrationDetails user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_reports, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView platee = (TextView) convertView.findViewById(R.id.platee);

        TextView nationalid = (TextView) convertView.findViewById(R.id.nationalid);
        TextView telno = (TextView) convertView.findViewById(R.id.telno);
        TextView carmodel = (TextView) convertView.findViewById(R.id.carmodel);
        TextView parkingtype = (TextView) convertView.findViewById(R.id.parkingtype);


        // Populate the data into the template view using the data object
        name.setText(user.Name);
        platee.setText(user.Number_Plate);

        nationalid.setText(user.National_Id);
        telno.setText(user.Telephone_No);
        carmodel.setText(user.Model);
        parkingtype.setText(user.Name);

        // Return the completed view to render on screen
        return convertView;
    }
}


