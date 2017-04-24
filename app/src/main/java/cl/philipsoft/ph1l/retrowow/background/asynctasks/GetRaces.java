package cl.philipsoft.ph1l.retrowow.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ph1l.retrowow.data.RacesData;
import cl.philipsoft.ph1l.retrowow.models.Race;
import cl.philipsoft.ph1l.retrowow.network.RequestCode;
import cl.philipsoft.ph1l.retrowow.network.battlenet.races.RaceInterceptor;
import cl.philipsoft.ph1l.retrowow.network.battlenet.races.Races;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 19-04-2017.
 */

public class GetRaces extends AsyncTask<String, Integer, Integer> {

    private final Races request = new RaceInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Log.d("GETRACES", " params[0]:" + params[0] + " params[1]:" + params[1]);
        Call<Race[]> call = request.get(params[0], params[1]);
        try {
            Response<Race[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                Race[] races = response.body();
                if (races != null && races.length > 0) {
                    new RacesData().handler(races);
                } else {
                    code = 878470; //WTF in ascii/dec
                }
            } else {
                Log.d("REQUEST_CODE", "GETRACES CODE: " + String.valueOf(code));
            }

        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return code;
    }

}
