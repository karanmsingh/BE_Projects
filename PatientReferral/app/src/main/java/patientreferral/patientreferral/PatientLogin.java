package patientreferral.patientreferral;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)

public class PatientLogin extends AppCompatActivity {

    DateFormat dateFormat = DateFormat.getDateInstance();
    Calendar date = Calendar.getInstance();
    TextView text;
    Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PatientLogin.this,PatientSFiles.class);
                startActivity(i);

            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radioButton:
                        Toast.makeText(PatientLogin.this,"Male",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(PatientLogin.this,"Female",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        text = (TextView) findViewById(R.id.textView4);
        dateButton = (Button) findViewById(R.id.button5);
        text.setText(dateFormat.format(date.getTime()));

        dateButton = (Button) findViewById(R.id.button5);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDate();
            }
        });
    }

    private void updateDate(){
        new DatePickerDialog(this,d,date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            date.set(Calendar.YEAR,i);
            date.set(Calendar.MONTH,i1);
            date.set(Calendar.DAY_OF_MONTH,i2);
            text.setText(dateFormat.format(date.getTime()));
        }
    };

}
