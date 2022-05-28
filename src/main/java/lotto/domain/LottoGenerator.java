package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private final List<LottoNumber> numberList;

    public LottoGenerator() {
        numberList = new ArrayList<>();

        for (int number = LottoNumber.MIN_LOTTO_NUMBER; number <= LottoNumber.MAX_LOTTO_NUMBER; number++) {
            numberList.add(new LottoNumber(number));
        }
    }

    public Lotto generateLotto() {
        shuffleLottoNumberList();
        return new Lotto(drawLottoNumbers());
    }

    public Lottos generateLottos(List<String> manualNumbersStrings, int autoSize) {
        List<Lotto> manualLottoList = generateManualLottoList(manualNumbersStrings);
        List<Lotto> autoLottoList = generateAutoLottoList(autoSize);

        manualLottoList.addAll(autoLottoList);
        return new Lottos(manualLottoList);
    }

    private List<Lotto> generateManualLottoList(List<String> manualNumbersStrings) {
        return manualNumbersStrings.stream().map(Lotto::new).collect(Collectors.toList());
    }

    private List<Lotto> generateAutoLottoList(int size) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoList.add(generateLotto());
        }

        return lottoList;
    }

    private void shuffleLottoNumberList() {
        Collections.shuffle(numberList);
    }

    private List<LottoNumber> drawLottoNumbers() {
        return new ArrayList<>(numberList.subList(0, Lotto.LOTTO_SIZE));
    }
}