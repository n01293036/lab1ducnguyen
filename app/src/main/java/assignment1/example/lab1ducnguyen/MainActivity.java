package assignment1.example.lab1ducnguyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList= new ArrayList<>();

        arrayList.add("AiActivity");
        arrayList.add("VrActivity");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(view.getContext(), Activity1.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(view.getContext(), Activity2.class);
                    startActivity(intent);
                }
            }
        });

        //In and Assign Va
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomlab1);

        //Set Home Select
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Proform Item Select
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.list:
                        return true;
                }
                return false;
            }
        });
    }
}