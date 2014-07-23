package game.edh.game.model.frame;

import game.edh.game.actor.ActorItemPanel;
import game.edh.game.model.items.Items;
import game.edh.game.model.items.ItemsHandler;

import com.badlogic.gdx.utils.Array;

public class ModelItems {
	Array<Items> items;

	GameWorld world;
	ActorItemPanel listner;

	public ModelItems(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		items = new Array<Items>();
		this.world = world;
	}

	public void setListner(ActorItemPanel listner) {
		this.listner = listner;
	}

	public void addItem(int itemId) {
		Items item = ItemsHandler.getItem(itemId);
		items.add(item);
		listner.addItem(item);
	}

	public void removeItem(int itemId) {
		for (Items item : items) {
			if (item.getItemId() == itemId) {
				items.removeValue(item, false);
				listner.removeItem(item);
				break;
			}
		}
	}

	public void removeItem(String itemName) {
		for (Items item : items) {
			if (itemName.equals(item.getItemName())) {
				items.removeValue(item, false);
				listner.removeItem(item);
				break;
			}
		}
	}

	public void setItems(int[] itemIds) {
		for (int i = 0; i < itemIds.length; i++) {
			Items item = ItemsHandler.getItem(itemIds[i]);
			items.add(item);
		}
	}

	public Array<Items> getItems() {
		return items;
	}

	public int[] getItemIds() {
		int[] itemIds = new int[items.size];
		for (int i = 0; i < itemIds.length; i++) {
			itemIds[i] = items.get(i).getItemId();
		}

		return itemIds;
	}

	public Items getItem(int itemId) {
		Items item = null;
		for (Items i : items) {
			if (i.getItemId() == itemId) {
				item = i;
				break;
			}
		}
		return item;
	}

	public boolean findItem(int itemId) {
		for (Items item : items) {
			if (item.getItemId() == itemId)
				return true;
		}

		return false;
	}

	public boolean findItem(String itemName) {
		for (Items item : items) {
			if (itemName.equals(item.getItemName()))
				return true;
		}
		return false;
	}
}
