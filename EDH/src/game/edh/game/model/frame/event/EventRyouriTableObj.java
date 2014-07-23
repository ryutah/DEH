package game.edh.game.model.frame.event;

import game.edh.Assets;
import game.edh.game.model.frame.event.ModelEvent.ObjType;

public class EventRyouriTableObj extends ModelEventObj {
	int id;
	String name;
	
	public EventRyouriTableObj(EventRyouri parent) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(parent, ObjType.Image);
	}
	
	public void setParam(int id, String name, String drawableName) {
		this.id = id;
		this.name = name;
		setDrawable(Assets.games, drawableName);
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	protected void action(float x, float y) {
		// TODO 自動生成されたメソッド・スタブ
		((EventRyouri) parent).inShokuzai(this);
	}
}
