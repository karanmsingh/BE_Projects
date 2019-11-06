package com.groc.k.grub;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Consumables extends ActionBarActivity implements View.OnClickListener {

    private static final int LENGTH_SHORT = 1000;
    private static int x=0 , y=0 , p=0 ,q=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumables);

       final RadioButton r = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton r4 = (RadioButton) findViewById(R.id.radioButton4);

        final TextView t = (TextView) findViewById(R.id.textView);
        final TextView t2 = (TextView) findViewById(R.id.textView3);
        final TextView t3 = (TextView) findViewById(R.id.textView4);
        final TextView t4 = (TextView) findViewById(R.id.textView5);

       Button b = (Button) (Button) findViewById(R.id.button3);


        //CART BUTTON
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Consumables.this,Cart.class);
                if(r.isChecked()) {
                    intent.putExtra("txt", t.getText().toString());
                    intent.putExtra("q", "Olive Oil (1l)");
                }
                else{
                    intent.putExtra("txt","0");
                }

                if(r2.isChecked()) {
                    intent.putExtra("t", t2.getText().toString());
                    intent.putExtra("q2", "Penne Pasta 0.5kg");
                }
                else{
                    intent.putExtra("t","0");
                }

                if(r3.isChecked()) {
                    intent.putExtra("tx", t3.getText().toString());
                    intent.putExtra("q3", "White Sauce (1/2 Kg)");
                }
                else{
                    intent.putExtra("tx","0");
                }

                if(r4.isChecked()) {
                    intent.putExtra("text", t4.getText().toString());
                    intent.putExtra("q4","Pesto Sauce (1/2 Kg)");
                }
                else{
                    intent.putExtra("text","0");
                }

                startActivity(intent);

            }
        });


        //RADIO BUTTONS
            r.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                x++;
                    if(r.isChecked() && x%2!=0){
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(x%2==0) {
                        r.setChecked(false);
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
            });

            r2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    y++;
                    if(r2.isChecked() && y%2!=0){
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(y%2==0) {
                        r2.setChecked(false);
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
            });

            r3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    p++;
                    if(r3.isChecked() && p%2!=0){
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(p%2==0) {
                        r3.setChecked(false);
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });

            r4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    q++;
                    if(r4.isChecked() && q%2!=0){
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(q%2==0) {
                        r4.setChecked(false);
                        Toast toast = Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consumables, menu);
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
    public void onClick(View v) {


    }
}
