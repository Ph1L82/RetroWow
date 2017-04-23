package cl.philipsoft.ph1l.retrowow.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class RealmsService extends IntentService {
    private static final String ACTION_REALMS = "cl.philipsoft.ph1l.retrowow.background.action.REALMS";

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
    }
}
