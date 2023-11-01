package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.car.Car;

public class Winners { // 일급컬렉션

    private List<Car> winners;

    private Winners() {
        initWinners();
    }

    public static Winners createEmpty() {
        return new Winners();
    }

    private void initWinners() {
        winners = new ArrayList<>();
    }

    public void addWinner(Car car) {
        winners.add(car);
    }

    public List<Car> getWinners() {
        return winners;
    }
}