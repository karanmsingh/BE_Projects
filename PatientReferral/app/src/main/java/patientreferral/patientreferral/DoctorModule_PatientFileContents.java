package patientreferral.patientreferral;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class DoctorModule_PatientFileContents extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_module__patient_file_contents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.array_files)));
        adapter = new ArrayAdapter<>(DoctorModule_PatientFileContents.this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        String[] clikedItem = getResources().getStringArray(R.array.array_files);
        setTitle("Patient " + clikedItem[position]);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        Intent intent = new Intent(DoctorModule_PatientFileContents.this,DoctorModule_FileContents.class);
        intent.putExtra("Position",i);
        startActivity(intent);
    }
}
