package models;

public class CreateItem {

    private String thumbnail;
    private String name;
    private String realName;
    private String location;
    private boolean isAlive;

    public CreateItem(String thumbnail, String name, String realName, String location, Boolean isAlive) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.realName = realName;
        this.location = location;
        this.isAlive = isAlive;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getisAlive() {
        return isAlive;
    }

    public void setAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }
}
