package game.edh.title.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class MemoTable extends BaseTable {
	Label label, right, left;
	Group group;
	int maxMemo, nowMemo;

	public MemoTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		group = new Group();
		group.setBounds(40, 150, 350, 450);
		addActor(group);
		addListener(new ActorGestureListener() {
			@Override
			public void fling(InputEvent event, float velocityX,
					float velocityY, int button) {
				// TODO 自動生成されたメソッド・スタブ
				if (velocityX < 0)
					scrollGroup(false);
				else
					scrollGroup(true);
			}
		});

		right = new Label("→", Assets.title, "mikachan");
		right.setColor(Color.BLACK);
		right.setFontScale(2.5f);
		left = new Label("←", Assets.title, "mikachan");
		left.setColor(Color.BLACK);
		left.setFontScale(2.5f);
		right.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				scrollGroup(false);
			}
		});

		bottom().left().add(left).width(136).pad(80).spaceRight(20);
		add(right).width(136);

		left.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				scrollGroup(true);
			}
		});

		setFillParent(true);
		Image back = new Image(Assets.title.getDrawable("back"));
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new ArchiveMemoTable(MemoTable.this.screen,
						MemoTable.this.mainTable));
			}
		});

		back.setPosition(216 - back.getWidth() / 2, 30);
		back.setColor(Color.BLACK);
		addActor(back);

		Table table = new Table();
		table.align(Align.left);

		label = new Label("", Assets.title, "mikachan");
		label.setAlignment(Align.left);
		label.setWrap(true);
		label.setColor(Color.BLACK);
		table.top().add(label).width(350);

		ScrollPane pane = new ScrollPane(table);
		pane.setBounds(0, 0, 350, 450);
		pane.setOverscroll(false, false);
		group.addActor(pane);

		maxMemo = nowMemo = 0;
	}

	protected void setText(String text) {
		label.setText(text);
	}

	protected void addNewMemo(String text) {
		float width = group.getWidth();
		group.setWidth(width + 400);

		Table table = new Table();
		table.align(Align.left);

		Label label = new Label(text, Assets.title, "mikachan");
		label.setAlignment(Align.left);
		label.setWrap(true);
		label.setColor(Color.BLACK);
		table.top().add(label).width(350);

		ScrollPane pane = new ScrollPane(table);
		pane.setBounds(group.getWidth() - 350, 0, 350, 450);
		pane.setOverscroll(false, false);
		group.addActor(pane);

		maxMemo++;

		Gdx.app.log("Group", "X" + group.getX() + "Width" + group.getWidth());
	}

	void scrollGroup(boolean left) {
		EdhGame.music.playEffect(EfftctType.PAGE, false);
		
		if (left) {
			if (nowMemo != 0) {
				group.addAction(Actions.moveBy(400, 0, 0.3f));
				nowMemo--;
			}
		} else {
			if (nowMemo != maxMemo) {
				group.addAction(Actions.moveBy(-400, 0, .3f));
				nowMemo++;
			}
		}
		Gdx.app.log("Group", "X" + group.getX() + "Width" + group.getWidth());

	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (nowMemo != 0)
			left.setVisible(true);
		else
			left.setVisible(false);
		if (nowMemo != maxMemo)
			right.setVisible(true);
		else
			right.setVisible(false);
		super.act(delta);
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new MenuTable(MemoTable.this.screen,
				MemoTable.this.mainTable));
	}

}
