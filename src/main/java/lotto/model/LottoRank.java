package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 200_0000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int hits;
    private final int cashPrize;

    LottoRank(int hits, int cashPrize) {
        this.hits = hits;
        this.cashPrize = cashPrize;
    }

    public int getHits() {
        return hits;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public static LottoRank findByHits(int hits) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.hits == hits)
                .findAny()
                .orElse(MISS);
    }
}