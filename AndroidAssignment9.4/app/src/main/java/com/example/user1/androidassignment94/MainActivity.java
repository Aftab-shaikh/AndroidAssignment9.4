package com.example.user1.androidassignment94;
/*
this assignment is a expamle of list view and context menu
 */

// imported required clasess
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//class starts here
public class MainActivity extends AppCompatActivity{

    // some private refence variables and list and array list data
    private ListView list;
    private ArrayList <String>arraylist;


    @Override
    // on creat method works as main method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting action bar support
        getSupportActionBar();

        //id assinged to list view
        list= (ListView) findViewById(R.id.list_view);
        //obj of array list
        arraylist=new ArrayList();
        for(int i =0; i<10;i++){
            arraylist.add("item" +i);
        }

        // array adapter to get data for list view
        ArrayAdapter<String> arrayadapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arraylist);

       // setting array adapter to list view
        list.setAdapter(arrayadapter);

        // registering for context menu
        registerForContextMenu(list);

    }


    @Override

    // this method use to creat context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //to creat header
        menu.setHeaderTitle("select options");

        // to creat options
        menu.add(0,101,1,"Action1");
        menu.add(0,102,2,"Action2");
        menu.add(0,103,3,"Action2");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    // this method use to select item on context menu
    public boolean onContextItemSelected(MenuItem item) {

        // getting id in int variable if id matches then show toast
        int id = item.getItemId();
        if(id == 101){

            Toast.makeText(MainActivity.this,"You Have Clicked Action 1", Toast.LENGTH_SHORT).show();
        }
        if(id == 102){
            Toast.makeText(MainActivity.this,"You Have Clicked Action 2",Toast.LENGTH_SHORT).show();

        }
        if(id == 103){
            Toast.makeText(MainActivity.this,"You Have Clicked Action 2",Toast.LENGTH_SHORT).show();

        }


        return super.onContextItemSelected(item);
    }
}
// class closed