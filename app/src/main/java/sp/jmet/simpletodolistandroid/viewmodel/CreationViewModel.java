package sp.jmet.simpletodolistandroid.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import sp.jmet.simpletodolistandroid.dao.NoteDao;
import sp.jmet.simpletodolistandroid.model.NoteModel;

public class CreationViewModel extends BaseViewModel {

    public CreationViewModel(@NonNull Application application) {
        super(application);
    }

    public void insert(NoteModel model) {
        new InsertUserAsyncTask(super.noteDao).execute(model);
    }

    private static class InsertUserAsyncTask extends AsyncTask<NoteModel, Void, Void> {
        private final NoteDao noteDao;

        private InsertUserAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NoteModel... models) {
            noteDao.insert(models[0]);
            return null;
        }
    }
}
