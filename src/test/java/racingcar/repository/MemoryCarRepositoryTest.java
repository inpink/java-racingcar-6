package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class MemoryCarRepositoryTest {

    private final CarRepository memoryCarRepository = MemoryCarRepository.getInstance();

    @Test
    public void 새로운_Car저장() {
        //given
        String name = "car1";
        final Car car = Car.create(name);

        //when
        final Car result = memoryCarRepository.save(car);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo("car1");
    }

    @Test
    public void Car_Id값이_1부터1씩커지는지() {
        //given
        final Car car1 = Car.create("car1");
        final Car car2 = Car.create("car2");

        //when
        final Car result1 = memoryCarRepository.save(car1);
        final Car result2 = memoryCarRepository.save(car2);

        //then
        assertThat(result1.getId()).isEqualTo(1L);
        assertThat(result2.getId()).isEqualTo(2L);
    }
    //TODO: get~~(getPosition)같은것을 쓸경우 이거를 위한 테스트 따로하기(위치 이동시킨다음  위치값 저장 잘되는지)
}