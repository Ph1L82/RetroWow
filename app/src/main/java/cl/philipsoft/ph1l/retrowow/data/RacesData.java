package cl.philipsoft.ph1l.retrowow.data;

import java.util.List;

import cl.philipsoft.ph1l.retrowow.models.Race;

/**
 * Created by phil_ on 21-04-2017.
 */

public class RacesData {
    public List<Race> races() {
        return Race.listAll(Race.class);
    }

    public void handler(Race[] races) {
        for (Race race :
                races) {
            List<Race> racesList = Race.find(Race.class, "remoteId = ?", String.valueOf(race.getId()));
            if (racesList == null || racesList.size() == 0) {
                race.create();
            }
        }
    }
}
