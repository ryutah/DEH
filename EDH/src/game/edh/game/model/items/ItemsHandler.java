package game.edh.game.model.items;

import game.edh.game.model.frame.GameWorld;

public class ItemsHandler {
	static GameWorld world;

	public static final int NONE = -1;
	public static final int KINOMI_4 = 0;
	public static final int RYOURI_SEIKO = 1;
	public static final int RYOURI_SHIPPAI = 2;
	public static final int NINGYOAKA = 3;
	public static final int KAGI = 4;
	public static final int KINOMI_1 = 5;
	public static final int KUSA = 6;
	public static final int TSURIZAO = 7;
	public static final int BOU = 8;
	public static final int SPICE = 9;
	public static final int TEBUKURO = 10;
	public static final int SHABERU = 11;
	public static final int KINOKO = 12;
	public static final int HOUCHO = 13;
	public static final int SAKANA = 14;
	public static final int MEMO = 15;
	public static final int INU = 16;
	public static final int KANAZUTI = 17;
	public static final int RYOURI_SEIKO2 = 18;
	public static final int TAMAGO = 19;
	public static final int MEMO2 = 20;
	public static final int NINGYOAO = 21;
	public static final int HANA = 22;

	public static Items getItem(int itemId) {
		Items item = null;

		switch (itemId) {
		case NONE:
			break;
		case KINOMI_1:
			item = new Kinomi1(world);
			break;
		case KINOMI_4:
			item = new Kinomi(world);
			break;
		case RYOURI_SEIKO:
			item = new RyouriSeiko(world);
			break;
		case RYOURI_SHIPPAI:
			item = new RyouriShippai(world);
			break;
		case KAGI:
			item = new Kagi(world);
			break;
		case NINGYOAKA:
			item = new NingyoAka(world);
			break;
		case KUSA:
			item = new Sansou(world);
			break;
		case BOU:
			item = new Bou(world);
			break;
		case TSURIZAO:
			item = new Tsurizao(world);
			break;
		case SPICE:
			item = new Spice(world);
			break;
		case TEBUKURO:
			item = new Tebukuro(world);
			break;
		case HOUCHO:
			item = new Houcho(world);
			break;
		case KINOKO:
			item = new Kinoko(world);
			break;
		case SAKANA:
			item = new Sakana(world);
			break;
		case SHABERU:
			item = new Shaberu(world);
			break;
		case MEMO:
			item = new Memo(world);
			break;
		case INU:
			item = new Inu(world);
			break;
		case KANAZUTI:
			item = new Kanazuti(world);
			break;
		case RYOURI_SEIKO2:
			item = new RyouriSeiko2(world);
			break;
		case TAMAGO:
			item = new Tamago(world);
			break;
		case MEMO2:
			item = new Memo2(world);
			break;
		case NINGYOAO:
			item = new NingyoAo(world);
			break;
		case HANA:
			item = new Hana(world);
			break;
		}
		return item;
	}

	public static void setWorld(GameWorld world) {
		ItemsHandler.world = world;
	}
}
