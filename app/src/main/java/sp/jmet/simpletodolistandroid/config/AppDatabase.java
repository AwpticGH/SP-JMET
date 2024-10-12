package sp.jmet.simpletodolistandroid.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import sp.jmet.simpletodolistandroid.dao.NoteDao;
import sp.jmet.simpletodolistandroid.helper.TypeHelper;
import sp.jmet.simpletodolistandroid.model.NoteModel;

@Database(entities = {NoteModel.class}, version = 1)
@TypeConverters({TypeHelper.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
