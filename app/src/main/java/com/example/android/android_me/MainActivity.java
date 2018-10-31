package com.example.android.android_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.onImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void imageClicked(int position)
    {
        Toast.makeText(this,"This is the position " + position , Toast.LENGTH_LONG).show();

        if ( position >=0 && position <=11)
        {
            headIndex = position;
        }
        if ( position >=12 && position <=23)
        {
            bodyIndex = position-12;
        }
        if ( position >=24 && position <=35)
        {
            legIndex = position - 24 ;
        }

//        Bundle to send



        final Intent i = new Intent(this , Android_Me_Activity.class);
        i.putExtra("HeadIndex",headIndex);
        i.putExtra("BodyIndex",bodyIndex);
        i.putExtra("LegIndex",legIndex);

        Log.d("Values","This is the indexes " + " " + headIndex + " " + bodyIndex + " " + legIndex + " Those are the values ");
        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(i);
            }
        });


    }
}
