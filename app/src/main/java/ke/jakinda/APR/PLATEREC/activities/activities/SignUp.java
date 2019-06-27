package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import ke.jakinda.APR.PLATEREC.R;

import ke.jakinda.APR.PLATEREC.activities.models.Admin;

public class SignUp extends AppCompatActivity {

    EditText name, username, paswd, repaswd;

    String strname, strusername, strpaswd, strrepaswd;

    Button btlgin;

    Admin admin;

    Context context = SignUp.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=(EditText)findViewById(R.id.name);

        username=(EditText)findViewById(R.id.username);
        paswd=(EditText)findViewById(R.id.paswd);
        repaswd=(EditText)findViewById(R.id.reppaswd);

        btlgin=(Button)findViewById(R.id.btlgin);

        btlgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strname = name.getText().toString();
                strusername=username.getText().toString();
                strpaswd= paswd.getText().toString();
                strrepaswd=repaswd.getText().toString();

                Validate();

            }
        });

    }
  public void Validate(){

        if(strname.equals("")||strusername.isEmpty()||strpaswd.isEmpty()||strrepaswd.isEmpty()){

            Toast.makeText(SignUp.this, "Field Empty",Toast.LENGTH_LONG).show();

        }else{

            Save();
            Intent x= new Intent(getApplicationContext(), Login.class);
            Toast.makeText(SignUp.this, "Successfuly", Toast.LENGTH_SHORT).show();
             startActivity(x);
        }


  }


  public void Save(){





      com.activeandroid.Configuration dbconfig = new com.activeandroid.Configuration.Builder(context)
              .setDatabaseName("parking.db")
              .addModelClass(Admin.class)
              .create();
      ActiveAndroid.initialize(context);

      admin = new Admin();
      admin.setName(strname);
      admin.setUsername(strusername);
      admin.setPassword(strpaswd);
      admin.setRepassword(strrepaswd);
      admin.save();

  }


}
