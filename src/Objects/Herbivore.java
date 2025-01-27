package Objects;

import java.util.ArrayList;
import java.util.List;

public class Herbivore extends Creature { ;
    private static final int START_HEALTH = 4;
    private static final int SPEED = 4;
    private static final String ICON = "\uD83E\uDD8C";

    public Herbivore() {
        super(SPEED, START_HEALTH, ICON);
    }

    public void eat() {

    }

    @Override
    Position findTarget(Position pos) {
        return null;
    }

    @Override
    int targetCheck(Position pos) {
        List<Position> roundPos = new ArrayList<>();
        roundPos.add(new Position(pos.getX(), pos.getY() + 1));
        roundPos.add(new Position(pos.getX(), pos.getY() - 1));
        roundPos.add(new Position(pos.getX() + 1, pos.getY()));
        roundPos.add(new Position(pos.getX() - 1, pos.getY()));
        roundPos.add(new Position(pos.getX() + 1, pos.getY() + 1));
        roundPos.add(new Position(pos.getX() - 1, pos.getY() - 1));
        roundPos.add(new Position(pos.getX() + 1, pos.getY() - 1));
        roundPos.add(new Position(pos.getX() - 1, pos.getY() + 1));
        return 1;
    }
}
