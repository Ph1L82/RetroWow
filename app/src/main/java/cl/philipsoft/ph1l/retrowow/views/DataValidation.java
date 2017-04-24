package cl.philipsoft.ph1l.retrowow.views;

import android.util.Log;

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
        List<Realm> realms = Realm.listAll(Realm.class);
        if (realms != null && realms.size() > 0) {
            callback.realmsLoaded();
            Log.d("DVREALMS", "REALMS SIZE: " + String.valueOf(realms.size()));
        } else {
            callback.loadRealms();
        }


        List<Race> races = Race.listAll(Race.class);
        if (races != null && races.size() > 0) {
            callback.racesLoaded();
            Log.d("DVRACES", "RACES SIZE: " + String.valueOf(races.size()));
        } else {
            callback.loadRaces();
        }

        List<Class> classes = Class.listAll(Class.class);
        if (classes != null && classes.size() > 0) {
            callback.classesLoaded();
            Log.d("DVCLASSES", "CLASSES SIZE: " + String.valueOf(classes.size()));
        } else {
            callback.loadClasses();
        }
    }
}
