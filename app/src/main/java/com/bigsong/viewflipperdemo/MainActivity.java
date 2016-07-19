package com.bigsong.viewflipperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ViewFlipper mViewFlipper;
    private Spinner mSpinner;
    private String[] mStrings = {"Push up","Push left","Cross fade","Hyperspace"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mViewFlipper.startFlipping();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mStrings);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                mViewFlipper.setInAnimation(this,R.anim.push_up_in);
                mViewFlipper.setOutAnimation(this,R.anim.push_up_out);
                break;
            case 1:
                mViewFlipper.setInAnimation(this,R.anim.push_left_in);
                mViewFlipper.setOutAnimation(this,R.anim.push_left_out);
                break;
            case 2:
                mViewFlipper.setInAnimation(this,android.R.anim.fade_in);
                mViewFlipper.setOutAnimation(this,android.R.anim.fade_out);
                break;
            case 3:
                mViewFlipper.setInAnimation(this,R.anim.hyperspace_in);
                mViewFlipper.setOutAnimation(this,R.anim.hyperspace_out);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
