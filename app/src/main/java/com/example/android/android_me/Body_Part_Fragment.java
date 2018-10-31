package com.example.android.android_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class Body_Part_Fragment extends Fragment
{

    private int listIndex;
    private List<Integer> imageIds;
    public Body_Part_Fragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.body_part_fragment,container,false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.image);

        imageView.setImageResource(imageIds.get(listIndex));

        return rootView;
    }

    public void setImageIds(List<Integer>imageIds)
    {
        this.imageIds = imageIds;
    }

    public void setListIndex(int index)
    {
        this.listIndex = index;
    }
}
