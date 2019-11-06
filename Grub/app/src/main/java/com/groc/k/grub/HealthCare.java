package com.groc.k.grub;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class HealthCare extends ActionBarActivity {

    private static int x=0 , y=0 , p=0 ,q=0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        final RadioButton r = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton7);
        final RadioButton r4 = (RadioButton) findViewById(R.id.radioButton8);

        final TextView t = (TextView) findViewById(R.id.textView6);
        final TextView t2 = (TextView) findViewById(R.id.textView7);
        final TextView t3 = (TextView) findViewById(R.id.textView8);
        final TextView t4 = (TextView) findViewById(R.id.textView9);


        Button b = (Button) (Button) findViewById(R.id.button6);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthCare.this,Bag.class);

                if(r.isChecked()) {
                    intent.putExtra("gt", t.getText().toString());
                    intent.putExtra("z", "Pantene Shampoo (250ml)");
                }
                else{
                    intent.putExtra("gt","0");
                }

                if(r2.isChecked()) {
                    intent.putExtra("gt2", t2.getText().toString());
                    intent.putExtra("z1", "Shower Gel ");
                }
                else{
                    intent.putExtra("gt2","0");
                }


                if(r3.isChecked()) {
                    intent.putExtra("gt3", t3.getText().toString());
                    intent.putExtra("z2", "Shaving Foam");
                }
                else{
                    intent.putExtra("gt3","0");
                }

                if(r4.isChecked()) {
                    intent.putExtra("gt4", t4.getText().toString());
                    intent.putExtra("z3", "Listerine Mouth Wash");
                }
                else{
                    intent.putExtra("gt4","0");
                }

                startActivity(intent);
            }
        });


        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if(r.isChecked() && x %2!=0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(x %2==0) {
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

                if(r2.isChecked() && y %2!=0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(y %2==0) {
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
                if(r3.isChecked() && p %2!=0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(p %2==0) {
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

                if(r4.isChecked() && q %2!=0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(q %2==0) {
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
        getMenuInflater().inflate(R.menu.menu_health_care, menu);
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
