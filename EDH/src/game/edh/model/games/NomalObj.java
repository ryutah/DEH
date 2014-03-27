package game.edh.model.games;


public abstract class NomalObj extends GameObject {
	String[] texts;

	public NomalObj(float x, float y, float width, float height, World world) {
		super(x, y, width, height, world);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	public void eventOcer() {
		// TODO 自動生成されたメソッド・スタブ
		textEvent();
	}
	
	public void setText(String ... texts) {
		this.texts = texts;
	}
	
	public void textEvent() {
		world.textHandle(texts);
	}

}
