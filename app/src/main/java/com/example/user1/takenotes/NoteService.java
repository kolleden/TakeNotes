package com.example.user1.takenotes;

import java.util.ArrayList;

/**
 * Created by USER1 on 06/10/2016.
 */
public interface NoteService
{
    void updateNote(); //updates note

    Note createNote(); //creates a note

    ArrayList<Note> getNote(); //get note list
}
