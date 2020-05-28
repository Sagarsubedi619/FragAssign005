package mnstate.example.fragassign005;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Green extends Fragment {
    EditText e1,e2;
    Button b;
    RadioGroup radioGroup;
    String tmpgen;
    CalendarView calendarView;
    String tmpDate;
    Spinner spinner;
    String item;
    TextView statusper;
    ProgressBar progressBar;
    SeekBar seekBar;
    String rating;







    public Green(){

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_green,container,false);


        //for first name and last Name

        e1=v.findViewById(R.id.fname);
        e2=v.findViewById(R.id.lname);


        //for radio buttons operation

        radioGroup=v.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio1:
                        tmpgen="Male";
                        break;
                    case R.id.radio2:
                        tmpgen="Female";
                        break;
                    case R.id.radio3:
                        tmpgen="Other";
                        break;

                }
            }
        });

        //for Calendar View operation

        calendarView=v.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int curyear= Calendar.getInstance().get(Calendar.YEAR);
                tmpDate=Integer.toString((curyear-year));


            }
        });

        //for spinners operation

        spinner=v.findViewById(R.id.spinner1);
        List<String>categories=new ArrayList<>();
        categories.add("Computer science");
        categories.add("Biology");
        categories.add("Mathematics");
        categories.add("Music");
        categories.add("Health Science");
        categories.add("Business");
        categories.add("Management");
        categories.add("Nano Technology");

        ArrayAdapter<String>dataAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


     //for Seekbar operation

        statusper=v.findViewById(R.id.statusPer);
        progressBar=v.findViewById(R.id.progressBar);
        seekBar=v.findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                statusper.setText(""+progress+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });









//sending Data to the main

        b=v.findViewById(R.id.subBtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating=statusper.getText().toString();
                String Major=item;
                String Age=tmpDate;

                String gender=tmpgen;
                String name=e1.getText().toString();
                String lname=e2.getText().toString();
                MainActivity Mymain=(MainActivity) getActivity();
                Mymain.mymethod(name,lname,gender,Age,Major,rating);


            }
        });
        return v;



    }


}
