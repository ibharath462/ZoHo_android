package com.example.administrator.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addContact extends AppCompatActivity {

    EditText fname,lname,mobile,mail;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        fname=(EditText)findViewById(R.id.eee);
        lname=(EditText)findViewById(R.id.sname);
        mobile=(EditText)findViewById(R.id.mobile);
        mail=(EditText)findViewById(R.id.mail);
        add=(Button)findViewById(R.id.submit);
        final data data=new data(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.addContact(fname.getText().toString(),lname.getText().toString(),mobile.getText().toString(),mail.getText().toString(),"","");
                Toast.makeText(getApplicationContext(),"Added successfully..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(addContact.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
