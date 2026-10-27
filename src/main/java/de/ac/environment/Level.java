package de.ac.environment;

import de.ac.core.DinoRun;
import de.ac.object.impl.Floor;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;
import java.util.List;

import static de.ac.core.DinoRun.glace;

@Getter
public class Level {
    @Setter
    private short speed;
    private final List<Floor> floorParts;

    public Level()  {
        this.speed = 4;
        this.floorParts = new LinkedList<>(List.of(createFloor(), createFloor()));

        assert glace.getRenderer().getFrame() != null
                : "Frame should be initialized before the constructor gets called";

        glace.getRenderer().getFrame().getContentPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int neededFloorParts = Math.max(2, (e.getComponent().getWidth() / floorParts.getFirst().getWidth()) + 1);
                if (neededFloorParts > floorParts.size()) {
                    for (int i = 0; i < neededFloorParts - floorParts.size(); i++) {
                        floorParts.add(createFloor());
                    }
                } else if (neededFloorParts < floorParts.size()) {
                    for (int i = 0; i < floorParts.size() - neededFloorParts; i++) {
                        var lastFloor = floorParts.getLast();
                        glace.getObjectManager().destroyObject(lastFloor);
                        floorParts.remove(lastFloor);
                    }
                }
            }
        });
    }

    public void onUpdate() {
        //Move floors
    }

    private Floor createFloor() {
        var floor = new Floor();
        glace.getObjectManager().addObject(floor);
        return floor;
    }
}
