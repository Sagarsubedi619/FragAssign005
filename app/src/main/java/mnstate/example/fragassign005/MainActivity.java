/*
Author: Sagar Subedi
Assignment: 5( Fragments)
Professor: Dr. Rhonda Ficek
Date: 03/22/2020
 */

/*
Description: This app  allows user to input Data in a form which is in a fragment and pass those Data
             to another Fragment

Pre-conditions:  At least 4 items  must pass data between fragments.Use of Radio Buttons, Calendar View,
                 Spinner and a seekbar.

Post-condition: Should do calculation with date selected.Should output the passed data in different fragment

 */



package mnstate.example.fragassign005;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        Blue frag2=new Blue();
        Green frag1=new Green();
        t.add(R.id.green_fragment_container,frag1);
        t.add(R.id.blue_fragment_container,frag2);
        t.commit();



    }

    public void mymethod(String name, String lname,String gender,String Age, String Major,String rating) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction t1=fm.beginTransaction();
        Blue Blue11=new Blue();
        Bundle bbb1=new Bundle();
        bbb1.putString("name","Name: "+name);
        bbb1.putString("lname","Last Name : "+lname);
        bbb1.putString("gender",gender);
        bbb1.putString("Age",Age+" Years old");
        bbb1.putString("Major",Major);
        bbb1.putString("rating",rating);

        Blue11.setArguments(bbb1);
        t1.add(R.id.blue_fragment_container,Blue11);
        t1.commit();

    }


}
