package com.example.shrreyabhatachaarya.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.shrreyabhatachaarya.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    // Variables to store the values for the list index of the selected images, default value will be 0
    private int headIndex, bodyIndex, legsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {

        // Dividing by 12 gives us integer values for body part number because each list has 12 image resources
        int bodyPartNumber = position/12;

        // Store the correct list index
        int listIndex = position - 12 * bodyPartNumber;

        // Set the currently displayed item for the correct body part fragment
        switch(bodyPartNumber) {
            case 0: headIndex = listIndex;
                break;
            case 1: bodyIndex = listIndex;
                break;
            case 2: legsIndex = listIndex;
                break;
            default: break;
        }

        // Put this information in a bundle
        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legsIndex", legsIndex);

        // Attach the bundle to an intent that will launch an AndroidMeActivity
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
