package lotto.common;

public enum Messages {

	INPUT_AMOUNT("구입금액을 입력해 주세요."),
	BOUGHT_OF("개를 구매했습니다."),
	INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
	WINNING_STATS("당첨 통계"),
	MATCHED("개 일치"),
	WON("원"),
	QUANTITY("개"),
	BONUS_BALL_MATCHED("보너스 볼 일치"),
	RESULT_FORMAT("총 수익률은 {0}입니다."),
	INPUT_NUMBER_COMMA_FORMAT_NOT_VALID("숫자와 ','만 입력 가능합니다."),
	INPUT_NUMBER_LENGTH_NOT_VALID("6개의 숫자를 입력해야 합니다."),
	INPUT_NUMBER_RANGE_NOT_VALID("1~45 까지의 숫자만 입력 가능합니다."),
	INPUT_NUMBER_DUPLICATE("중복된 숫자가 존재합니다."),
	INPUT_NUMBER_FORMAT_NOT_VALID("숫자만 입력가능 합니다."),
	POSITIVE_NUMBER_FORMAT_NOT_VALID("양의 숫자만 입력가능 합니다."),
	INPUT_INVESTMENT_MIN_VALID("1000원 이상 입력해야 합니다."),
	INPUT_INVESTMENT_UNIT_VALID("1000원 단위로 입력해야 합니다."),
	INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),
	INPUT_BONUS_BALL_NOT_VALID("지난주 당첨 번호와 다른 번호를 입력해 주세요.");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}