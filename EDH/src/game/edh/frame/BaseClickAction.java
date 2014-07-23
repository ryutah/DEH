package game.edh.frame;

import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public abstract class BaseClickAction extends ClickListener {
	Actor actor;

	public BaseClickAction(Actor actor) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.actor = actor;
	}

	@Override
	public void clicked(InputEvent event, float x, float y) {
		// TODO 自動生成されたメソッド・スタブ
		event.stop();
		EdhGame.music.playEffect(EfftctType.KETTEI, false);
		actor.addAction(sequence(color(Color.CYAN), delay(.5f),
				color(Color.BLACK)));
		
		clickAction();
	}
	
	public abstract void clickAction();
}
