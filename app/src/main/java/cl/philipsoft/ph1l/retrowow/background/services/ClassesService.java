package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import cl.philipsoft.ph1l.retrowow.background.asynctasks.GetClasses;
import cl.philipsoft.ph1l.retrowow.network.battlenet.BattleNet;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class ClassesService extends IntentService {
    private static final String ACTION_CLASSES = "cl.philipsoft.ph1l.retrowow.background.action.CLASSES";
    public static final String CLASSES_FINISHED = "cl.philipsoft.ph1l.retrowow.background.broadcast.CLASSES_FINISHED";

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
        new FetchClasses().execute(BattleNet.DEFAULT_LOCALE, BattleNet.API_KEY);
    }

    private class FetchClasses extends GetClasses {

        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("CLASSES_RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(CLASSES_FINISHED);
            LocalBroadcastManager.getInstance(ClassesService.this).sendBroadcast(intent);
        }
    }
}
