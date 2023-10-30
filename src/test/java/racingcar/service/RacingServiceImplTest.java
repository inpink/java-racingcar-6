package racingcar.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

public class RacingServiceImplTest {

    private CarRepository memoryCarRepository = MemoryCarRepository.getInstance();
    private CarService carService = CarServiceImpl.getInstance(memoryCarRepository);
    RacingService racingService = RacingServiceImpl.getInstance(carService);

    @BeforeEach
    public void setUp() {
        memoryCarRepository.deleteAll();
    }

    @Test
    public void Car_Name들_한줄에_입력받아_저장하기() {
        // given
        String input = "pobi,woni,jun";

        // when
        racingService.processCarNamesInput(input);

        // then
        assertThat(memoryCarRepository.findAll()).hasSize(3);
    }

    @Test
    public void Car_Name_미입력시_예외발생() {
        // given
        String input = "";

        //when
        final RuntimeException result = assertThrows(IllegalArgumentException.class,
                () -> racingService.processCarNamesInput(input));

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void Car_Name_공백입력시_예외발생() {
        // given
        String input = " ";

        //when
        final RuntimeException result = assertThrows(IllegalArgumentException.class,
                () -> racingService.processCarNamesInput(input));

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void Car_Name_콤마만_입력시_예외발생() {
        // given
        String input = ", , ,,";

        //when
        final RuntimeException result = assertThrows(IllegalArgumentException.class,
                () -> racingService.processCarNamesInput(input));

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void 시도횟수_정수하나_입력받아_저장하기() {
        // given
        String input = "3";

        // when
        racingService.processTryCountInput(input);

        // then
        assertThat(memoryCarRepository.findAll()).hasSize(3);
    }
}