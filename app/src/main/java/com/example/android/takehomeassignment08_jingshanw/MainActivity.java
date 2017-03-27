package com.example.android.takehomeassignment08_jingshanw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference titleRef = database.getReference("title");
    private DatabaseReference personRef = database.getReference("person");

    private TextView title;
    private TextView name;
    private TextView age;
    private CheckBox married;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title= (TextView) findViewById(R.id.title_text_view);
        name= (TextView) findViewById(R.id.name_text_view);
        age= (TextView) findViewById(R.id.age_text_view);
        married= (CheckBox) findViewById(R.id.married_checkbox);
    }

    public void setTitle(View view)
    {
        titleRef.setValue(title.getText().toString());
    }

    public void addPerson(View view)
    {
        String n=name.getText().toString();
        int a=Integer.parseInt(age.getText().toString());
        boolean m=((CheckBox) findViewById(R.id.married_checkbox)).isChecked();
        personRef.push().setValue(new Person(n,a,m));
    }
}
