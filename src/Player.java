
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Player {
    private Rectangle hitbox, attackhitbox;
    private Image front1;
    private int xSpeed, ySpeed;
    private double timer;
    private int health = 100;
    private int damage = 50; 
    
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    
    private boolean isCooldown;
    
    
    final int imgrows = 4;
    final int imgcols = 4;
    final int imgwidth = 48;
    final int imgheight = 48;
    
    ArrayList<Image> sprites;
    private Image bigImg;
    
    
    
    public Player() throws SlickException{
        bigImg = new Image("images/george.png");
        sprites = new ArrayList();
        for (int i = 0; i < imgrows; i++) {
            for (int j = 0; j < imgcols; j++) {
                sprites.add(bigImg.getSubImage(j*imgwidth, i*imgheight, imgwidth, imgheight));
                
            }
            
        }
        hitbox = new Rectangle(500,500,sprites.get(0).getWidth(),sprites.get(0).getHeight());
        
        attackhitbox = new Rectangle((int)hitbox.getX(),(int)hitbox.getY() + imgheight,imgwidth,10);
        
        
        
        
    }
    public Rectangle getAttackHitbox(){
        return attackhitbox;
    }
    public void takeDamage(int i){
        health = health - i;
    }
    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public void setCooldown(boolean b){
        isCooldown = b;
    }
    public boolean isCooldown(){
        return isCooldown;
    }
    public boolean hit(Rectangle r){
        if(attackhitbox.intersects(r)) return true;
        else return false;
    }
    public boolean hitwall(){
        if(hitbox.getX() <=0){
            hitbox.setX(hitbox.getX() + 1);
            
            return true;
        }
        else if(hitbox.getX() > GAME_WIDTH - sprites.get(0).getWidth()){
            hitbox.setX(hitbox.getX() -1);
            
            return true;
        }
        else if(hitbox.getY() <=0){
            hitbox.setY(hitbox.getY() + 1);
            return true;
        }    
        else if(hitbox.getY() > GAME_HEIGHT - sprites.get(0).getHeight()){
            hitbox.setY(hitbox.getY() - 1);
            return true;
        }
            
        
        else
            return false;
        
    }
    public static void setGameSize(int x, int y){
        GAME_WIDTH = x;
        GAME_HEIGHT = y;
    }
    public void draw(int i,int x){
        if(i==1){
            if(x<=5){
                sprites.get(0).draw(hitbox.getX(), hitbox.getY());
            }
            else if(x<=10){
                sprites.get(4).draw(hitbox.getX(),hitbox.getY());
          
            }
            else if(x<=15){
                sprites.get(8).draw(hitbox.getX(),hitbox.getY());
                
            }
            else if(x<=20){
                sprites.get(12).draw(hitbox.getX(),hitbox.getY());
            }
            else
                sprites.get(0).draw(hitbox.getX(),hitbox.getY());
          attackhitbox.setBounds(hitbox.getX(), hitbox.getY() + imgheight, imgwidth, 10);
                
        }
        else if(i==2){
            if(x<=5){
                sprites.get(2).draw(hitbox.getX(), hitbox.getY());
            }
            else if(x<=10){
                sprites.get(6).draw(hitbox.getX(),hitbox.getY());
          
            }
            else if(x<=15){
                sprites.get(10).draw(hitbox.getX(),hitbox.getY());
                
            }
            else if(x<=20){
                sprites.get(14).draw(hitbox.getX(),hitbox.getY());
            }
            else
                sprites.get(2).draw(hitbox.getX(),hitbox.getY());
            attackhitbox.setBounds(hitbox.getX(),hitbox.getY()-10,imgwidth, 10);
                
        }
        else if(i==3){
            if(x<=5){
                sprites.get(3).draw(hitbox.getX(), hitbox.getY());
            }
            else if(x<=10){
                sprites.get(7).draw(hitbox.getX(),hitbox.getY());
          
            }
            else if(x<=15){
                sprites.get(11).draw(hitbox.getX(),hitbox.getY());
                
            }
            else if(x<=20){
                sprites.get(15).draw(hitbox.getX(),hitbox.getY());
            }
            else
                sprites.get(3).draw(hitbox.getX(),hitbox.getY());
            attackhitbox.setBounds(hitbox.getX()+imgwidth,hitbox.getY(),10,imgheight);
                
        }
        else if(i==4){
            if(x<=5){
                sprites.get(1).draw(hitbox.getX(), hitbox.getY());
            }
            else if(x<=10){
                sprites.get(5).draw(hitbox.getX(),hitbox.getY());
          
            }
            else if(x<=15){
                sprites.get(9).draw(hitbox.getX(),hitbox.getY());
                
            }
            else if(x<=20){
                sprites.get(13).draw(hitbox.getX(),hitbox.getY());
            }
            else
                sprites.get(1).draw(hitbox.getX(),hitbox.getY());
            attackhitbox.setBounds(hitbox.getX()-10,hitbox.getY(),10,imgheight);
                
        }
        else{
            sprites.get(0).draw(hitbox.getX(),hitbox.getY());
        }
        
        
        
        
        
        
        
    }
    public void move(int i){
        
        if(i==1 ){
            hitbox.setY(hitbox.getY()+1);
        }
        if(i==2){
            hitbox.setY(hitbox.getY()-1);
        }
        if(i==3){
            hitbox.setX(hitbox.getX()+1);
        }
        if(i==4){
            hitbox.setX(hitbox.getX()-1);
        }
        if(i==5){
            hitbox.setX(hitbox.getX()+1);
            hitbox.setY(hitbox.getY()-1);
        }
        if(i==6){
            hitbox.setX(hitbox.getX()-1);
            hitbox.setY(hitbox.getY()-1);
        }
        if(i==7){
            hitbox.setX(hitbox.getX()+1);
            hitbox.setY(hitbox.getY()+1);
        }
        if(i==8){
            hitbox.setX(hitbox.getX()-1);
            hitbox.setY(hitbox.getY()+1);
        }
        
        
    }
    public float getXPos(){
        return hitbox.getX();
    }
    public float getYPos(){
        return hitbox.getY();
    }
    public void attack(int x, int y){
        
        
    }
    
}
