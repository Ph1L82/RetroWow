package cl.philipsoft.ph1l.retrowow.network.battlenet.classes;

import cl.philipsoft.ph1l.retrowow.models.Class;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Classes {

    @GET("data/character/classes")
    Call<Class[]> get(
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );
}
