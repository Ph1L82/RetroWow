package cl.philipsoft.ph1l.retrowow.models;

import com.google.gson.annotations.SerializedName;

public class Class extends BaseSugar {
    private String name;
    @SerializedName("id")
    private int class_id;
    private int mask;
    private String powerType;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public String getPowerType() {
        return this.powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }
}
