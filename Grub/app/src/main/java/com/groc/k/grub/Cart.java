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


public class Cart extends Activity {
    int n1=0,n2=0,n3=0,n4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView t = (TextView) (TextView) findViewById(R.id.textView10);
        TextView t2 = (TextView) findViewById(R.id.textView15);
        TextView t3 = (TextView) findViewById(R.id.textView16);
        TextView t4 = (TextView) findViewById(R.id.textView17);

        t.setText(getIntent().getExtras().getString("q"));
        t2.setText(getIntent().getExtras().getString("q2"));
        t3.setText(getIntent().getExtras().getString("q3"));
        t4.setText(getIntent().getExtras().getString("q4"));

        TextView s = (TextView) findViewById(R.id.textView26);
        TextView s2 = (TextView) findViewById(R.id.textView27);
        TextView s3 = (TextView) findViewById(R.id.textView28);
        TextView s4 = (TextView) findViewById(R.id.textView29);
        TextView s5 = (TextView) findViewById(R.id.textView37);


        n1 = Integer.parseInt(getIntent().getExtras().getString("txt"));
        if(n1!=0){
            s.setText(getIntent().getExtras().getString("txt"));
        }

        n2 = Integer.parseInt(getIntent().getExtras().getString("t"));
        if(n2!=0){
            s2.setText(getIntent().getExtras().getString("t"));
        }

        n3 = Integer.parseInt(getIntent().getExtras().getString("tx"));
        if(n3!=0){
            s3.setText(getIntent().getExtras().getString("tx"));
        }

        n4 = Integer.parseInt(getIntent().getExtras().getString("text"));
        if(n4!=0){
            s4.setText(getIntent().getExtras().getString("text"));
        }

        int tot = n1+n2+n3+n4;

        final String total = String.valueOf(tot);
        s5.setText(total);


        //GO BACK BUTTON
        Button b = (Button) findViewById(R.id.button7);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        finish();
                }
            });

        //PROCEED BUTTON
        Button bt = (Button) findViewById(R.id.button10);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("sms:"));



                    if (n1!=0 && n2!=0 && n3!=0 && n4!=0) {
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("q") + " Rs." + getIntent().getExtras().getString("txt") + "\n+" +
                                getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                getIntent().getExtras().getString("q4") + " Rs." + getIntent().getExtras().getString("text")+
                                "\n TOTAL=" + total);
                    }
                    else if (n1!=0 && n2!=0 && n3!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("q") + " Rs." + getIntent().getExtras().getString("txt") + "\n+" +
                                getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if (n1!=0 && n2!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("q") + " Rs." + getIntent().getExtras().getString("txt") + "\n+" +
                                getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if (n2!=0 && n3!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if(n2!=0 && n3!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                getIntent().getExtras().getString("q4") + " Rs." + getIntent().getExtras().getString("text")+
                                "\n TOTAL=" + total);
                    }
                    else if (n3!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                getIntent().getExtras().getString("q4") + " Rs." + getIntent().getExtras().getString("text")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0 && n3!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("q") + " Rs." + getIntent().getExtras().getString("txt") + "\n+" +
                                getIntent().getExtras().getString("q3") + " Rs." + getIntent().getExtras().getString("tx") + "\n" +
                                "\n TOTAL=" + total);
                    }
                    else if(n2!=0 && n4!=0){
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q2") + " Rs." + getIntent().getExtras().getString("t") + "\n" +
                                getIntent().getExtras().getString("q4") + " Rs." + getIntent().getExtras().getString("text")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0 && n4!=0){
                        sendIntent.putExtra("sms_body", getIntent().getExtras().getString("q") + " Rs." + getIntent().getExtras().getString("txt") + "\n" +
                                getIntent().getExtras().getString("q4") + "Rs." + getIntent().getExtras().getString("text")+
                                "\n TOTAL=" + total);
                    }
                    else if(n1!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q")+" Rs."+getIntent().getExtras().getString("txt")+"\n TOTAL="+total);
                    else if(n2!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q2")+" Rs."+getIntent().getExtras().getString("t")+"\n TOTAL="+total);
                    else if(n3!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q3")+" Rs."+getIntent().getExtras().getString("tx")+"\n TOTAL="+total);
                    else if(n4!=0)
                        sendIntent.putExtra("sms_body",getIntent().getExtras().getString("q4")+" Rs."+getIntent().getExtras().getString("text")+"\n TOTAL="+total);

                    startActivity(sendIntent);

                }
            });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cart, menu);
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
