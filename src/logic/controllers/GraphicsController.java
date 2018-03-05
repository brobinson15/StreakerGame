package logic.controllers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import logic.configuration.Constants;
import logic.models.AnimatedItem;
import logic.models.BackgroundItem;
import logic.models.WorldItem;

import java.util.concurrent.TimeUnit;

public class GraphicsController {

    private GraphicsContext gc;

    public GraphicsController(GraphicsContext gc){
        this.gc = gc;
        //gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Serif", 20));
    }
    
    /* this is the preferred call with which to render objects to screen -
     * please use this method when making draw calls instead of 
     * the now deprecated WorldItem.render(gc)
     */
    public void drawItem(WorldItem w) {
    	gc.drawImage(w.getImage(), w.getX(), w.getY());
    }
    
    // this call for use with animatedItems such as guards and the streaker
    public void drawItem(AnimatedItem a, double time) {
    	gc.drawImage(a.getFrame(time), a.getX(), a.getY());
    }
    
    // for use with backgrounditem
    public void drawItem(BackgroundItem b) {
    	drawItem(b.getSection(0));
    	drawItem(b.getSection(1));
    }
    
    public String getHMS(double nanot) {
    	String hms = String.format("%02d:%02d:%02d ", TimeUnit.NANOSECONDS.toHours((long)nanot),
                TimeUnit.NANOSECONDS.toMinutes((long)nanot) - TimeUnit.HOURS.toMinutes(TimeUnit.NANOSECONDS.toHours((long)nanot)),
                TimeUnit.NANOSECONDS.toSeconds((long)nanot) - TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes((long)nanot)));

    	return hms;
    }

    public void showTime(double nanot) {
        
        gc.fillText(getHMS(nanot),  Constants.SCREEN_WIDTH - 150, 40);
    }
    
    public void showCoins(double width, int collected) {
        String coinStr = "ButtCoin: $" + collected;
        gc.fillText(coinStr, width - 150, 70);
    }
    
    public void drawHealth(double charHealth) {
    	double healthWidth = (Constants.HEALTHBAR_W * (charHealth / Constants.CHAR_MAX_HEALTH));
    	gc.fillText("Health:", 10, 34);
    	
    	gc.setFill(Color.BLACK);
    	gc.fillRect(94, 10, Constants.HEALTHBAR_W + 4, Constants.HEALTHBAR_H + 4);
    	
    	gc.setFill(Color.RED);
    	gc.fillRect(96, 12, Constants.HEALTHBAR_W, Constants.HEALTHBAR_H);
    	
    	gc.setFill(Color.GREEN);
    	gc.fillRect(96, 12, (int)healthWidth, Constants.HEALTHBAR_H);
    	
    	//resets fill color
    	gc.setFill(Color.WHITE);
    } 
}
