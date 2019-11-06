package patientreferral.patientreferral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "kasingh.1451@gmail.com";
    private static final String TWITTER_SECRET = "gangbike";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.st));
        setContentView(R.layout.activity_main);

        ImageButton doc = (ImageButton) findViewById(R.id.imageButton);
        ImageButton pat = (ImageButton) findViewById(R.id.imageButton2);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DoctorLogin.class);
                startActivity(i);
            }
        });

        pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PatientLogin.class);
                startActivity(i);
            }
        });

    }


}
