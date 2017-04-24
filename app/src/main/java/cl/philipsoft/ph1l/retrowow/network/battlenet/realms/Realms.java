package cl.philipsoft.ph1l.retrowow.network.battlenet.realms;

import cl.philipsoft.ph1l.retrowow.models.Realm;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Realms {

    @GET("realm/status")
    Call<Realm[]> get(
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );
}
