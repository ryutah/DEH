package game.edh.screen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.event.TestGroup;
import game.edh.frame.BaseScreen;

public class TestScreen3 extends BaseScreen {
	Image image;
	Label back;
	Label move;
	TestGroup group;

	public TestScreen3(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		group = new TestGroup();
		mainTable.addActor(group);
		
		TextureRegion region = Assets.title.getRegion("helplogo");
		image = new Image(region);
		image.setBounds(0, 600, region.getRegionWidth(),
				region.getRegionHeight());
		mainTable.addActor(image);

		move = new Label("MOVE", Assets.title.get("black", LabelStyle.class));
		move.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				group.setMove();
			}
		});
		
		back = new Label("BACK", Assets.title.get("black", LabelStyle.class));
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				back.setStyle(Assets.title.get("cyan", LabelStyle.class));
				changeScreen(new TitleScreen(edh, 432, 768));
			}
		});
		mainTable.bottom().add(move);
		mainTable.add(back);
		
		setMusic(Assets.YUUGURE);
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void hide() {
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
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
