package game.edh.model.games;


public abstract class EventObj extends GameObject {
	private int eventId;
	String[] texts;

	public EventObj(float x, float y, float width, float height, World world) {
		super(x, y, width, height, world);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public void setId(int eventId) {
		this.eventId = eventId;
	}
	
	@Override
	public void eventOcer() {
		// TODO 自動生成されたメソッド・スタブ
		if(state == NOT_CLEAR)
			events();
		else
			textsEvent();
	}
	
	private void events() {
		world.eventHandle(eventId);
		changeState(CLEAR);
	}
	
	private void textsEvent() {
		world.textHandle(texts);
	}
}