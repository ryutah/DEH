package game.edh.screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.TextLabel;
import game.edh.frame.BaseScreen;

public class TestScreen2 extends BaseScreen {
	TextLabel label;

	public TestScreen2(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		mainTable.setBackground(Assets.title.getDrawable("menuBack"));
		LabelStyle style = Assets.title.get("mikachan", LabelStyle.class);

		label = new TextLabel("", style);
		setText();

		mainTable.add(label);
		
		mainTable.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				if(label.isNextText())
					label.changeText();
				else {
					screenOff();
					edh.setNextScreen(new TitleScreen(edh, 432, 768));
					mainTable.removeListener(this);
				}
			}
		});
	}

	public void setText() {
		String s = "日本語でテキストを出力する\n"
				 + "テストです。"
				 + "\nタップで次のテキストに変わります";
		
		String t = "もし次のテキストが無い時は、タイ\n"
				 + "トル画面に戻るようになっています";
		
		String u = "このテキストの後にタイトル画面\n"
		 		 + "に戻ります。";
		
		label.setText(s, t, u);
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
