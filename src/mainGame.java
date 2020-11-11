
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

    ArrayList<Enemy> enemies;
    Player p;

    int timer;

    int timer2 = 0;
    
    int timer3 = 0;
    int count = 0;
    int wave = 0;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        enemies = new ArrayList();
        p = new Player();

        timer = 0;
        Enemy.setGameSize(1680, 1050);
        Player.setGameSize(1680, 1050);

        for (int i = 0; i < 1; i++) {
            int rx = (int) (Math.random() * (1680 - 1550) + 1550);
            int ry = (int) (Math.random() * (100 - 0) + 0);
            enemies.add(new Enemy(rx, ry));
        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();

        for (Enemy a : enemies) {
            a.move(p.getXPos(), p.getYPos());
        }
        
        
            
        if(enemies.size()>0){
            for(Enemy a: enemies){
                if(in.isKeyDown(Input.KEY_SPACE) && p.hit(a.getHitBox()) && p.isCooldown() == false){
                    
                    a.takeDamage(p.getDamage());
                    if(a.getHealth()==0){
                        enemies.remove(a);
                    }
                    p.setCooldown(true);
                    break;
                }
            }
        }
        if(in.isKeyDown(Input.KEY_SPACE))
            p.setCooldown(true);
        

        if (timer2 >= 20) {
            timer2 = 0;
        }
        timer3++;
        if(timer3 >= 200){
            timer3=0;
            p.setCooldown(false);
        }
        
        if (in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                timer2++;
                count = 2;
                p.move(5);
            }

        } else if (in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                timer2++;
                count = 2;
                p.move(6);
            }
        } else if (in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                timer2++;
                count = 1;
                p.move(7);
            }
        } else if (in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                timer2++;
                count = 1;
                p.move(8);
            }
        } else if (in.isKeyDown(Input.KEY_S)) {
            if (!p.hitwall()) {
                timer2++;
                count = 1;
                p.move(count);
            }
        } else if (in.isKeyDown(Input.KEY_W)) {
            if (!p.hitwall()) {
                timer2++;
                count = 2;
                p.move(count);
            }

        } else if (in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                timer2++;
                count = 3;
                p.move(count);
            }
        } else if (in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                timer2++;
                count = 4;
                p.move(count);
            }
        } else {
            timer2 = 0;
        }
       
        


    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("This is the main game", 100, 200);

        for (Enemy a : enemies) {
            a.draw();
        }
        if(p.isCooldown() == true){
            g.setColor(Color.red);
            g.fill(p.getAttackHitbox());
        }
        if(p.isCooldown() == false){
            g.setColor(Color.green);
            g.fill(p.getAttackHitbox());
        }
        p.draw(count, timer2);

    }

    public int getID() {
        return 1;  //this id will be different for each screen
    }

}
