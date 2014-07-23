package game.edh.event.actor;

import game.edh.Assets;
import game.edh.event.model.EventWorld;
import game.edh.event.model.Texts;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class TextActor extends Label {
	Texts texts;
	
	public TextActor(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		super("", Assets.title, "mikachan");
		setWrap(true);
		setAlignment(Align.left);
		setColor(Color.BLACK);
		
		this.texts = world.getTextModel();
	}
	
	public void changeWorld(EventWorld world) {
		this.texts = world.getTextModel();
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		setText(texts.getText());
	}
}
