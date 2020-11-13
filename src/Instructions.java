import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Instructions extends BasicGameState {

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        if(in.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
            
        }
        if(in.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Instructions",750,50);
        g.drawString("You are stuck in a dungeon and must fight waves of enemies. There will be 5 waves, each with increasing difficulty.",100,200);
        g.drawString("You will move around with WASD and attack with SPACE. Above your and your enemies heads, there will be a green bar indicating health.",100,400);
        g.drawString("Below you and your enemies, there is a small square that turns blue when you can attack, and yellow when your attack is on cooldown.",100,600);
        g.drawString("The enemies have longer attack cooldowns and have a short delay before they can hit you.", 100,800);
        g.drawString("Left Click to Continue : Press ESC At Any Time To Quit", 500, 1000);
       
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}