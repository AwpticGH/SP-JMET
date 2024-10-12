package sp.jmet.simpletodolistandroid.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import sp.jmet.simpletodolistandroid.config.AppDatabase;
import sp.jmet.simpletodolistandroid.dao.NoteDao;

public class BaseViewModel extends AndroidViewModel {
    protected NoteDao noteDao;

    protected BaseViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        noteDao = db.noteDao();
    }
}
