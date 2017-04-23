package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import cl.philipsoft.ph1l.retrowow.background.asynctasks.GetClasses;
import cl.philipsoft.ph1l.retrowow.background.asynctasks.GetRealms;
import cl.philipsoft.ph1l.retrowow.network.battlenet.BattleNet;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class RealmsService extends IntentService {
    private static final String ACTION_REALMS = "cl.philipsoft.ph1l.retrowow.background.action.REALMS";
    public static final String REALMS_FINISHED = "cl.philipsoft.ph1l.retrowow.background.broadcast.REALMS_FINISHED";

    public RealmsService() {
        super("RealmsService");
    }

    public static void startActionRealms(Context context) {
        Intent intent = new Intent(context, RealmsService.class);
        intent.setAction(ACTION_REALMS);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_REALMS.equals(action)) {
                fetchRealms();
            }
        }
    }

    private void fetchRealms() {
        new FetchRealms().execute(BattleNet.DEFAULT_LOCALE, BattleNet.API_KEY);
    }

    private class FetchRealms extends GetRealms {

        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("REALMS_RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(REALMS_FINISHED);
            LocalBroadcastManager.getInstance(RealmsService.this).sendBroadcast(intent);
        }
    }
}
