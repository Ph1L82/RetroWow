package cl.philipsoft.ph1l.retrowow.models;

import com.google.gson.annotations.SerializedName;

public class Race extends BaseSugar{
    private String side, name;
    @SerializedName("id")
    private int race_id;
    private int mask;

    public Race() {
    }

    public String getSide() {
        return this.side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRace_id() {
        return this.race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }
}
