package patientreferral.patientreferral;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DoctorModule_FileContents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_module__file_contents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        String[] clikedItem = getResources().getStringArray(R.array.array_files);
        setTitle(clikedItem[position]);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a Comment..", Snackbar.LENGTH_SHORT).show();

                View view1 = LayoutInflater.from(DoctorModule_FileContents.this)
                        .inflate(R.layout.activity_doctor_module__comment,null);
                final EditText comm = view1.findViewById(R.id.editText);

                AlertDialog.Builder builder = new AlertDialog.Builder(DoctorModule_FileContents.this);
                    builder.setMessage("Add A Comment")
                            .setView(view1)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String comment = comm.getText().toString();
                                }
                            })
                            .setNegativeButton("Cancel",null)
                            .setCancelable(true);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

}
