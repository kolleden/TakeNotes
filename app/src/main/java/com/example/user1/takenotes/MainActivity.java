package com.example.user1.takenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteService noteService = new NoteSaver(this);
        Button add = (Button) findViewById(R.id.add);

        noteService.updateNote();




    }
}
