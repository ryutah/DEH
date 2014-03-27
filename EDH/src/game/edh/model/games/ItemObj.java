package game.edh.model.games;


public abstract class ItemObj extends GameObject {
	int itemId;
	String[] beforTexts;
	String[] afterTexts;

	public ItemObj(float x, float y, float width, float height, World world) {
		super(x, y, width, height, world);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public void setId(int id) {
		this.itemId = id;
	}
	
	@Override
	public void eventOcer() {
		// TODO 自動生成されたメソッド・スタブ
		if(state == NOT_CLEAR)
			itemEvent();
		else
			textEvent();
	}
	
	private void itemEvent() {
		world.itemHandle(itemId, beforTexts);
		changeState(CLEAR);
	}
	
	private void textEvent() {
		world.textHandle(afterTexts);
	}
}
