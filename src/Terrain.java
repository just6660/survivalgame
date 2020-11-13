
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

public class Terrain {

    private SpriteSheet grass;
    private boolean roadOn;
    private ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();

    public Terrain() throws SlickException {
        grass = new SpriteSheet("images/grass.png", 32, 32);
        barriers.add(new Rectangle(0,384,384,32));
        barriers.add(new Rectangle(672,384,64,32));
        barriers.add(new Rectangle(960,0,32,192));
        barriers.add(new Rectangle(352,640,96,32));
        barriers.add(new Rectangle(1280,416,32,640));
    }

    public void draw() {
        grass.startUse();

        Image lawn = grass.getSprite(0, 0);
        Image path = grass.getSprite(1, 2);
        Image stone = grass.getSprite(6, 5);

        for (int x = 0; x < 1680; x += 32) {
            for (int y = 0; y < 384; y += 32) {
                if (x == 960 && y <=160) {
                    stone.draw(x, y);
                } else {

                    lawn.draw(x, y);
                }
            }

        }
        for (int x = 0; x < 1680; x += 32) {
            for (int y = 384; y < 416; y += 32) {
                if (x < 384 || x > 640 && x < 736) {
                    stone.draw(x, y);
                } else {
                    lawn.draw(x, y);
                }
            }
        }
        for (int x = 0; x < 1680; x += 32) {
            for (int y = 416; y < 1050; y += 32) {
                if (x == 1280 || y == 640 && x > 320 && x < 448) {
                    stone.draw(x, y);
                } else {
                    lawn.draw(x, y);
                }
            }
        }
        

        grass.endUse();
    }
    public void drawGrid(Graphics g){
        g.setColor(new Color(200,200,200));
        TrueTypeFont ttf = new TrueTypeFont(new java.awt.Font("Arial",0,10),true);
        for (int i = 0; i < 32*52; i+=32) {
            for (int j = 0; j < 32*32; j+=32) {
                Rectangle box = new Rectangle(i,j,32,32);
                g.draw(box);
                ttf.drawString(i+3,j+3,""+i,Color.white);
                ttf.drawString(i+3,j+12,""+j,Color.white);
            }
            
        }
        g.setColor(Color.red);
        for(Rectangle barrier: barriers){
            g.draw(barrier);
        }
    }
    public ArrayList<Rectangle> getBarrier(){
        return barriers;
        
    }

}
