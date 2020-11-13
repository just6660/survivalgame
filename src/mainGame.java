
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
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class mainGame extends BasicGameState {

    ArrayList<Enemy> enemies;
    Player p;
    Terrain map;

    int timer;

    int wave = 1;

    
    boolean newwave = true;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        enemies = new ArrayList();
        p = new Player();
        map = new Terrain();

        timer = 0;
        Enemy.setGameSize(1680, 1050);
        Player.setGameSize(1680, 1050);

        for (int x = 0; x < 3; x++) {
            int z = (int) (Math.random() * 2 + 1);
            if (z == 1) {
                int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                int ry = (int) (Math.random() * (100 - 0) + 0);
                enemies.add(new Enemy(rx, ry));
            } else if (z == 2) {
                int rx = (int) (Math.random() * (100 - 0) + 0);
                int ry = (int) (Math.random() * (100 - 0) + 0);
                enemies.add(new Enemy(rx, ry));
            }

        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();
        if(in.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }

        if (p.getHealth() <= 0) {
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }

        if (enemies.size() == 0) {
            newwave = true;
            wave++;
            if (wave == 1) {
                for (int x = 0; x < 3; x++) {
                    int z = (int) (Math.random() * 2 + 1);
                    if (z == 1) {
                        int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    } else if (z == 2) {
                        int rx = (int) (Math.random() * (100 - 0) + 0);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    }

                }

            } else if (wave == 2) {
                for (int x = 0; x < 4; x++) {
                    int z = (int) (Math.random() * 2 + 1);
                    if (z == 1) {
                        int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    } else if (z == 2) {
                        int rx = (int) (Math.random() * (100 - 0) + 0);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    }

                }
            } else if (wave == 3) {
                for (int x = 0; x < 5; x++) {
                    int z = (int) (Math.random() * 2 + 1);
                    if (z == 1) {
                        int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    } else if (z == 2) {
                        int rx = (int) (Math.random() * (100 - 0) + 0);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    }

                }
            } else if (wave == 4) {
                for (int x = 0; x < 2; x++) {
                    int z = (int) (Math.random() * 2 + 1);
                    if (z == 1) {
                        int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    } else if (z == 2) {
                        int rx = (int) (Math.random() * (100 - 0) + 0);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    }

                }
            } else if (wave == 5) {
                for (int x = 0; x < 1; x++) {
                    int z = (int) (Math.random() * 2 + 1);
                    if (z == 1) {
                        int rx = (int) (Math.random() * (1680 - 1550) + 1550);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    } else if (z == 2) {
                        int rx = (int) (Math.random() * (100 - 0) + 0);
                        int ry = (int) (Math.random() * (100 - 0) + 0);
                        enemies.add(new Enemy(rx, ry));
                    }

                }
            } else {
                sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
            }

        }
        if (wave == 1 && newwave) {
            for (Enemy a : enemies) {
                a.setDamage(10);
                a.setHealth(50);
                a.setMaxHealth(50);
                p.setHealth(500);
                p.setDamage(50);
            }
            newwave = false;
        }
        if (wave == 2 && newwave) {
            for (Enemy a : enemies) {
                a.setDamage(30);
                a.setHealth(100);
                a.setMaxHealth(100);
                p.setHealth(500);

            }
            newwave = false;
        }
        if (wave == 3 && newwave) {
            for (Enemy a : enemies) {
                a.setDamage(50);
                a.setHealth(150);
                a.setMaxHealth(150);
                p.setHealth(500);
            }
            newwave = false;
        }
        if (wave == 4 && newwave) {
            for (Enemy a : enemies) {
                a.setHealth(300);
                a.setMaxHealth(300);
                p.setHealth(500);
            }
            newwave = false;
        }
        if (wave == 5 && newwave) {
            for (Enemy a : enemies) {
                p.setHealth(500);
                a.setHealth(1000);
                a.setMaxHealth(1000);
                a.setDamage(100);
            }
            newwave = false;
        }

        for (Enemy a : enemies) {
            if (a.isMovePause() == false) {
                a.move(p.getXPos(), p.getYPos(),map.getBarrier());
            }
        }

        if (enemies.size() > 0) {
            for (Enemy a : enemies) {
                if (in.isKeyDown(Input.KEY_SPACE) && p.isCooldown() == false) {
                    if (p.getPlayerCount() == 1) {
                        p.setPlayerCount(5);
                    } else if (p.getPlayerCount() == 2) {
                        p.setPlayerCount(6);
                    } else if (p.getPlayerCount() == 3) {
                        p.setPlayerCount(7);
                    } else if (p.getPlayerCount() == 4) {
                        p.setPlayerCount(8);
                    }
                }

                if (in.isKeyDown(Input.KEY_SPACE) && p.hit(a.getHitBox()) && p.isCooldown() == false) {

                    a.takeDamage(p.getDamage());
                    if (a.getHealth() == 0) {
                        enemies.remove(a);
                    }
                    p.setCooldown(true);
                    break;
                }
            }
        }
        if (in.isKeyDown(Input.KEY_SPACE)) {
            p.setCooldown(true);
        }

        for (Enemy a : enemies) {

            if (a.hit(p.getHitBox()) && a.isCooldown() == false && a.isMovePause() == false) {
                a.setMovePause(true);
                a.setAttackDelay(true);

            }
        }

        if (p.getPlayerMoveTimer() >= 20) {
            p.setPlayerMoveTimer(0);
        }
        if (p.getPlayerAttackAnimationTimer() >= 20) {
            p.setPlayerAttackAnimationTimer(0);
        }
        for (Enemy a : enemies) {
            if (a.getEnemyMoveTimer() >= 20) {
                a.setEnemyMoveTimer(0);
            }
        }
        for (Enemy a : enemies) {
            if (a.getEnemyHitTimer() >= 20) {
                a.setEnemyHitTimer(0);

            }
        }

        for (Enemy a : enemies) {
            a.setEnemyAttackTimer(a.getEnemyAttackTimer() + 1);
            if (a.getEnemyAttackTimer() > 50) {
                a.setEnemyAttackTimer(0);
                a.setAttackDelay(false);
                a.setMovePause(false);
            }
        }

        for (Enemy a : enemies) {
            if (a.hit(p.getHitBox()) && a.isAttackDelay() == false && a.isCooldown() == false) {
                if (a.getEnemyCount() == 1) {

                    a.setEnemyCount(5);
                } else if (a.getEnemyCount() == 2) {
                    a.setEnemyCount(6);
                } else if (a.getEnemyCount() == 3) {
                    a.setEnemyCount(7);
                } else if (a.getEnemyCount() == 4) {
                    a.setEnemyCount(8);
                }

                p.takeDamage(a.getDamage());

                a.setCooldown(true);

            }
        }

        for (Enemy a : enemies) {
            if (a.isCooldown() == true) {
                a.setEnemyTimer(a.getEnemyTimer() + 1);
                if (a.getEnemyTimer() >= 600) {
                    a.setEnemyTimer(0);
                    a.setCooldown(false);

                }
            }
        }
        p.setPlayerHitTimer(p.getPlayerHitTimer() + 1);
        if (p.getPlayerHitTimer() >= 200) {
            p.setPlayerHitTimer(0);
            p.setCooldown(false);
        }

        //player movements
        if (in.isKeyDown(Input.KEY_SPACE)) {
            if (!p.hitwall()) {
                p.setPlayerAttackAnimationTimer(p.getPlayerAttackAnimationTimer() + 1);

            }
        } else if (in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(2);
                p.move(5,map.getBarrier());
            }

        } else if (in.isKeyDown(Input.KEY_W) && in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(2);
                p.move(6,map.getBarrier());
            }
        } else if (in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(1);
                p.move(7,map.getBarrier());
            }
        } else if (in.isKeyDown(Input.KEY_S) && in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(1);
                p.move(8,map.getBarrier());
            }
        } else if (in.isKeyDown(Input.KEY_S)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(1);
                p.move(p.getPlayerCount(),map.getBarrier());
            }
        } else if (in.isKeyDown(Input.KEY_W)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(2);
                p.move(p.getPlayerCount(),map.getBarrier());
            }

        } else if (in.isKeyDown(Input.KEY_D)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(3);
                p.move(p.getPlayerCount(),map.getBarrier());
            }
        } else if (in.isKeyDown(Input.KEY_A)) {
            if (!p.hitwall()) {
                p.setPlayerMoveTimer(p.getPlayerMoveTimer() + 1);
                p.setPlayerCount(4);
                p.move(p.getPlayerCount(),map.getBarrier());
            }
        }
        
        //enemy movments
        for (Enemy a : enemies) {

            if (a.hit(p.getHitBox())) {
                a.setEnemyHitTimer(a.getEnemyHitTimer() + 1);
            } else if (!a.hitwall() && !a.isHitting(map.getBarrier()) && a.getYSpeed() < 0 && Math.abs(a.getYSpeed()) > Math.abs(a.getXSpeed()) && a.isMovePause() == false) {
                a.setEnemyMoveTimer(a.getEnemyMoveTimer() + 1);
                a.setEnemyCount(4);
            } else if (!a.hitwall() && !a.isHitting(map.getBarrier()) && a.getYSpeed() > 0 && Math.abs(a.getYSpeed()) > Math.abs(a.getXSpeed()) && a.isMovePause() == false) {
                a.setEnemyMoveTimer(a.getEnemyMoveTimer() + 1);
                a.setEnemyCount(1);
            } else if (!a.hitwall() && !a.isHitting(map.getBarrier()) && a.getXSpeed() < 0 && a.isMovePause() == false) {
                a.setEnemyMoveTimer(a.getEnemyMoveTimer() + 1);
                a.setEnemyCount(2);
            } else if (!a.hitwall() && !a.isHitting(map.getBarrier()) && a.getXSpeed() > 0 && a.isMovePause() == false) {
                a.setEnemyMoveTimer(a.getEnemyMoveTimer() + 1);
                a.setEnemyCount(3);
            }

        }

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.draw();
      

        for (Enemy a : enemies) {
            a.draw(a.getEnemyCount(), a.getEnemyMoveTimer(), a.getEnemyHitTimer());
            if (a.isCooldown() == true) {
                g.setColor(Color.yellow);
                g.fill(a.getAttackCDBox());
            }
            if (a.isCooldown() == false) {
                g.setColor(Color.blue);
                g.fill(a.getAttackCDBox());
            }
        }

        if (p.isCooldown() == true) {
            g.setColor(Color.yellow);
            g.fill(p.getAttackCDbox());
        }
        if (p.isCooldown() == false) {
            g.setColor(Color.blue);
        g.fill(p.getAttackCDbox());
        }
        p.draw(p.getPlayerCount(), p.getPlayerMoveTimer(), p.getPlayerAttackAnimationTimer());
        g.setColor(Color.red);
        g.fill(p.getRedHPBox());   
        for(Enemy a: enemies){
            g.fill(a.getRedHpBox());
        }
        g.setColor(Color.green);
        g.fill(p.getHPBox());
        for(Enemy a: enemies){
            g.fill(a.getHPBox());
        }

    }

    public int getID() {
        return 2;  //this id will be different for each screen
    }

}
