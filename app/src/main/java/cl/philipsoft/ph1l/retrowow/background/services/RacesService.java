package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import cl.philipsoft.ph1l.retrowow.background.asynctasks.GetRaces;
import cl.philipsoft.ph1l.retrowow.network.battlenet.BattleNet;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class RacesService extends IntentService {
    private static final String ACTION_RACES = "cl.philipsoft.ph1l.retrowow.background.action.RACES";
    public static final String RACES_FINISHED = "cl.philipsoft.ph1l.retrowow.background.broadcast.RACES_FINISHED";

    public RacesService() {
        super("RacesService");
    }

    public static void startActionRaces(Context context) {
        Intent intent = new Intent(context, RacesService.class);
        intent.setAction(ACTION_RACES);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_RACES.equals(action)) {
                fetchRaces();
            }
        }
    }

    private void fetchRaces() {
        new FetchRaces().execute(BattleNet.DEFAULT_LOCALE, BattleNet.API_KEY);
    }

    private class FetchRaces extends GetRaces {
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("RACES_RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(RACES_FINISHED);
            LocalBroadcastManager.getInstance(RacesService.this).sendBroadcast(intent);
        }
    }
}
