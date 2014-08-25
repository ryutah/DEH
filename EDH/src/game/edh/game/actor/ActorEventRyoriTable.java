package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.event.EventRyouri;
import game.edh.game.model.frame.event.ModelEventObj;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class ActorEventRyoriTable extends Table {
	ScrollPane pane;
	Label label1, label2;

	public ActorEventRyoriTable(EventRyouri ryori) {
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 550, 432, 120);
		Image image = new Image(Assets.title.get("tanshoku",
				TextureRegionDrawable.class));
		image.setFillParent(true);
		addActor(image);
		image.setColor(0, 0, 0, .5f);

		Table table = new Table();
		table.defaults().width(80).height(80).space(30);
		table.debug();
		pane = new ScrollPane(table);
		pane.setVelocityX(10);
		add(pane).padLeft(50).padRight(50);

		Array<ModelEventObj> objs = ryori.getTableObj();
		for (ModelEventObj obj : objs) {
			Actor comp = new EventImage(obj);
			table.add(comp);
		}

		label1 = new Label("＜", Assets.title, "mikachan");
		label1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				float moveX = pane.getScrollX() - pane.getWidth() ;
				pane.scrollTo(moveX, 0, pane.getWidth(), pane.getHeight());
				}
		});
		label1.setPosition(10, 0);
		label1.setSize(45, 120);
		label1.setFontScale(2, 3);
		label1.setVisible(false);

		label2 = new Label("＞", Assets.title, "mikachan");
		label2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				float moveX = pane.getWidth() + pane.getScrollX();
				pane.scrollTo(moveX, 0, pane.getWidth(), pane.getHeight());
			}
		});
		label2.setVisible(false);
		label2.setPosition(387, 0);
		label2.setSize(45, 120);
		label2.setAlignment(Align.center);
		label2.setFontScale(2, 3);

		addActor(label1);
		addActor(label2);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		if(pane.getScrollX() > 0)
			label1.setVisible(true);
		else
			label1.setVisible(false);
		if(pane.getScrollX() < pane.getMaxX())
			label2.setVisible(true);
		else
			label2.setVisible(false);
	}
}
