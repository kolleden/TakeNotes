package com.example.user1.takenotes;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by USER1 on 06/10/2016.
 */
public class NoteSaver implements NoteService
{
    private final String FILE_PATH = "CoolNotes.txt";
    private final String DELIMITER = "NOTE";
    private Context context;
    private ArrayList<Note> notes;

    public NoteSaver(Context text, ArrayList<Note> notes) {
        this.context = text;
        this.notes = notes;
    }

    public void fetchNotes() {
        notes = new ArrayList<>();
        File file = new File(context.getFilesDir(), FILE_PATH);
        try {
            file.createNewFile();
            Scanner scan = new Scanner(context.openFileInput(FILE_PATH));
            scan.useDelimiter(DELIMITER);
            while (scan.hasNext()) {
                notes.add(new Note(scan.next()));
            }
            scan.close();
        }
        catch (IOException exeption) {
            throw new RuntimeException("There is a error with the file", exeption);
        }
    }

    public void updateNote()
    {
        try {
            PrintWriter pw = new PrintWriter(context.openFileOutput(FILE_PATH, context.MODE_PRIVATE));
            for(Note note:notes) {
                pw.print(note.toString());
                pw.print(DELIMITER);
            }
            pw.close();
        } catch (FileNotFoundException exeption) {
            exeption.printStackTrace();
        }
        return;
    }

    public Note createNote()
    {
        Note n = new Note("");
        notes.add(n);
        return n;
    }

    @Override
    public ArrayList<Note> getNote()
    {
        return notes;
    }


}
