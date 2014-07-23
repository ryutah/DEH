package game.edh.game.model.frame;

public class GamesFlag {
	public static String[] getFlags(int stageNum) {
		String[] flags = null;
		switch (stageNum) {
		case 1:
			flags = Stage1Flag.FLAGS;
			break;
		case 2:
			flags = Stage2Flag.FLAGS;
			break;
		case 3:
			flags = Stage3Flag.FLAGS;
			break;
		case 4:
			flags = Stage4Flag.FLAGS;
			break;
		}

		return flags;
	}

	public static class Stage1Flag {
		public static final String SANSOU = "sansou";
		public static final String HAKO_OPEN = "hakoOpen";
		public static final String KINOMI_GET = "kinomiGet";
		public static final String KAGI_GET = "kagiGet";
		public static final String NIKKI = "nikki";
		public static final String RYOURI = "ryouri";
		public static final String KISHI_GET = "kishiGet";
		public static final String PUT_NINGYO = "putNingyo";
		public static final String RYORI_IN_KINOMI = "kinomiIn";
		public static final String RYORI_IN_KUSA = "kusaIn";

		public static final String[] FLAGS = {SANSOU, HAKO_OPEN, KAGI_GET,
				NIKKI, RYOURI, KISHI_GET, PUT_NINGYO, RYORI_IN_KINOMI,
				RYORI_IN_KUSA, KINOMI_GET };
	}

	public static class Stage2Flag {
		public static final String SAO_SET = "saoSet";
		public static final String SAO_GET = "saoGet";
		public static final String BOU_GET = "bGet";
		public static final String HAMMER_GET = "hGet";
		public static final String PUT_RYOURI1 = "pRyouri1";
		public static final String PUT_RYOURI2 = "pRyouri2";
		public static final String CLEAR_MORI = "cMori";
		public static final String FISH = "fjsh";
		public static final String KIRIKABU = "kirikabu";
		public static final String RYORI_IN_SAKANA = "rSakana";
		public static final String RYORI_IN_TAMAGO = "rTamago";
		public static final String MEMO_GET = "mGEt";
		public static final String TAMAGO_GET = "tamagoGet";
		public static final String TARU_BREAK = "taruBre";
		public static final String NINGYO_GET = "nGet";
		public static final String NINGYO_PUT = "nPut";

		public static final String[] FLAGS = { KIRIKABU, BOU_GET, HAMMER_GET,
				CLEAR_MORI, PUT_RYOURI1, PUT_RYOURI2, RYORI_IN_SAKANA,
				RYORI_IN_TAMAGO, SAO_SET, FISH, MEMO_GET, TAMAGO_GET,
				TARU_BREAK, NINGYO_GET, NINGYO_PUT, SAO_GET };
	}

	public static class Stage3Flag {
		public static final String SAIHOU_KEY_GET = "sKeyGet";
		public static final String SHABERU_GET = "shaberuGet";
		public static final String TEBUKURO_GET = "tGet";
		public static final String PUT_INU = "putInu";
		public static final String KINOKO_GET = "kinokoGet";
		public static final String KAKASHI_KAGI_GET = "kMemoGet";
		public static final String KIRIKABU = "kirikabu";
		public static final String MEMO_GET = "mGet";
		public static final String SAKANA_GET = "sGet";
		public static final String RYOURI_IN_KINOKO = "rKinokoIn";
		public static final String RYOURI_IN_SAKANA = "rSakanaIn";
		public static final String DELETE_INU = "dInu";
		public static final String GET_INU = "inuGet";
		public static final String PUT_RYORI = "pRyori";

		public static final String[] FLAGS = { SAIHOU_KEY_GET, SHABERU_GET,
				KINOKO_GET, TEBUKURO_GET, PUT_INU, KAKASHI_KAGI_GET, KIRIKABU,
				MEMO_GET, SAKANA_GET, RYOURI_IN_KINOKO, RYOURI_IN_SAKANA,
				GET_INU, DELETE_INU, PUT_RYORI };
	}

	public static class Stage4Flag {
		public static final String HAKA_HANA = "haka";
		public static final String HANA_GET = "hGet";
		public static final String PUT_RYORI = "pRyori";
		public static final String RIM_TSUKUE1 = "rTsukue1";
		public static final String RIM_TSUKUE2 = "rTsukue2";
		public static final String RIM_BED = "rBed";
		public static final String RIM_HAKO = "rHako";
		public static final String RIM_TANA2 = "rTana2";
		public static final String RIM_TANA1 = "rTana1";
		public static final String RIM_NABE = "rNabe";
		public static final String RIM_INU = "rInu";

		public static final String[] FLAGS = { HAKA_HANA, HANA_GET, PUT_RYORI,
				RIM_BED, RIM_HAKO, RIM_NABE, RIM_TANA2, RIM_TANA1, RIM_TSUKUE1,
				RIM_TSUKUE2, RIM_INU };
	}
}
