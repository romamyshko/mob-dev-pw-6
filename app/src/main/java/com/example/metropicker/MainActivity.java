package com.example.metropicker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final String PICK_METRO_STATION ="com.example.action.PICK_METRO_STATION";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.mainTxt);

        textView.setText("Виберіть станцію");
        Toast toast = Toast.makeText(getApplicationContext(),getIntent().getAction(),Toast.LENGTH_SHORT);
        toast.show();

        if(getIntent().getStringExtra("name")==null) {
            textView.setText("Виберіть станцію");
        }else {
            textView.setText(getIntent().getStringExtra("name"));
        }


    }

    public void onClickStationList(View v) {
        Intent intent = new Intent(this, ListActivity.class);
        intent.setAction(PICK_METRO_STATION);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        menu.add("Скинути");
        menu.add("Закрити");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().toString().equals("Скинути")){
            textView.setText("Виберіть станцію");
        }else{
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}