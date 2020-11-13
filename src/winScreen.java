import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class winScreen extends BasicGameState {
        Image img;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       img = new Image("images/Win.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        if(in.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       img.draw(0,0);
    }
    
    public int getID() {
       return 4;  //this id will be different for each screen
    }

    
}