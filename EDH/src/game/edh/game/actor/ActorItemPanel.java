package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.items.Items;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class ActorItemPanel extends Table {
	GameWorld world;

	Table table;
	Array<ActorItem> items;

	boolean show;
	boolean leftSide;

	public ActorItemPanel(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		world.getItems().setListner(this);

		items = new Array<ActorItem>();

		setBounds(-200, 152, 160, 548);
		Image back = new Image(Assets.title.get("tanshoku", TextureRegionDrawable.class));
		back.setColor(0, 0, 0, .5f);
		back.setBounds(0, 0, 160, 548);
		addActor(back);

		Label label = new Label("ITEM", Assets.title, "TOfont");
		label.setFontScale(1.5f);
		top().add(label).padTop(35).spaceBottom(20).row();

		table = new Table();
		table.defaults().width(80).height(80).spaceTop(30);

		ScrollPane pane = new ScrollPane(table);
		add(pane).spaceTop(20).padBottom(50);
		
		for(Items item : world.getItems().getItems()) {
			addItem(item);
		}
	}

	public void addItem(Items item) {
		ActorItem actor = new ActorItem(item, this);
		items.add(actor);
		table.add(actor).row();
	}

	public void removeItem(Items item) {
		for (ActorItem actor : items) {
			if (item.equals(actor.getItem())) {
				table.removeActor(actor);
				items.removeValue(actor, false);
				break;
			}
		}
		
		Array<Actor> buf = new Array<Actor>();
		buf.addAll(table.getChildren());
		table.clearChildren();

		for (Actor actor : buf) {
			if (actor != null) {
				table.add(actor).row();
			}
		}
	}
	
	public void fling(boolean left) {
		if(left) {
			if(show && leftSide)
				hideLeftSide();
			else
				showRightSide();
		} else {
			if(!show && !leftSide)
				showLeftSide();
			else
				hideRightSide();
		}
	}
	
	void showLeftSide() {
		setPosition(-200, 152);
		addAction(moveTo(0, 152, .3f));
		show = true;
		leftSide = true;
	}
	
	void hideLeftSide() {
		addAction(moveTo(-200, 152, .3f));
		leftSide = false;
		show = false;
	}
	
	void showRightSide() {
		setPosition(472, 152);
		addAction(moveTo(272, 152, .3f));
		show = true;
		leftSide = false;
	}
	
	void hideRightSide() {
		addAction(moveTo(472, 152, .3f));
		leftSide = false;
		show = false;
	}

	public void hide() {
		if(leftSide)
			hideLeftSide();
		else
			hideRightSide();
		show = false;
	}

	public boolean isShow() {
		return show;
	}
}
