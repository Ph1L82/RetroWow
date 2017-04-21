package cl.philipsoft.ph1l.retrowow.background;

import android.os.AsyncTask;

import cl.philipsoft.ph1l.retrowow.models.Race;
import cl.philipsoft.ph1l.retrowow.network.battlenet.races.RaceInterceptor;

/**
 * Created by phil_ on 19-04-2017.
 */

public class GetRaces extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected Boolean doInBackground(String... params) {
        Race races = new RaceInterceptor().get();

        return null;
    }
}
