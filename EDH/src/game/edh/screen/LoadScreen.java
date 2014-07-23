package game.edh.screen;

import com.badlogic.gdx.Gdx;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.screen.Event1Screen;
import game.edh.event.screen.Event2Screen;
import game.edh.event.screen.Event3Screen;
import game.edh.event.screen.Event4Screen;
import game.edh.event.screen.Event5Screen;
import game.edh.event.screen.Event6Screen;
import game.edh.event.screen.Event7Screen;
import game.edh.event.screen.Event8Screen;
import game.edh.frame.BaseScreen;
import game.edh.game.screen.ScreenStage1;
import game.edh.game.screen.ScreenStage2;
import game.edh.game.screen.ScreenStage3;
import game.edh.game.screen.ScreenStage4;
import game.edh.screen.TitleScreen.TableType;

public class LoadScreen extends BaseScreen {
	public enum NextScreen {
		TITLE, EVENT1, EVENT2, EVENT3, EVENT4, EVENT5, EVENT6, EVENT7, EVENT8, STAGE1, STAGE2, STAGE3, STAGE4, LOAD
	}

	EdhGame edh;

	private NextScreen next;
	private TableType type;
	boolean eventFromArchive;

	public LoadScreen(EdhGame edh, NextScreen next) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(edh);
		this.edh = edh;
		this.next = next;
	}

	public LoadScreen(EdhGame edh, NextScreen next, boolean fromArchive) {
		this(edh, next);
		eventFromArchive = fromArchive;
	}

	public LoadScreen(EdhGame edh, TableType type) {
		this(edh, NextScreen.TITLE);
		this.type = type;
	}

	private void AssetsLoad() {
		Gdx.app.log("Assets", Assets.titleLoad + "");

		switch (next) {
		case TITLE:
			if (!Assets.titleLoad)
				Assets.loadTitle();
			break;

		case EVENT1:
		case EVENT2:
		case EVENT3:
		case EVENT4:
		case EVENT5:
		case EVENT6:
		case EVENT7:
		case EVENT8:
			if (!Assets.eventLoad)
				Assets.loadEvent();
			break;

		case STAGE1:
			Assets.loadGames(1);
			break;
		case STAGE2:
			Assets.loadGames(2);
			break;
		case STAGE3:
			Assets.loadGames(3);
			break;
		case STAGE4:
			Assets.loadGames(4);
			break;

		case LOAD:
			int stageNum = EdhGame.gameData.stageNum;
			if (stageNum == 0)
				stageNum = 1;
			Assets.loadGames(stageNum);
			break;
		}
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (Assets.finishLoad) {
			switch (next) {
			case TITLE:
				if (type == null)
					edh.setScreen(new TitleScreen(edh));
				else
					edh.setScreen(new TitleScreen(edh, type));
				break;

			case EVENT1:
				edh.setScreen(new Event1Screen(edh, eventFromArchive));
				break;

			case EVENT2:
				edh.setScreen(new Event2Screen(edh, eventFromArchive));
				break;

			case EVENT3:
				edh.setScreen(new Event3Screen(edh, eventFromArchive));
				break;

			case EVENT4:
				edh.setScreen(new Event4Screen(edh, eventFromArchive));
				break;

			case EVENT5:
				edh.setScreen(new Event5Screen(edh, eventFromArchive));
				break;

			case EVENT6:
				edh.setScreen(new Event6Screen(edh, eventFromArchive));
				break;

			case EVENT7:
				edh.setScreen(new Event7Screen(edh, eventFromArchive));
				break;

			case EVENT8:
				edh.setScreen(new Event8Screen(edh, eventFromArchive));
				break;

			case STAGE1:
				edh.setScreen(new ScreenStage1(edh));
				break;

			case STAGE2:
				edh.setScreen(new ScreenStage2(edh));
				break;

			case STAGE3:
				edh.setScreen(new ScreenStage3(edh));
				break;

			case STAGE4:
				edh.setScreen(new ScreenStage4(edh));
				break;

			case LOAD:
				switch (EdhGame.gameData.stageNum) {
				case 1:
					edh.setScreen(new ScreenStage1(edh, EdhGame.gameData));
					break;
				case 2:
					edh.setScreen(new ScreenStage2(edh, EdhGame.gameData));
					break;
				case 3:
					edh.setScreen(new ScreenStage3(edh, EdhGame.gameData));
					break;
				case 4:
					edh.setScreen(new ScreenStage4(edh, EdhGame.gameData));
					break;
				default:
					edh.setScreen(new ScreenStage1(edh, EdhGame.gameData));
					break;
				}
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void show() {
		// TODO 自動生成されたメソッド・スタブ
		AssetsLoad();
		EdhGame.music.disposeMusic();
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
