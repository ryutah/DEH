package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.items.Items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ActorSelectItem extends Image {
	GameWorld world;
	Drawable item;

	public ActorSelectItem(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		setDrawable(Assets.games.getDrawable("black"));
		setBounds(320, 20, 100, 100);
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				event.stop();
				ActorSelectItem.this.world.clearSelectItem();
			}
		});
	}

	public void setItem(Items item) {
		this.item = item.getDrawable();
	}
	
	public void clearItem() {
		item = null;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		super.draw(batch, parentAlpha);
		if (item != null) {
			batch.setColor(1, 1, 1, parentAlpha);
			item.draw(batch, 330, 30, 80, 80);
		}
	}
}
