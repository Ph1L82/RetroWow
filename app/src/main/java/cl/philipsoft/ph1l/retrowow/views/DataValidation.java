package cl.philipsoft.ph1l.retrowow.views;

import java.util.List;

import cl.philipsoft.ph1l.retrowow.models.Class;
import cl.philipsoft.ph1l.retrowow.models.Race;
import cl.philipsoft.ph1l.retrowow.models.Realm;

/**
 * Created by phil_ on 19-04-2017.
 */

public class DataValidation {

    private DataValidationCallback callback;

    public DataValidation(DataValidationCallback callback) {
        this.callback = callback;
    }

    public void init() {
        List<Class> classes = Class.listAll(Class.class);
        if (classes != null && classes.size() > 0) {
            callback.classesLoaded();
        } else {
            callback.loadClasses();
        }

        List<Race> races = Race.listAll(Race.class);
        if (races != null && races.size() > 0) {
            callback.racesLoaded();
        } else {
            callback.loadRaces();
        }

        List<Realm> realms = Realm.listAll(Realm.class);
        if (realms != null && realms.size() > 0) {
            callback.realmsLoaded();
        } else {
            callback.loadRealms();
        }
    }
}
