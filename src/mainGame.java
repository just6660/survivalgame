import java.awt.Button;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class mainGame extends BasicGameState {
    
    ArrayList<Enemy>enemies;
    Player p;
   
    
    int timer;
    
    int timer2 = 0;
    int count = 0;
    
    

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        enemies = new ArrayList();
        p = new Player();
 
        timer = 0;
        Enemy.setGameSize(1980,1080);
        
        for(int i = 0; i < 10; i++){
            int rx = (int)(Math.random()*(1680-1550) + 1550);
            int ry = (int)(Math.random()*(100-0)+0);
            enemies.add(new Enemy(rx,ry));
        }
        
        
        
        
        
        
        
        
        
        

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        
        for(Enemy a : enemies){
            a.move();
        }
        
        if(timer2 >=20){
            timer2=0;
        }
        if(in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_D)){
            timer2++;
            count = 2;
            p.move(5);
        }
        else if(in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_A)){
            timer2++;
            count = 2;
            p.move(6);
        }
        else if(in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_D)){
            timer2++;
            count = 1;
            p.move(7);
        }
        else if(in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_A)){
            timer2++;
            count = 1;
            p.move(8);
        }
        else if(in.isKeyDown(Input.KEY_S)){
            timer2++;
            count = 1;
            p.move(count);
        }
        
        else if(in.isKeyDown(Input.KEY_W)){
            timer2++;
            count = 2;
            p.move(count);
            
        }
        else if(in.isKeyDown(Input.KEY_D)){
            timer2++;
            count = 3;
            p.move(count);
        }
        else if(in.isKeyDown(Input.KEY_A)){
            timer2++;
            count = 4;
            p.move(count);
        }
        else{
            timer2 = 0;
        }
            
        
            
        
        

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("This is the main game", 100, 200);
        
        for(Enemy a : enemies){
            a.draw();
        }
        p.draw(count,timer2);
        
        
        
        
        
        
        
        
        
     
       
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}
