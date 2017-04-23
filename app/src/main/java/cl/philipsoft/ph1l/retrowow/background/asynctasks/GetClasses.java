package cl.philipsoft.ph1l.retrowow.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ph1l.retrowow.data.ClassesData;
import cl.philipsoft.ph1l.retrowow.models.Class;
import cl.philipsoft.ph1l.retrowow.network.RequestCode;
import cl.philipsoft.ph1l.retrowow.network.battlenet.classes.ClassInterceptor;
import cl.philipsoft.ph1l.retrowow.network.battlenet.classes.Classes;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 23-04-2017.
 */

public class GetClasses extends AsyncTask<String, Integer, Integer> {

    private final Classes request = new ClassInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Call<Class[]> call = request.get(params[0], params[1]);
        try {
            Response<Class[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                Class[] classes = response.body();
                if (classes != null && classes.length > 0) {
                    new ClassesData().handler(classes);
                } else {
                    code = 878470; //WTF in ascii/dec
                }
            } else {
                Log.d("REQUEST_CODE", "GETCLASSES CODE: " + String.valueOf(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return code;
    }
}
