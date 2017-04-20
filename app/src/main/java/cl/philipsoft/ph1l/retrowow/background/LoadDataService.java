package cl.philipsoft.ph1l.retrowow.background;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by phil_ on 19-04-2017.
 */

public class LoadDataService extends IntentService {

    private static final String ACTION_RECENT_USERS = "cl.philipsoft.ph1l.retrowow.background.action.ACTION_RECENT_USERS";
    public static final String USERS_FINISHED = "cl.philipsoft.ph1l.retrowow.background.broadcast.USERS_FINISHED";

//    /**
//     * Creates an IntentService.  Invoked by your subclass's constructor.
//     *
//     * @param name Used to name the worker thread, important only for debugging.
//     */
//    public LoadDataService(String name) {
//        super(name);
//    }

    public LoadDataService(){
        super("LoadDataService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent!=null){
            final String action = intent.getAction();

        }
    }
}
