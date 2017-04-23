package cl.philipsoft.ph1l.retrowow.data;

import java.util.List;

import cl.philipsoft.ph1l.retrowow.models.Class;
import cl.philipsoft.ph1l.retrowow.models.Race;

/**
 * Created by phil_ on 23-04-2017.
 */

public class ClassesData {
    public List<Class> classes() {
        return Class.listAll(Class.class);
    }

    public void handler(Class[] classes) {
        for (Class clas :
                classes) {
            List<Class> classList = Class.find(Class.class, "remoteId = ?", String.valueOf(clas.getId()));
            if (classList == null || classList.size() == 0) {
                clas.create();
            }
        }
    }
}
