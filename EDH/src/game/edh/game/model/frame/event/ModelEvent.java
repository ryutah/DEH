package game.edh.game.model.frame.event;

import game.edh.game.actor.ActorEvent;
import game.edh.game.model.frame.GameWorld;

import com.badlogic.gdx.utils.Array;

public class ModelEvent {
	public enum ObjType {
		Button, Image
	}

	protected GameWorld world;
	ActorEvent listener;
	Array<ModelEventObj> objs;

	public ModelEvent(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		objs = new Array<ModelEventObj>();
	}

	public void addObjs(ModelEventObj obj) {
		objs.add(obj);
	}

	public void startEvent() {

	}

	public void endEvent() {

	}

	public void addListener(ActorEvent listener) {
		this.listener = listener;
	}

	public GameWorld getWorld() {
		return world;
	}

	public Array<ModelEventObj> getObjs() {
		return objs;
	}
}
