package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class RacesService extends IntentService {
    private static final String ACTION_RACES = "cl.philipsoft.ph1l.retrowow.background.action.RACES";

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
    }

}
