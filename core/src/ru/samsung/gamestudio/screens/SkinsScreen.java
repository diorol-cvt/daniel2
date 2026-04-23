package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.Button;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.characners.Bird;
import ru.samsung.gamestudio.components.MovingBackground;

public class SkinsScreen implements Screen {
    static Bird bird; // Сама птичка: ее координаты и размеры
    public static float n; // Скорость взмаха крыльев птички
    public static Texture[] frames;
    private final MovingBackground background;
    public static boolean stop = false;
    private Button buttonSkins1;
    private Button buttonSkins2;
    private Button buttonSkins3;
    Button titleSkins1;
    Button titleSkins2;
    Button titleSkins3;
    private final Button buttonExit;
    MyGdxGame myGdxGame;
    public SkinsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        buttonSkins1 = new Button(767, 200, 320, 110, "CHOOSE");
        buttonSkins2 = new Button(767, 355, 320, 110, "CHOOSE");
        buttonSkins3 = new Button(767, 510, 320, 110, "CHOOSE");
        titleSkins1 = new Button(200, 200, 320, 110, "SKIN #1");
        titleSkins2 = new Button(200, 355, 320, 110, "SKIN #2");
        titleSkins3 = new Button(200, 510, 320, 110, "SKIN #3");
        buttonExit = new Button(480, 50, 400, 110, "EXIT MENU");
        background = new MovingBackground("background/restart_bg.png");
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (buttonSkins1.isHit((int) touch.x, (int) touch.y)) {
                buttonSkins1 = new Button(767, 200, 320, 110, "SELECTED");
                buttonSkins2 = new Button(767, 355, 320, 110, "CHOOSE");
                buttonSkins3 = new Button(767, 510, 320, 110, "CHOOSE");
                frames = new Texture[]{
                        new Texture("rainbow_bird/rainbow_bird0.png"),
                        new Texture("rainbow_bird/rainbow_bird1.png"),
                        new Texture("rainbow_bird/rainbow_bird2.png"),
                        new Texture("rainbow_bird/rainbow_bird1.png"),
                };
                bird = new Bird(200, 300, 200, 144);
                n = 0.15F;
                stop = true;
            } else {
                if (buttonSkins2.isHit((int) touch.x, (int) touch.y)) {
                    buttonSkins1 = new Button(767, 200, 320, 110, "CHOOSE");
                    buttonSkins2 = new Button(767, 355, 320, 110, "SELECTED");
                    buttonSkins3 = new Button(767, 510, 320, 110, "CHOOSE");
                    frames = new Texture[]{
                            new Texture("bird/bird0.png"),
                            new Texture("bird/bird1.png"),
                            new Texture("bird/bird2.png"),
                            new Texture("bird/bird1.png"),
                    };
                    bird = new Bird(200, 300, 150, 90);
                    n = 0.67F;
                    stop = true;
                }else {
                    if (buttonSkins3.isHit((int) touch.x, (int) touch.y)) {
                        buttonSkins2 = new Button(767, 200, 320, 110, "CHOOSE");
                        buttonSkins1 = new Button(767, 355, 320, 110, "CHOOSE");
                        buttonSkins3 = new Button(767, 510, 320, 110, "SELECTED");
                        frames = new Texture[]{
                                new Texture("kolibri/kolibri0.png"),
                                new Texture("kolibri/kolibri1.png"),
                                new Texture("kolibri/kolibri2.png"),
                                new Texture("kolibri/kolibri1.png"),
                        };
                        bird = new Bird(200, 300, 100, 67);
                        n = 1;
                        stop = true;
                    }
                }
            }

            if (buttonExit.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.menuScreen = new MenuScreen(myGdxGame);
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonSkins1.draw(myGdxGame.batch);
        buttonSkins2.draw(myGdxGame.batch);
        buttonSkins3.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        titleSkins1.draw(myGdxGame.batch);
        titleSkins2.draw(myGdxGame.batch);
        titleSkins3.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buttonSkins1.dispose();
        buttonSkins2.dispose();
        buttonSkins3.dispose();
        titleSkins1.dispose();
        titleSkins2.dispose();
        titleSkins3.dispose();
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
