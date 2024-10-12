package sp.jmet.simpletodolistandroid.controller;

import android.content.Context;

import java.util.List;

import sp.jmet.simpletodolistandroid.config.AppDatabase;
import sp.jmet.simpletodolistandroid.dao.NoteDao;
import sp.jmet.simpletodolistandroid.model.NoteModel;

public class NoteController {

    private final AppDatabase db;

    public NoteController(Context context) {
        this.db = AppDatabase.getInstance(context);
    }
    public void create(NoteModel model) {
        NoteDao noteDao = db.noteDao();
        noteDao.insert(model);
    }

    public List<NoteModel> getAllNotes() {
        NoteDao noteDao = db.noteDao();
        return noteDao.getAllNotes();
    }
}
