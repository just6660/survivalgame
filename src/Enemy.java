
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Enemy {
    
    private Rectangle hitbox;
    private Image image;
    private float xSpeed, ySpeed;
    
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    
    
    public Enemy(int x, int y) throws SlickException{
        //add image
        image = new Image("images/astroid.png");
        hitbox = new Rectangle(x,y,image.getWidth(),image.getHeight());
        
        
       
        
    }
    
    public Rectangle getHitBox(){
        return hitbox;
    }
    
    public boolean hit(int x, int y){
        if(hitbox.contains(x,y)) return true;
        else return false;
    }
    public static void setGameSize(int x, int y){
        GAME_WIDTH = x;
        GAME_HEIGHT = y;
    }
    
    
    public void move(){
        
        xSpeed= (100 - hitbox.getX());
        ySpeed= (100 - hitbox.getY());
        
        float factor = (float) (1 / Math.sqrt(xSpeed*xSpeed + ySpeed*ySpeed));
        xSpeed*=factor;
        ySpeed*=factor;
        
        hitbox.setX(hitbox.getX()+xSpeed);
        hitbox.setY(hitbox.getY()+ySpeed);
        
        
        
       
        
    }
    
    public void draw(){
        image.draw(hitbox.getX(), hitbox.getY());
    }

    
    


    
    
    
}
