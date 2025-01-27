package Objects;

public abstract class Entity {
    private final String ICON;

    public Entity(String ICON) {
        this.ICON = ICON;
    }

    @Override
    public String toString() {
        return ICON;
    }
}
