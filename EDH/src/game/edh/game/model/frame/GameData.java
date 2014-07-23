package game.edh.game.model.frame;

public class GameData {
	public int stageNum = 0;
	public String mapName;
	public int[] items;
	public boolean flags[];
	public String flagName[];
	public float playerX, playerY;
	
	public void save(GameWorld world) {
		stageNum = world.getStageNum();
		mapName = world.getMap().getName();
		flags = world.getFlags().getFlags();
		flagName = world.getFlags().getFlagsName();
		items = world.getItems().getItemIds();
		playerX = world.getPlayer().getPosition().x;
		playerY = world.getPlayer().getPosition().y;
	}
}
