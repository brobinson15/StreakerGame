package logic.Model;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class BackgroundItem {

    private ArrayList<WorldItem> backgrounds;

    public BackgroundItem() {
        backgrounds = new ArrayList<WorldItem>();
        WorldItem backgroundOne = new WorldItem();
        WorldItem backgroundTwo = new WorldItem();
        this.setBackground(backgroundOne, true);
        this.setBackground(backgroundTwo, false);
    }

    public void setBackground(WorldItem background, boolean first) {
        background.setImage(Paths.BACKGROUND_PATH);
        if (first) {
            background.setPosition(0, Constants.SCREEN_HEIGHT - background.getHeight());
        } else {
            background.setPosition(0, Constants.SCREEN_HEIGHT -(2 * background.getHeight()));
        }
        backgrounds.add(background);
    }

    public double getWidth() {
        return backgrounds.get(0).getWidth();
    }

    public double getHeight() {
        return backgrounds.get(0).getHeight();
    }

    public void loop() {
        if (backgrounds.get(0).getY() > Constants.SCREEN_HEIGHT) {
            backgrounds.get(0).setPosition(0, backgrounds.get(1).getY() - backgrounds.get(0).getHeight());
        }
        if (backgrounds.get(1).getY() > Constants.SCREEN_HEIGHT) {
            backgrounds.get(1).setPosition(0, backgrounds.get(0).getY() - backgrounds.get(1).getHeight());
        }
    }

    public void setBackgroundSpeed(GraphicsContext gc) {
        backgrounds.get(0).setSpeed(0, Constants.STARTING_SPEED);
        backgrounds.get(0).updateSpeed();
        backgrounds.get(0).render(gc);
        backgrounds.get(1).setSpeed(0, Constants.STARTING_SPEED);
        backgrounds.get(1).updateSpeed();
        backgrounds.get(1).render(gc);
    }
}