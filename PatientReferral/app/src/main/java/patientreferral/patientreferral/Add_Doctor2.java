package patientreferral.patientreferral;

import android.content.Intent;
import android.os.Bundle;
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

public class Add_Doctor2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doctor2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String t = intent.getStringExtra("Title");
        setTitle(t);

        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.array_files)));
        adapter = new ArrayAdapter<>(Add_Doctor2.this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

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
        Intent intent = new Intent(Add_Doctor2.this,Doctor_info.class);
        intent.putExtra("Position",i);
        startActivity(intent);
    }
}
