package com.groc.k.grub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Bag extends  Activity{

    int n1=0,n2=0,n3=0,n4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        TextView t = (TextView) findViewById(R.id.textView18);
        TextView t2 = (TextView) findViewById(R.id.textView19);
        TextView t3 = (TextView) findViewById(R.id.textView20);
        TextView t4 = (TextView) findViewById(R.id.textView21);
        final TextView t5 = (TextView) findViewById(R.id.textView30);
        TextView t6 = (TextView) findViewById(R.id.textView31);
        TextView t7 = (TextView) findViewById(R.id.textView32);
        TextView t8 = (TextView) findViewById(R.id.textView33);
        TextView t9 = (TextView) findViewById(R.id.textView35);


        t.setText(getIntent().getExtras().getString("z"));
        t2.setText(getIntent().getExtras().getString("z1"));
        t3.setText(getIntent().getExtras().getString("z2"));
        t4.setText(getIntent().getExtras().getString("z3"));



         n1 = Integer.parseInt(getIntent().getExtras().getString("gt"));
        if(n1!=0){
            t5.setText(getIntent().getExtras().getString("gt"));
        }

         n2 = Integer.parseInt(getIntent().getExtras().getString("gt2"));
        if(n2!=0){
            t6.setText(getIntent().getExtras().getString("gt2"));
        }

         n3 = Integer.parseInt(getIntent().getExtras().getString("gt3"));
        if(n3!=0){
            t7.setText(getIntent().getExtras().getString("gt3"));
        }

         n4 = Integer.parseInt(getIntent().getExtras().getString("gt4"));
        if(n4!=0){
            t8.setText(getIntent().getExtras().getString("gt4"));
        }

        final int tot = n1+n2+n3+n4;

        final String total = String.valueOf(tot);
        t9.setText(total);

        Button b = (Button) findViewById(R.id.button8);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                              finish();
                }
            });

        //PROCEED BUTTON
        Button bt = (Button) findViewById(R.id.button9);

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("sms:"));



                     if (n1!=0 && n2!=0 && n3!=0 && n4!=0) {
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("z") + " Rs." + getIntent().getExtras().getString("gt") + "\n+" +
                                getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                getIntent().getExtras().getString("z3") + " Rs." + getIntent().getExtras().getString("gt4")+
                                "\n TOTAL=" + total);
                    }
                    else if (n1!=0 && n2!=0 && n3!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("z") + " Rs." + getIntent().getExtras().getString("gt") + "\n+" +
                                getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if (n1!=0 && n2!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("z") + " Rs." + getIntent().getExtras().getString("gt") + "\n+" +
                                getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if (n2!=0 && n3!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if(n2!=0 && n3!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                getIntent().getExtras().getString("z3") + " Rs." + getIntent().getExtras().getString("gt4")+
                                "\n TOTAL=" + total);
                    }
                    else if (n3!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                getIntent().getExtras().getString("z3") + " Rs." + getIntent().getExtras().getString("gt4")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0 && n3!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("z") + " Rs." + getIntent().getExtras().getString("gt") + "\n+" +
                                getIntent().getExtras().getString("z2") + " Rs." + getIntent().getExtras().getString("gt3") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if(n2!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z1") + " Rs." + getIntent().getExtras().getString("gt2") + "\n" +
                                getIntent().getExtras().getString("z3") + " Rs." + getIntent().getExtras().getString("gt4")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0 && n4!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("z") + " Rs." + getIntent().getExtras().getString("gt") + "\n" +
                                getIntent().getExtras().getString("z3") + "Rs." + getIntent().getExtras().getString("gt4")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z")+" Rs."+getIntent().getExtras().getString("gt")+"\n TOTAL="+total);
                    else if(n2!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z1")+" Rs."+getIntent().getExtras().getString("gt2")+"\n TOTAL="+total);
                    else if(n3!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z2")+" Rs."+getIntent().getExtras().getString("gt3")+"\n TOTAL="+total);
                    else if(n4!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("z3")+" Rs."+getIntent().getExtras().getString("gt4")+"\n TOTAL="+total);

                    startActivity(sendIntent);
                }
            });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bag, menu);
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
