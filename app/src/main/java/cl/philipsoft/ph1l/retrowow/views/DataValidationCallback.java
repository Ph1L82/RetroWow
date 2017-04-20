package cl.philipsoft.ph1l.retrowow.views;

/**
 * Created by phil_ on 19-04-2017.
 */

public interface DataValidationCallback {

    void racesLoaded();
    void racesIncomplete();
    void classesLoaded();
    void classesIncomplete();
    void realmLoaded();
    void realmIncomplete();

}
