package cl.philipsoft.ph1l.retrowow.network.battlenet.races;

import cl.philipsoft.ph1l.retrowow.models.Race;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Races {

    //

    /**
     *
     * https://us.api.battle.net/wow/data/character/races?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh
     * BASE_URL+wow/data/character/races?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh
     *
     * @param locale
     * @param apikey
     * @return
     */

    @GET("wow/data/character/races")
    Call<Race[]> get(
            @Query("locale") String locale,
            @Query("apikey") String apikey
    );
}
