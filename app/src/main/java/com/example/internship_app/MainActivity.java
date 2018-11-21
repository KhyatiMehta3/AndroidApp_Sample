package com.example.internship_app;


import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dL;
    static final int REQUEST_IMAGE_CAPTURE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dL = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                dL.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        else {
            Toast.makeText(this,"You don't have a camera app!",Toast.LENGTH_SHORT);
        }
    }
    public void onSubmitClick(View v) {
        RadioGroup radiog = findViewById(R.id.radioGroup);

        switch(radiog.getCheckedRadioButtonId()){
            case R.id.radioYes:
                dispatchTakePictureIntent();
                //Intent intent = new Intent(this, CameraActivity.class);
                //startActivity(intent);
                break;
            case R.id.radioNo:
                Toast.makeText(this, "Well, learn it then!", Toast.LENGTH_SHORT).show();
                break;
            case -1:
                Toast.makeText(this, "Duh! Select something!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
