package cl.philipsoft.ph1l.retrowow.network.battlenet.realms;

import cl.philipsoft.ph1l.retrowow.models.Race;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Realms {

    //https://us.api.battle.net/wow/realm/status?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh

    @GET("wow/realm/status")
    Call<Race[]> get(
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );

}
