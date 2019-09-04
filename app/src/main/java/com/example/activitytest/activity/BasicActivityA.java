package com.example.activitytest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.activitytest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicActivityA extends Activity {
    private static final String LOG_TAG = "Basic";

    @BindView(R.id.basic_finish_a_button)
    public Button basic_finish_a_button;
    int anInt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate(): " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity_a);

        ButterKnife.bind(this);

        if(savedInstanceState != null&&savedInstanceState.containsKey("random")){
            String value = savedInstanceState.getString("random");
            basic_finish_a_button.setText(value);
        }

        basic_finish_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basic_finish_a_button.setText(""+Math.random());
                anInt = 56;

                Log.i(LOG_TAG, this.getClass().getSimpleName() + " setOnClickListener(): =====>" + anInt);
            }
        });

        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate(): =====>" + anInt);
    }

    @OnClick(R.id.basic_turn_to_b_button)
    void turnToBActivity() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("ra","10293");
        intent.putExtras(bundle);
        intent.setClass(BasicActivityA.this, BasicActivityB.class);
        startActivity(intent);
    }

//    @OnClick(R.id.basic_finish_a_button)
//    void finishA() {
//        finish();
//    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStart()");
        super.onStart();
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onStateNotSaved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onRestoreInstanceState(): " + savedInstanceState);

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onPause()");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("random",basic_finish_a_button.getText().toString());

        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onSaveInstanceState(): " + outState);
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onDestroy()");
        super.onDestroy();
    }
}
