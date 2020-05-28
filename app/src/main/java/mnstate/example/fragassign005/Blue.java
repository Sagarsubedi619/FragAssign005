package mnstate.example.fragassign005;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Blue extends Fragment {
    TextView t1,t2,t3,t4,t5,t6;


    public Blue(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blue, container, false);
        t1=v.findViewById(R.id.fNameRec);
        t2=v.findViewById(R.id.LnameRec);
        t3=v.findViewById(R.id.genRec);
        t4=v.findViewById(R.id.ageRec);
        t5=v.findViewById(R.id.majorRec);
        t6=v.findViewById(R.id.rateRec);

        Bundle B2=getArguments();
        if(B2!=null){
            String name=B2.getString("name");
            String lname=B2.getString("lname");
            String gender=B2.getString("gender");
            String Age=B2.getString("Age");
            String Major=B2.getString("Major");
            String rating=B2.getString("rating");

            t1.setText(name);
            t2.setText(lname);
            t3.setText(gender);
            t4.setText(Age);
            t5.setText(Major);
            t6.setText(rating);

        }
        return v;


    }
}
