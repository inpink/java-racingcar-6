package racingcar.domain.racing;

import racingcar.util.StringUtil;
import racingcar.validation.IntegerValidator;

public class TryCount {

    private final int tryCount;

    private TryCount(String strTryCount) {
        tryCount = processTryCountInput(strTryCount);
    }

    public static TryCount create(String strTryCount) {
        return new TryCount(strTryCount);
    }

    public int getTryCount() {
        return tryCount;
    }

    private int processTryCountInput(String strTryCount) {
        strTryCount = StringUtil.deleteAllSpaces(strTryCount);
        IntegerValidator.validateInteger(strTryCount);

        return Integer.parseInt(strTryCount);
    }
}
