
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Enemy {
    
    private Rectangle hitbox;
    private Image image;
    private float xSpeed, ySpeed;
    private int health = 100;
    private int damage = 50;
    
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
    
    public boolean hit(Rectangle r){
        if(hitbox.intersects(r)) return true;
        else return false;
    }
    public void takeDamage(int i){
        health = health - i;
    }
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int i){
        health = i;
    }
    public static void setGameSize(int x, int y){
        GAME_WIDTH = x;
        GAME_HEIGHT = y;
    }
    
    
    public void move(float x,float y){
          
        xSpeed= (x - hitbox.getX());
        ySpeed= (y - hitbox.getY());
        
        float factor = (float) (.2 / Math.sqrt(xSpeed*xSpeed + ySpeed*ySpeed));
        xSpeed*=factor;
        ySpeed*=factor;
        
        hitbox.setX(hitbox.getX()+xSpeed);
        hitbox.setY(hitbox.getY()+ySpeed);
        
        
        
       
        
    }
    
    public void draw(){
        image.draw(hitbox.getX(), hitbox.getY());
        
    }
    
    public float getXPos(){
        return hitbox.getX();
    }
    public float getYPos(){
        return hitbox.getY();
    }
    

    
    


    
    
    
}
