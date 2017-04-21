package cl.philipsoft.ph1l.retrowow.network.battlenet.characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Characters {

    /**
     *
     * https://us.api.battle.net/wow/character/quel'thalas/yoda?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh
     * BASE_URL+wow/character/quel'thalas/yoda?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh
     * BASE_URL+wow/character/{realm}/{character}?locale=en_US&apikey=gfnfh2y3gf6erht6pzttjwvay9ybjhjh
     * @param realm
     * @param character
     * @param locale
     * @param apikey
     * @return
     */
    @GET("wow/character/{realm}/{character}")
    Call<Characters> get(
            @Path("realm") String realm,
            @Path("character") String character,
            @Query("locale") String locale,
            @Query("apikey") String apikey
    );
}
