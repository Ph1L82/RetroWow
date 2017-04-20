package cl.philipsoft.ph1l.retrowow.models;

import com.orm.SugarRecord;

/**
 * Created by phil_ on 19-04-2017.
 */

public class BaseSugar extends SugarRecord {

    private long remote_id;

    public long getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(long remote_id) {
        this.remote_id = remote_id;
    }

    @Override
    public long save() {
        return super.save();
    }

    private void create() {
        setRemote_id(getId());
        setId(null);
        super.save();
    }
}
