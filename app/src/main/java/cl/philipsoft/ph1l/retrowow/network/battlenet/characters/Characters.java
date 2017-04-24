package cl.philipsoft.ph1l.retrowow.network.battlenet.characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface Characters {

    @GET("wow/character/{realm}/{character}")
    Call<Character> get(
            @Path("realm") String realm,
            @Path("character") String character,
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );
}
