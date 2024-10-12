package sp.jmet.simpletodolistandroid.flag;

import android.widget.EditText;

import java.util.Calendar;

import sp.jmet.simpletodolistandroid.helper.DateHelper;
import sp.jmet.simpletodolistandroid.model.DateModel;

public class CreationFlag {

    public static boolean isValid(Calendar cal, int year, int month, int day) {
        DateModel model = DateHelper.getCurrentDate(cal);

        return year >= model.getYear() && month >= model.getMonth() && day >= model.getDay();
    }

    public static boolean isEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }

}
