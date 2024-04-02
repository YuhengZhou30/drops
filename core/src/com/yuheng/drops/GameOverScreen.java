package com.yuheng.drops;

import static com.yuheng.drops.GameScreen.dropsGathered;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {
    Texture backgroundTexture;
    final Drop game;

    OrthographicCamera camera;

    public GameOverScreen(final Drop game) {
        this.game = game;
        backgroundTexture = new Texture(Gdx.files.internal("gameover.png"));
        backgroundTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();
        game.batch.begin();
        game.font.draw(game.batch, "GAME OVER", 100, 150);
        game.font.draw(game.batch, "YOUR POINTS: "+dropsGathered, 100, 100);
        game.font.draw(game.batch, "Tap to restart", 100, 50);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            dropsGathered=0;
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
    }


}
