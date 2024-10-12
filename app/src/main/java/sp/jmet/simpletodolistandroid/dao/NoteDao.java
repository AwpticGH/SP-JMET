package sp.jmet.simpletodolistandroid.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import sp.jmet.simpletodolistandroid.dictionary.QueryDictionary;
import sp.jmet.simpletodolistandroid.model.NoteModel;

@Dao
public interface NoteDao {

    @Insert
    void insert(NoteModel model);

    @Update
    void update(NoteModel model);

    @Delete
    void delete(NoteModel model);

    @Query(QueryDictionary.GET_ALL)
    List<NoteModel> getAllNotes();
}
