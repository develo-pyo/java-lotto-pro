package lotto.domain;

import lotto.domain.error.LottoResultErrorCode;

import java.util.*;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounter;

    public LottoResult() {
        this.rankCounter = new HashMap<>();
        init();
    }

    private void init() {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounter.put(rank, 0));
    }

    public void countLottoRank(final WinningLottoTicket winningLottoTicket, final LottoTicket purchasedLottoTicket) {
        validateNull(winningLottoTicket, purchasedLottoTicket);

        LottoRank lottoRank = winningLottoTicket.match(purchasedLottoTicket);

        increaseCount(lottoRank);
    }

    private void validateNull(WinningLottoTicket winningLottoTicket, LottoTicket purchasedLottoTicket) {
        if (Objects.isNull(winningLottoTicket) || Objects.isNull(purchasedLottoTicket)) {
            throw new IllegalArgumentException(LottoResultErrorCode.NOT_ALLOW_NULL.getMessage());
        }
    }

    private void increaseCount(LottoRank rank) {
        if (Objects.isNull(rank)) {
            return;
        }

        int count = rankCounter.get(rank);
        rankCounter.put(rank, count + 1);
    }

    public Map<LottoRank, Integer> getRankCounter() {
        return Collections.unmodifiableMap(rankCounter);
    }

    public double calculateYield(final LottoCount lottoCount) {
        if (Objects.isNull(lottoCount) || lottoCount.isZero()) {
            return 0;
        }

        int payAmount = PayAmount.calculate(lottoCount);
        long totalWinningMoney = calculateTotalWinningMoney();

        return Math.floor(((double) totalWinningMoney / payAmount) * 100) / 100.0;
    }

    private long calculateTotalWinningMoney() {
        long totalWinningMoney = 0;
        for (LottoRank rank : rankCounter.keySet()) {
            Integer count = rankCounter.get(rank);
            totalWinningMoney = totalWinningMoney + ((long) rank.getWinningMoney() * count);
        }
        return totalWinningMoney;
    }
}