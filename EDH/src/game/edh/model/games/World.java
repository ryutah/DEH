package game.edh.model.games;

import game.edh.actors.games.GameGroup;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public abstract class World {
	public Array<GameObject> obj;
	public GamePlayer player;
	public GameGroup group;
	Rectangle[][] walls;
	public int[] nowItems;
	public int selectItem;
	
	public static final int NO_SELECT = -1;
	
	public World(GameGroup group) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		obj = new Array<GameObject>();
		nowItems = new int[6];
	}
	
	public World init() {
		for(int i = 0; i < obj.size; i++) {
			obj.get(i).init();
		}
		
		for(int i = 0; i < nowItems.length; i++) {
			nowItems[i] = -1;
		}
		
		selectItem = -1;
		return this;
	}
	
	public void playerMove(float x, float y, float delta) {
		Rectangle playerBounds = player.getBounds();
		player.move(x, y, delta);
		
		int moveX = (int) player.getX();
		if(moveX < 0) moveX = 0;
		int moveY = (int) player.getY();
		if(moveY < 0) moveY = 0;
		int moveX2 = (int) (moveX + player.width);
		if(moveX2 > 35) moveX2 = 35;
		int moveY2 = (int) (moveY + player.height);
		if(moveY2 > 27) moveY2 = 27;
		
		for(int i = moveX; i <= moveX2; i++) {
			for(int j = moveY; j <= moveY2; j++) {
				if(player.getBounds().overlaps(walls[i][j])) {
					player.setBounds(playerBounds);
					break;
				}
			}
		}
	}
	
	public void checkWorld() {
		Rectangle check = player.getBounds();
		for(int i = 0; i < obj.size; i++) {
			if(check.overlaps(obj.get(i).getBounds())) {
				obj.get(i).eventOcer();
				break;
			}
		}
	}
	
	public void textHandle(String ... texts) {
		group.textEvent(texts);
	}
	
	public void itemHandle(int itemId, String ... texts) {
		if(texts[0] != "") {
			textHandle(texts);
		}
		
		for(int i = 0; i < nowItems.length; i++) {
			if(nowItems[i] == -1) {
				nowItems[i] = itemId;
				break;
			}
		}
	}
	
	public void eventHandle(int eventsId) {
		
	}
	
	public int[] getItems() {
		return nowItems;
	}
	
	public void itemSelect(int itemNum) {
		if(itemNum == NO_SELECT) {
			selectItem = -1;
		} else {
			selectItem = nowItems[itemNum];
		}
	}
}
