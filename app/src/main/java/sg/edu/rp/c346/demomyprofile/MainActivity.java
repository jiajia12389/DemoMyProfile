package sg.edu.rp.c346.demomyprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    Button btnSave;

    int intCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                onResume();
            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float iGPA = Float.parseFloat(etGPA.getText().toString());
        intCheck = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name",strName);
        prefEdit.putFloat("GPA",iGPA);
        prefEdit.putInt("Gender",intCheck);
        prefEdit.apply();


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String save = prefs.getString("Name",null);
        Float sGPA = prefs.getFloat("GPA",0);
        int sGender = prefs.getInt("Gender",0);
        String strGPA =  String.valueOf(sGPA);

        etName.setText(save);
        etGPA.setText(strGPA);
        rgGender.check(sGender);
    }


}
