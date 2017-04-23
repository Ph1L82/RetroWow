package cl.philipsoft.ph1l.retrowow.data;

import java.util.List;

import cl.philipsoft.ph1l.retrowow.models.Realm;

/**
 * Created by phil_ on 23-04-2017.
 */

public class RealmsData {

    public List<Realm> realms() {
        return Realm.listAll(Realm.class);
    }

    public void handler(Realm[] realms) {
        for (Realm realm :
                realms) {
            List<Realm> realmList = Realm.find(Realm.class, "remoteId = ?", String.valueOf(realm.getId()));
            if (realmList == null && realmList.size() == 0) {
                realm.create();
            }
        }
    }
}
