package cl.philipsoft.ph1l.retrowow.network.battlenet.races;

import cl.philipsoft.ph1l.retrowow.models.Race;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Races {

    @GET("wow/data/character/races")
    Call<Race[]> get(
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );
}
