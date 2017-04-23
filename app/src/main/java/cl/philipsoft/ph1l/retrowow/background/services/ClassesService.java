package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class ClassesService extends IntentService {
    private static final String ACTION_CLASSES = "cl.philipsoft.ph1l.retrowow.background.action.CLASSES";

    public ClassesService() {
        super("ClassesService");
    }

    public static void startActionClasses(Context context) {
        Intent intent = new Intent(context, ClassesService.class);
        intent.setAction(ACTION_CLASSES);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CLASSES.equals(action)) {
                fetchClasses();
            }
        }
    }

    private void fetchClasses() {
    }
}
