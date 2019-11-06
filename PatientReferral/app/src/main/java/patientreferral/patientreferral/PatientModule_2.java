package patientreferral.patientreferral;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class PatientModule_2 extends AppCompatActivity implements AdapterView.OnItemClickListener{

    FloatingActionButton fab,fab1,fab2;
    Animation fabOpen, fabClose,rb,rf;
    boolean isOpen = false;

    String titles[]={"Karan","ABC","ABC","DEF","asfa","asvsa","befbs","adgbaeb","cwaec","asdvrwev","avdvrw","avdwve","adbvawee",
                        "asdvwa","vewvrw","rema","mytsasd","evrwv"};
    String dates[] ={ "10/09/2015","23/05/2015", "15/12/2015", "04/01/2016", "23/05/2017", "14/09/2015", "30/08/2015", "29/12/2015",
                         "18/02/2015", "06/05/2015", "01/10/2015", "14/02/2015", "10/09/2015", "04/11/2015", "18/09/2015",
                        "11/11/2015", "22/09/2015", "25/09/2015"};
    ListView lv; MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_module_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.listview);
        adapter = new MyAdapter(PatientModule_2.this,titles,dates);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rf = AnimationUtils.loadAnimation(this,R.anim.rotate_fwd);
        rb = AnimationUtils.loadAnimation(this,R.anim.rotate_bkw);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(PatientModule_2.this,Add_Doctor.class);
                startActivity(intent);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(PatientModule_2.this,AddFile.class);
                startActivity(intent);
            }
        });
    }

    class MyAdapter extends ArrayAdapter {

        String[] filenameArray, createdArray, modifiedArray;

        public MyAdapter(Context context, String[] titles1, String[] dates1) {
            super(context, R.layout.patientextfiles, R.id.filename, titles);
            this.filenameArray = titles1;
            this.createdArray = dates1;
            this.modifiedArray = dates1;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.patientextfiles, parent, false);

            TextView myTitle = row.findViewById(R.id.filename);
            TextView created = row.findViewById(R.id.created);
            TextView modified = row.findViewById(R.id.modified);
            myTitle.setText(titles[position]);
            created.setText(dates[position]);
            modified.setText(dates[position]);

            return row;
        }
    }
    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rf);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }
        else {
            fab.startAnimation(rb);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(PatientModule_2.this,File_Content.class);
        intent.putExtra("Position",i);
        startActivity(intent);
    }

}