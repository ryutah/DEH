package game.edh.frame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import game.edh.EdhGame;
import game.edh.TitleScreen;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class BaseTable extends Table {
	protected EdhGame edh;
	protected BaseScreen screen;
	protected Table mainTable;
	protected BaseTable nextTable;
	
	public BaseTable(EdhGame game,BaseScreen screen, Table mainTable) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.edh = game;
		this.screen = screen;
		this.mainTable = mainTable;
		setTouchable(Touchable.disabled);
		getColor().a = 0;
	}
	
	public void changeTable(BaseTable table) {
		nextTable = table;
		setTouchable(Touchable.disabled);
		addAction(sequence(fadeOut(1.0f), run(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				nextTable();
			}
		})));
	}
	
	protected void nextTable() {
		mainTable.removeActor(this);
		((TitleScreen) screen).changeTable(nextTable);
	}
	
	public void show() {
		addAction(sequence(fadeIn(1.0f), run(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				setTouchable(Touchable.enabled);
			}
		})));
	}
}
