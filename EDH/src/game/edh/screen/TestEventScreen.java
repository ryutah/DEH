package game.edh.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.TextAssets;
import game.edh.actors.TextLabel;
import game.edh.actors.event.TestEventGroup;
import game.edh.actors.event.TestShujinkou;
import game.edh.frame.BaseScreen;

public class TestEventScreen extends BaseScreen {
	Table table;
	Label back;
	TestEventGroup group;
	Image backImage;
	Image serifu;
	TextLabel label;
	
	int talkStart = 0;
	

	public TestEventScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		//Assets.loadEvent();
		Gdx.app.log("EventTest", "");
		TextAssets.loadTestText();
		
		group = new TestEventGroup(this);
		mainTable.addActor(group);
		
		back = new Label("BACK", Assets.title.get("black", LabelStyle.class));
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Title));
			}
		});
		
		TextureRegion image = Assets.event.getRegion("eventback");
		backImage = new Image(image);
		backImage.setBounds(0, 0, 432, 768);
		backImage.setTouchable(Touchable.disabled);
		
		table = new Table();
		table.setBounds(0, 15, 432, 255);
		
		TextureRegion serifuimage = Assets.event.getRegion("waku");
		serifu = new Image(serifuimage);
		serifu.setBounds(0, 5, 432, 255);
		table.addActor(serifu);
		
		label = new TextLabel("", Assets.title.get("mikachan", LabelStyle.class));
		table.add(label).minWidth(table.getWidth() - 50f).minHeight(table.getHeight() - 50f).fill();
		
		table.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				if(!group.talking || !label.canCange)
					return;
				
				label.changeText();
				if(label.getTextNumber() == 3)
					group.shujinkou.changeSprite(TestShujinkou.MIOROSU);
				if(!label.isNextText())
					changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Title));
			}
		});
		
		mainTable.addActor(backImage);
		mainTable.addActor(table);
		mainTable.top().add(back);
		
		setMusic(Assets.YUUGURE);
	}
	
	public void setText() {
		label.setText(TextAssets.test);
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(group.talking) {
			if(talkStart == 0) {
				label.setText(TextAssets.test);
				talkStart++;
			}
		}
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
		super.hide();
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
		super.dispose();
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeScreen(new TitleScreen(edh, 432, 768));
	}
}
