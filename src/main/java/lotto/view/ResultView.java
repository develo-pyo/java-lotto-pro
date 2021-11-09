package lotto.view;

import lotto.model.Winning;
import lotto.model.LottoResult;

public class ResultView {
    public void showWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(getWinningMessage(lottoResult, Winning.FOURTH_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.THIRD_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.SECOND_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.FIRST_PRIZE));
    }

    private String getWinningMessage(LottoResult lottoResult, Winning winning) {
        final long winningCount = lottoResult.getCountOf(winning);
        return String.format("%d개 일치 (%s원)- %d개",
                winning.getMatchCount(),
                winning.getReward(),
                winningCount);
    }

    public void showReturnOnInvestment(double roi) {
        System.out.printf("총 수익률은 %.2f입니다.%n", roi);
    }
}