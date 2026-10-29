package de.ac.environment;

import de.ac.object.impl.Floor;
import lombok.Getter;
import lombok.Setter;

import static de.ac.core.DinoRun.glace;

@Getter
public class Level {
    @Setter
    private short speed;
    private final Floor[] floors;
    private int floorY;

    public Level()  {
        this.speed = 5;
        this.floors = new Floor[2];
        this.floorY = glace.getRenderer().getWindowHeight() - 100;

        var floor = new Floor();
        floor.getPosition().set(0, getFloorY());
        floors[0] = floor;

        var secondFloor = new Floor();
        secondFloor.getPosition().set(floor.getWidth(), getFloorY());
        floors[1] = secondFloor;
    }

    public void onUpdate() {
        for (int i = 0; i < 2; i++) {
            var floor = floors[i];
            if ((floor.getPosition().getX() + floor.getWidth()) < 0) {
                var other = floors[(floors.length / (i + 1)) - 1];
                floor.setInterpolatedRendering(false);
                floor.getPosition().set(other.getPosition().getX() + other.getWidth(), floor.getPosition().getY());
                floor.setInterpolatedRendering(true);
            }
            floor.getPosition().subtract(getSpeed(), 0);
        }
    }

}
