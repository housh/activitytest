package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.activitytest.activity.BasicActivityA;
import com.example.activitytest.activity.StartForResultActivityOne;
import com.example.activitytest.fragment.BackStackTestActivity;
import com.example.activitytest.fragment.FragmentBasicActivity;
import com.example.activitytest.fragment.FragmentReplacementActivity;
import com.example.activitytest.fragment.FragmentStartActivityForResult;
import com.example.activitytest.fragment.FragmentWithParametersActivity;
import com.example.activitytest.fragment.NestedFragmentsDemoActivity;
import com.example.activitytest.fragment.NestedFragmentsInDynamicContainerActivity;
import com.example.activitytest.fragment.NestedFragmentsInLayoutActivity;
import com.example.activitytest.launchmode.StandardActivity;
import com.example.activitytest.state.StateRestoreDemoActivity;
import com.example.activitytest.toolbar.ToolbarDemoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class MainActivity extends AppCompatActivity {

    private static Sample[] mSamples;
    @BindView(R.id.samples_list)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSamples = new Sample[]{
                new Sample(R.string.basic_activity_lifecycle, BasicActivityA.class),
                new Sample(R.string.start_activity_for_result_demo, StartForResultActivityOne.class),
                new Sample(R.string.launch_mode_demo, StandardActivity.class),
                new Sample(R.string.basic_fragment_lifecycle, FragmentBasicActivity.class),
                new Sample(R.string.nested_fragments_in_layout, NestedFragmentsInLayoutActivity.class),
                new Sample(R.string.nested_fragments_in_dynamic_container, NestedFragmentsInDynamicContainerActivity.class),
                new Sample(R.string.nested_fragments, NestedFragmentsDemoActivity.class),
                new Sample(R.string.fragment_with_parameters, FragmentWithParametersActivity.class),
                new Sample(R.string.fragment_replacement, FragmentReplacementActivity.class),
                new Sample(R.string.fragment_start_activity_for_result_demo, FragmentStartActivityForResult.class),
                new Sample(R.string.state_restore_demo, StateRestoreDemoActivity.class),
                new Sample(R.string.toolbar_demo, ToolbarDemoActivity.class),
                new Sample(R.string.back_stack_test_demo, BackStackTestActivity.class)
        };

        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mSamples));
    }

    @OnItemClick(R.id.samples_list)
    void onSampleListClick(AdapterView<?> parent, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }
}
