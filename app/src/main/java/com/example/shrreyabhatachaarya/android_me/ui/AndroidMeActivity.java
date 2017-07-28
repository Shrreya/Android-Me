package com.example.shrreyabhatachaarya.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shrreyabhatachaarya.android_me.R;
import com.example.shrreyabhatachaarya.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Create new fragments only when there is no previously saved state
        if (savedInstanceState == null) {

            // Create a new BodyPartFragment for each of head, body and legs
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legsFragment = new BodyPartFragment();

            // Set the list of image ids for each fragment
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            legsFragment.setImageIds(AndroidImageAssets.getLegs());

            // Retrieve the list index values that were sent through an intent, set default values to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            int legsIndex = getIntent().getIntExtra("legsIndex", 0);

            // Set the list index for each fragment
            headFragment.setmListIndex(headIndex);
            bodyFragment.setmListIndex(bodyIndex);
            legsFragment.setmListIndex(legsIndex);

            // Add each fragment to its respective container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.legs_container, legsFragment)
                    .commit();

            // TODO : two pane layout for tablets (responsive design)

        }
    }
}
