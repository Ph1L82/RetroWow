package cl.philipsoft.ph1l.retrowow.network.battlenet.characters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cl.philipsoft.ph1l.retrowow.models.Character;
import cl.philipsoft.ph1l.retrowow.network.battlenet.Battlenet;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phil_ on 19-04-2017.
 */

public class CharacterInterceptor extends Battlenet {

    public Character get() {
    /*This is very common in gets cause increase the response time wait and add headers and does retrys*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder().build();

                Response response = chain.proceed(request);

            /*If the request fail then you get 3 retrys*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Character character = interceptor.create(Character.class);

        return character;
    }

}