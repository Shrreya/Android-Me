package com.example.shrreyabhatachaarya.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shrreyabhatachaarya.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    // Strings to store state information
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;

    // Mandatory constructor for instantiating the fragment
    public BodyPartFragment() {
    }

    // Inflates the fragment layout and sets any image resources
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Load the saved state if there is one
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // Check if a list of image ids exists
        if(mImageIds != null) {
            // Set the image resource to the correct item in the list
            imageView.setImageResource(mImageIds.get(mListIndex));

            // Set a click listener on the image view
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increment position as long as the index remains <= the total number of image ids
                    if(mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        // The end of the list has been reached, so return to the beginning index
                        mListIndex = 0;
                    }
                    // Set the image resource to the new item in the list
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.d(TAG, "This fragment has a null list of image ids");
        }

        // Return root view
        return rootView;
    }

    // Setter method for keeping track of the list of images this fragment can display
    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    // Setter method for keeping track of which image in the list is currently being displayed
    public void setmListIndex(int listIndex) {
        mListIndex = listIndex;
    }

    // Save the current state of this fragment
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
