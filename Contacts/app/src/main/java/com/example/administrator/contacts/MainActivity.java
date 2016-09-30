package com.example.administrator.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    data data;
    ArrayAdapter<People> adapter=null;
    ArrayList<ArrayList<String>> iterator;
    EditText search;
    ListView lv=null,newContact=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        lv=(ListView)findViewById(R.id.myList);
        search=(EditText)findViewById(R.id.search);
        newContact=(ListView)findViewById(R.id.newContact);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //data.addContact("Bharath","Asokan","9524899989","ibharath462@gmail.com","PNP","image");
                //Toast.makeText(getApplicationContext(),"Contact Added..",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,addContact.class);
                startActivity(i);
                finish();
            }
        });


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(search.getText().toString());
            }
        });

        data=new data(this);

        populateMyProfile();

        populateOtherContacts();

    }

    public void populateMyProfile(){

        ArrayList<People> people=new ArrayList<>();

        //For my profile
        iterator=data.get(0);
        if(iterator.size()==0){
            Toast.makeText(getApplicationContext(),"Please setup profile..!", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,addContact.class);
            startActivity(i);
            finish();
        }
        else {
            for (ArrayList<String> t : iterator) {
                people.add(new People(t.get(0), t.get(1), t.get(2), t.get(3),t.get(4),t.get(5)));
                //Log.d("MA:",t.get(0)+" "+t.get(1)+" "+t.get(2)+" "+t.get(3)+" "+t.get(4)+" "+t.get(5));
            }

            adapter = new peopleAdapter(this, 0, people);

            lv.setAdapter(adapter);


        }

    }

    public void search(String s){
        ArrayList<People> people=new ArrayList<>();

        //For my profile
        iterator=data.search(s);
        if(iterator.size()==0){
           Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();
        }
        else {
            for (ArrayList<String> t : iterator) {
                people.add(new People(t.get(0), t.get(1), t.get(2), t.get(3),t.get(4),t.get(5)));
                //Log.d("MA:",t.get(0)+" "+t.get(1)+" "+t.get(2)+" "+t.get(3)+" "+t.get(4)+" "+t.get(5));
            }

            adapter = new peopleAdapter(this, 0, people);

            newContact.setAdapter(adapter);

            adapter.notifyDataSetChanged();


        }
    }

    public void populateOtherContacts(){

        ArrayList<People> people=new ArrayList<>();

        //For my profile
        iterator=data.get(1);
        if(iterator.size()==0){
            Toast.makeText(getApplicationContext(),"Make new contacts buddy!", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,addContact.class);
            startActivity(i);
            finish();
        }
        else {
            for (ArrayList<String> t : iterator) {
                people.add(new People(t.get(0), t.get(1), t.get(2), t.get(3),t.get(4),t.get(5)));
                //Log.d("MA:",t.get(0)+" "+t.get(1)+" "+t.get(2)+" "+t.get(3)+" "+t.get(4)+" "+t.get(5));
            }

            adapter = new peopleAdapter(this, 0, people);

            newContact.setAdapter(adapter);


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
