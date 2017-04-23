package cl.philipsoft.ph1l.retrowow.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ph1l.retrowow.data.RealmsData;
import cl.philipsoft.ph1l.retrowow.models.Realm;
import cl.philipsoft.ph1l.retrowow.network.RequestCode;
import cl.philipsoft.ph1l.retrowow.network.battlenet.realms.RealmInterceptor;
import cl.philipsoft.ph1l.retrowow.network.battlenet.realms.Realms;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 23-04-2017.
 */

public class GetRealms extends AsyncTask<String, Integer, Integer> {

    private final Realms request = new RealmInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Call<Realm[]> call = request.get(params[0], params[1]);
        try {
            Response<Realm[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                Realm[] realms = response.body();
                if (realms != null && realms.length > 0) {
                    new RealmsData().handler(realms);
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
        return null;
    }
}
