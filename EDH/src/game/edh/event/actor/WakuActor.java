package game.edh.event.actor;

import game.edh.Assets;
import game.edh.event.model.EventWorld;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class WakuActor extends Table {
	TextActor text;
	
	public WakuActor(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 20, 432, 255);
		setBackground(Assets.title.getDrawable("waku"));

		text = new TextActor(world);
		add(text).padLeft(15).padTop(20).width(getWidth() - 70)
				.height(getHeight() - 50).fill();
	}
	
	public void changeWorld(EventWorld world) {
		text.changeWorld(world);
	}
}
