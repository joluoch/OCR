package ke.jakinda.APR.PLATEREC.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import ke.jakinda.APR.PLATEREC.R;
import ke.jakinda.APR.PLATEREC.activities.config.MainActivity;
import ke.jakinda.APR.PLATEREC.activities.models.Admin;

/**
 * Created by jakin on 08/03/2018.
 */

public class Login  extends AppCompatActivity {

    Button buttonclick , btlgin;
    EditText username, password;
    String str_username, str_password;

    Context context = Login.this;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

             buttonclick = (Button)findViewById(R.id.btnlogin);
            btlgin = (Button)findViewById(R.id.btlgin);
            username=(EditText)findViewById(R.id.usernamess);
            password=(EditText)findViewById(R.id.passwordss);


            buttonclick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    str_username =username.getText().toString();
                    str_password=password.getText().toString();

                    Configuration dbconfig = new Configuration.Builder(context)
                            .setDatabaseName("parking.db")
                            .addModelClass(Admin.class)
                            .create();
                    ActiveAndroid.initialize(context);
                    Admin admins;
                    admins= new Admin();



                   Admin admin =  admins.getUser( str_username,  str_password);

                   // Toast.makeText(Login.this, "result"+admin.getUsername().toString(), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(Login.this, "result"+admin.getName().toString(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Login.this, "result"+admin.getPassword().toString(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Login.this, "result"+admin.getRepassword().toString(), Toast.LENGTH_SHORT).show();

if(admin==null){

    Toast.makeText(Login.this, "The user does not exist", Toast.LENGTH_SHORT).show();
}else {

    Toast.makeText(Login.this, "Successfully ", Toast.LENGTH_SHORT).show();
    Intent i= new Intent(getApplicationContext(), MainActivity.class);

    startActivity(i);
}





                /*    if(admin.getUsername().toString()=="") {


                        Toast.makeText(Login.this, "The user does not exist", Toast.LENGTH_SHORT).show();
                    }else{

                          Intent i= new Intent(getApplicationContext(), OCRActivity.class);

                        startActivity(i);
                    }*/

                }



            });

            btlgin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent p= new Intent(getApplicationContext(), SignUp.class);



                    startActivity(p);

                }
            });


        }




    }




