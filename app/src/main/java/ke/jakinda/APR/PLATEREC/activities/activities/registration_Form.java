package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.config.MainActivity;
import ke.jakinda.APR.PLATEREC.activities.models.RegistrationDetails;

import static com.activeandroid.Cache.getContext;

public class registration_Form extends AppCompatActivity {
    EditText Name, National_ID, Telephone_Number, Number_Plate, Model,Date;
    CheckBox Regular,Disable,Motor_bike;
    String strnumberplate,strmodel;
    String strname,strnationalid, strtelephone ,strdate;
     RegistrationDetails regform;
    String strr;
    Button btar;
    Context context = registration_Form.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__form);

        Name=(EditText)findViewById(R.id.editTextName);
        National_ID=(EditText)findViewById(R.id.editText_National_ID);
        Telephone_Number=(EditText)findViewById(R.id.editText_Telephone_Number);
        btar=(Button)findViewById(R.id.btar);
        Number_Plate=(EditText)findViewById(R.id.editNP);
        Model=(EditText)findViewById(R.id.editMD);
        Date=(EditText)findViewById(R.id.editDate);
        Regular=(CheckBox)findViewById(R.id.checkbox_Reg);
        Disable=(CheckBox)findViewById(R.id.checkbox_Dis);
        Motor_bike=(CheckBox)findViewById(R.id.checkbox_Moto);
        context=getContext();

        btar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strname=Name.getText().toString();
                strnationalid=National_ID.getText().toString();
                strtelephone=Telephone_Number.getText().toString();
                strnumberplate = Number_Plate.getText().toString();
                strmodel=Model.getText().toString();
                strdate=Date.getText().toString();


                 strr = "";
                if (Regular.isChecked()) {
                    strr = strr + "," + Regular.getText();
                }
                if (Disable.isChecked()) {
                    strr = strr + "," + Disable.getText();
                }
                if (Motor_bike.isChecked()) {
                    strr = strr + "," + Motor_bike.getText();
                }

                setTitle("Checked: " + strr);




                Validate();

            }
        });

    }
    public void Validate() {

        if (strname.equals("") || strnationalid.isEmpty() || strtelephone.isEmpty() || strnumberplate.isEmpty() || strmodel.isEmpty()) {

            Toast.makeText(registration_Form.this, "Field Empty", Toast.LENGTH_LONG).show();

        } else {



            Save();
        }
    }

    public void Save() {
        Configuration dbconfig = new Configuration.Builder(context)
        .setDatabaseName("parking.db")
                .addModelClass(RegistrationDetails.class)
                .create();
        ActiveAndroid.initialize(context);


        regform = new RegistrationDetails();
        regform.setName(strname);
        regform.setNational_Id(strnationalid);
        regform.setTelephone_No(strtelephone);
        regform.setNumber_Plate(strnumberplate);
        regform.setModel(strmodel);
        regform.setDate(strdate);
        regform.setParking_Type(strr);


        regform.save();

        Intent x = new Intent(getApplicationContext(), MainActivity.class);
        Toast.makeText(registration_Form.this, "Registered Successfuly", Toast.LENGTH_SHORT).show();
        startActivity(x);
        /*
        regform.setNumber_Plate(strnumberplate);
        regform.setModel(strmodel);
        regform.setColour(strcolour);

        */
        /* parkingtype=new Parking_Type();
        regform.setRegular(strregular);
        regform.setDisable(strdisable);
        regform.setMotor_bike(strmotorbike);
        parkingtype.save();*/


    }

}


