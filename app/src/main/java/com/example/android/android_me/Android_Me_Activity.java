package com.example.android.android_me;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Android_Me_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android__me_);

        Intent i = getIntent();
        int headIndex = i.getIntExtra("HeadIndex",0);
        int bodyIndex = i.getIntExtra("BodyIndex",0);
        int legIndex = i.getIntExtra("LegIndex",0);

        Log.d("Values","This are the values " + headIndex + " " + bodyIndex + " " + legIndex );
        FragmentManager fragmentManager = getSupportFragmentManager();
//        This is the fragment for the head
        Body_Part_Fragment headFragment = new Body_Part_Fragment();
        headFragment.setImageIds(AndroidImageAssets.getHeads());
        headFragment.setListIndex(headIndex);
                fragmentManager.beginTransaction()
                .add(R.id.head_fragment,headFragment)
                .commit();

//        This is the fragment fot the body
        Body_Part_Fragment BodyFragment = new Body_Part_Fragment();
        BodyFragment.setImageIds(AndroidImageAssets.getBodies());
        BodyFragment.setListIndex(bodyIndex);
        fragmentManager.beginTransaction()
                .add(R.id.body_fragment,BodyFragment)
                .commit();

//        This is the fragment for the legs
        Body_Part_Fragment LegsFragment = new Body_Part_Fragment();
        LegsFragment.setImageIds(AndroidImageAssets.getLegs());
        LegsFragment.setListIndex(legIndex);
        fragmentManager.beginTransaction()
                .add(R.id.leg_fragment,LegsFragment)
                .commit();

    }
}
