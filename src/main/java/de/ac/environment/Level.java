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
        this.floorParts = new LinkedList<>();

        assert glace.getRenderer().getFrame() != null
                : "Frame should be initialized before the constructor gets called";

        addFloor();
        addFloor();

        glace.getRenderer().getFrame().getContentPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int neededFloorParts = Math.max(2, (e.getComponent().getWidth() / floorParts.getFirst().getWidth()) + 1);
                if (neededFloorParts > floorParts.size()) {
                    for (int i = 0; i < neededFloorParts - floorParts.size(); i++) {
                        addFloor();
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
        for (int i = 0; i < floorParts.size(); i++) {

            var floor = floorParts.get(i);

            if ((floor.getPosition().getX() - floor.getWidth()) < 0) {
                var last = floorParts.getLast();

                floor.setInterpolatedRendering(false);
                floor.getPosition().set(last.getWidth(), floor.getPosition().getY());
                floor.setInterpolatedRendering(true);

                floorParts.remove(i);
                floorParts.addLast(floor);

            }
            //Move every floor
            floor.getPosition().subtract(5, 0);
        }
    }

    private void addFloor() {
        var floor = new Floor();
        glace.getObjectManager().addObject(floor);
        double newX = floorParts.isEmpty()
                ? 0
                : floorParts.getLast().getWidth() + floorParts.getLast().getPosition().getX();
        floor.getPosition().set(newX, 10);
        floorParts.add(floor);
    }

}
