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
    private final Button buttonSkins;
    private final Button buttonStart;
    private final Button buttonExit;
    private Button buttonStop;
    MyGdxGame myGdxGame;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        buttonStop = new Button(200, 400, 900, 120, "SELECT A SKIN TO CONTINUE");
        buttonSkins = new Button(500, 167, 300, 120, "SKINS");
        buttonStart = new Button(867, 167, 300, 120, "START");
        buttonExit = new Button(150, 167, 300, 120, "EXIT");
        background = new MovingBackground("background/restart_bg.png");
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 touch;
            touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (SkinsScreen.stop) {
                buttonStop = new Button(0, 0, 0, 0, "");
            }
            if (buttonStart.isHit((int) touch.x, (int) touch.y)) {
                if (!SkinsScreen.stop) {
                    System.out.println("SELECT A SKIN TO CONTINUE");
                } else {
                    myGdxGame.screenGame = new ScreenGame(myGdxGame);
                    myGdxGame.setScreen(myGdxGame.screenGame);
                }
            }
            if (buttonExit.isHit((int) touch.x, (int) touch.y)) {
                Gdx.app.exit();
            }
            if (buttonSkins.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.skinScreen = new SkinsScreen(myGdxGame);
                myGdxGame.setScreen(myGdxGame.skinScreen);
            }
        }
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        buttonSkins.draw(myGdxGame.batch);
        buttonStop.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buttonStart.dispose();
        buttonExit.dispose();
        buttonSkins.dispose();
        buttonStop.dispose();
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