package com.example.metropicker;





import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class ListActivity extends AppCompatActivity {

    String[] stations = {"Академмістечко","Житомирська","Святошин","Нивки","Берестейська","Шулявсяька","Політехнічний інститут","Вокзальна","Університет","Театральна","Хрещатик","Арсенальна"};

    private final String MAIN ="com.example.action.MAIN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toast toast = Toast.makeText(getApplicationContext(),getIntent().getAction(),Toast.LENGTH_SHORT);
        toast.show();
        ListView list = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stations);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               back(view,((TextView)view).getText().toString());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        menu.add("Повернутись");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().toString().equals("Повернутись")){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("name","Нічого не обрано");
            intent.setAction(MAIN);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void back(View v, String s){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("name",s);
        intent.setAction(MAIN);
        startActivity(intent);
    }
}