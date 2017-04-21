package cl.philipsoft.ph1l.retrowow.models;

public class Realm extends BaseSugar{
    private String battlegroup, timezone, name, type, locale, slug, population;
    private String[] connected_realms;
    private boolean queue, status;

    public Realm() {
    }

    public String getBattlegroup() {
        return this.battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public String[] getConnected_realms() {
        return this.connected_realms;
    }

    public void setConnected_realms(String[] connected_realms) {
        this.connected_realms = connected_realms;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean getQueue() {
        return this.queue;
    }

    public void setQueue(boolean queue) {
        this.queue = queue;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPopulation() {
        return this.population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
