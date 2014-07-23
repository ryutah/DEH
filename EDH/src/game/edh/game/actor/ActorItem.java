package game.edh.game.actor;

import game.edh.game.model.items.Items;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

public class ActorItem extends Image {
	Items item;
	ActorItemPanel parent;
	
	public ActorItem(Items item, ActorItemPanel parent) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.item = item;
		this.parent = parent;
		
		addListener(new ActorGestureListener(20, .4f, .4f, .15f) {
			@Override
			public void tap(InputEvent event, float x, float y, int count,
					int button) {
				// TODO 自動生成されたメソッド・スタブ
				event.stop();
				ActorItem.this.item.tap();
				ActorItem.this.parent.hide();
			}
			
			@Override
			public boolean longPress(Actor actor, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				ActorItem.this.item.longTap();
				return true;
			}
		});
		
		setDrawable(item.getDrawable());
	}
	
	public Items getItem() {
		return item;
	}
}
