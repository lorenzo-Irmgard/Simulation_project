package Objects;

public abstract class Entity {
    private final int ID;
    private final String ICON;
    private int[] coordinates;

    protected Entity(int id, String icon) {
        this.ID = id;
        this.ICON = icon;
    }

    public int getID() {
        return ID;
    }

    public String getICON() {
        return ICON;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
