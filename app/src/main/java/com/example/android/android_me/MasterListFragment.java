package com.example.android.android_me;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class MasterListFragment extends Fragment
{

    public MasterListFragment()
    {

    }


    public interface onImageClickListener
    {
        void imageClicked(int position);
    }

    onImageClickListener mclick;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        if(activity != null) {
            try {
                mclick = (onImageClickListener) activity;

                Log.d("Attaching", "Listener attached ");

            } catch (ClassCastException e) {
                Log.d("Attaching ", "Listener not attached " + e.toString());
            }
        }
        else
        {
            Log.d("Attaching " , "The activity is null ");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {

        final View rootView = inflater.inflate(R.layout.master_list_activity, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);


        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MaterListAdapter mAdapter = new MaterListAdapter(getActivity().getApplicationContext(), AndroidImageAssets.getAll());

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                mclick.imageClicked(i);
            }
        });
        // TODO (3) Set a click listener on the gridView and trigger the callback onImageSelected when an item is clicked

        // Return the root view
        return rootView;
    }
}
