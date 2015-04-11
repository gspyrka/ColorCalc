package com.example.kambey_user.colorcalc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ColorCalc extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_calc);
    }

    public void GoToShowColor(View view)
    {
        EditText edit = (EditText) findViewById(R.id.editText);
        if(ValidateHex(edit.getText().toString()))
        {
            Intent intent = new Intent(this, ShowColor.class);
            intent.putExtra("com.example.kambey_user.colorcalc.colorCode", edit.getText().toString());
            startActivity(intent);
        }
        else
        {
            TextView tv = (TextView)findViewById(R.id.validate);
            tv.setText("Invalid hex number!");
        }
    }

    private boolean ValidateHex(String hex)
    {
        if(hex.length() != 6)
        {
            return false;
        }
        if(hex.matches("^[0-9A-Fa-f]+$"))
        {
            return true;
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color_calc, menu);
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
