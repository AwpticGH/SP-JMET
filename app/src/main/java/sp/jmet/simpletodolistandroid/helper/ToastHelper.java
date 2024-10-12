package sp.jmet.simpletodolistandroid.helper;

import android.content.Context;
import android.widget.Toast;

import sp.jmet.simpletodolistandroid.R;

public class ToastHelper {

    public static Toast dateInvalid(Context context) {
        return Toast.makeText(context, context.getString(R.string.date_invalid), Toast.LENGTH_LONG);
    }

    public static Toast titleEmpty(Context context) {
        return Toast.makeText(context, context.getString(R.string.et_title_empty), Toast.LENGTH_LONG);
    }

    public static Toast createSuccess(Context context) {
        return Toast.makeText(context, context.getString(R.string.create_success), Toast.LENGTH_SHORT);
    }
}
