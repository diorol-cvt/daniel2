package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Button;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.components.MovingBackground;

public class MenuScreen implements Screen {
    private final MovingBackground background;
    private final Button buttonStart;
    private final Button buttonExit;
    MyGdxGame myGdxGame;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        buttonStart = new Button(867, 400, 300, 120, "START");
        buttonExit = new Button(150, 400, 300, 120, "EXIT");
        background = new MovingBackground("background/restart_bg.png");
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 touch;
            touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (buttonStart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.screenGame = new ScreenGame(myGdxGame);
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)) {
                Gdx.app.exit();
            }
        }
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buttonStart.dispose();
        buttonExit.dispose();
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