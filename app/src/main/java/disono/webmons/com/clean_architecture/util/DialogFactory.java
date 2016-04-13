package disono.webmons.com.clean_architecture.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import disono.webmons.com.clean_architecture.R;

/**
 * Author: Archie, Disono
 * Package: disono.webmons.com.clean_architecture.util
 * Created at: 2016-04-13 11:26 AM
 */
public class DialogFactory {
    public static Dialog error(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setNeutralButton(R.string.dialog_button_ok, null);

        return alertDialog.create();
    }

    public static Dialog error(Context context) {
        return error(context,
                context.getString(R.string.dialog_error_title),
                context.getString(R.string.dialog_error_message));
    }

    public static ProgressDialog progress(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);

        return progressDialog;
    }

    public static ProgressDialog progress(Context context) {
        return progress(context,
                context.getString(R.string.dialog_progress_message));
    }
}
