package com.example.basicactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BasicActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "key_counter";
    private int count  = 0;
    private TextView textCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textCount = (TextView) findViewById(R.id.textcount);
        setSupportActionBar(toolbar);
        if(savedInstanceState!=null){
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateView();
    }
    private void updateView(){

        textCount.setText("Count: " + count);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic, menu);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_COUNT, count);
        super.onSaveInstanceState(outState);
    }

    public void onClickFloat(View view) {
        Snackbar.make(view, "Count ++", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        count++;
        updateView();
    }
}
