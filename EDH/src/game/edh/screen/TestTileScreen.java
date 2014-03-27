package game.edh.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.games.TestGameGroup;
import game.edh.frame.BaseScreen;

public class TestTileScreen extends BaseScreen {
	Image back;
	TestGameGroup test;
	Touchpad tpad;

	public TestTileScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		Assets.loadBatle();
		back = new Image(Assets.batle.getDrawable("batleback"));
		back.setBounds(0, 0, 432, 768);
		Texture pad = new Texture(Gdx.files.internal("TouchPad.png"));
		TextureRegion p = new TextureRegion(pad);
		TextureRegion k = new TextureRegion(new Texture(
				Gdx.files.internal("Key.png")), 35, 35);

		TouchpadStyle style = new TouchpadStyle();
		style.background = new TextureRegionDrawable(p);
		style.knob = new TextureRegionDrawable(k);

		tpad = new Touchpad(20, style);
		tpad.setPosition(30, 30);
		test = new TestGameGroup();
		mainTable.addActor(test);
		mainTable.addActor(back);
		mainTable.addActor(tpad);
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeScreen(new TitleScreen(edh, 432, 768));
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stage.act();
		test.move(tpad.getKnobPercentX(), tpad.getKnobPercentY(), delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
		//test.render.dispose();
	}
	
	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ
		super.dispose();
		test.render.dispose();
	}

}
