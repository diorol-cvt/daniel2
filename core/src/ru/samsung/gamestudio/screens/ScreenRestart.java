package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Button;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.components.MovingBackground;

public class ScreenRestart implements Screen {
    private final MovingBackground background;
    private final Button buttonRestart;
    private final Button buttonExit;
    private final BitmapFont font;
    private final int lastScore;
    MyGdxGame myGdxGame;

    public ScreenRestart(MyGdxGame myGdxGame, int score) {
        this.myGdxGame = myGdxGame;
        this.lastScore = score;
        buttonRestart = new Button(867, 100, 300, 110, "RESTART");
        buttonExit = new Button(100, 100, 400, 110, "EXIT MENU");
        background = new MovingBackground("background/restart_bg.png");
        font = new BitmapFont();
        font.getData().setScale(6f);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (buttonRestart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.screenGame = new ScreenGame(myGdxGame);
                myGdxGame.setScreen(myGdxGame.screenGame);
                return;
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.menuScreen = new MenuScreen(myGdxGame);
                myGdxGame.setScreen(myGdxGame.menuScreen);
                return;
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonRestart.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        font.draw(myGdxGame.batch, "SCORE: " + lastScore, MyGdxGame.SCR_WIDTH / 2f - 167, MyGdxGame.SCR_HEIGHT - 150);
        myGdxGame.batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buttonRestart.dispose();
        buttonExit.dispose();
        font.dispose();
    }

    @Override public void show() {

    }
    @Override public void resize(int i, int i1) {

    }
    @Override public void pause() {

    }
    @Override public void resume() {

    }
    @Override public void hide() {

    }
}