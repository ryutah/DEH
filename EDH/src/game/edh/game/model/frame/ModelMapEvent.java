package game.edh.game.model.frame;

public abstract class ModelMapEvent {
	protected GameWorld world;
	protected Map map;
	
	public ModelMapEvent(GameWorld world, Map map) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		this.map = map;
	}
	
	public abstract void startMapEvent();
	
	public abstract void textEnd();
	
	protected void endMapEvent() {
		world.endMapEvent();
	}
}
