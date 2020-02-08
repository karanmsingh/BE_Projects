package patientreferral.patientreferral;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Add_Doctor extends AppCompatActivity {

    GridView gridView;
    String letterList[]={"Neurologists","Cardiologists","Dermatologists","Ophthalmologists","Orthopedics","Psychiatrists","ENT Experts",
                            "Urologists","Pediatricians"};
    int lettersIcon[]={R.drawable.brain,R.drawable.heart,R.drawable.dermatologist,R.drawable.eye,
                        R.drawable.bones,R.drawable.psychiatry,R.drawable.ent,
                            R.drawable.urology,R.drawable.pediatrician};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doctor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        gridView= (GridView) findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(Add_Doctor.this,lettersIcon,letterList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Add_Doctor.this,Add_Doctor2.class);
                intent.putExtra("Title",letterList[i]);
                startActivity(intent);
            }

        });

    }

}
