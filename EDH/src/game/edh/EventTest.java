package game.edh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.frame.BaseScreen;
import game.edh.frame.Shujinkou;
import game.edh.frame.TextAssets;
import game.edh.frame.TextLabel;

public class EventTest extends BaseScreen {
	Table table;
	Label back;
	EventTestGroup group;
	Image backImage;
	TextLabel label;
	
	int talkStart = 0;
	

	public EventTest(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		//Assets.loadEvent();
		Gdx.app.log("EventTest", "");
		TextAssets.loadTestText();
		
		group = new EventTestGroup(this);
		mainTable.addActor(group);
		
		back = new Label("BACK", Assets.title.get("black", LabelStyle.class));
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Title));
			}
		});
		
		backImage = new Image(Assets.event.getDrawable("eventback"));
		backImage.setBounds(0, 0, 432, 768);
		backImage.setTouchable(Touchable.disabled);
		
		table = new Table();
		table.setBackground(Assets.event.getDrawable("waku"));
		table.setBounds(0, 15, 432, 255);
		
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
					group.shujinkou.changeSprite(Shujinkou.MIOROSU);
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
		
	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
