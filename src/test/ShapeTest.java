import main.java.model.Shape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Nested
    @DisplayName("문양 잘 갖고 오는지 테스트 Nested 사용해서")
    class GetShapeTest {
        @Test
        @DisplayName("1 일때 spade")
        void 문양_잘찾아오는지_테스트1() throws Exception {
            //given
            //when
            Shape shape = Shape.get(1);
            //then
            assertEquals(shape,Shape.SPADE);

        }
        @Test
        @DisplayName("2 일때 다이아")
        void 문양_잘찾아오는지_테스트2() throws Exception {
            //given
            //when
            Shape shape = Shape.get(2);
            //then
            assertEquals(shape,Shape.DIAMOND);

        }
        @Test
        @DisplayName("3 일때 하트")
        void 문양_잘찾아오는지_테스트3() throws Exception {
            //given
            //when
            Shape shape = Shape.get(3);
            //then
            assertEquals(shape,Shape.HEART, "하트 구만");


        }
        @Test
        @DisplayName("4 일때 Clova")
        void 문양_잘찾아오는지_테스트4() throws Exception {
            //given
            //when
            Shape shape = Shape.get(4);
            //then
            assertEquals(shape,Shape.CLOVA);

        }
        @Test
        @DisplayName("그외 일때 오류")
        void 문양_잘찾아오는지_테스트5() throws Exception {
            //given
            //when
            //then
            assertThrows( IllegalStateException.class, () -> Shape.get(5));
        }
    }

    @Test
    @DisplayName("숫자로 모양 잘 갖고 오는지 확인 assertAll 사용해서")
    void getShape() throws Exception {
        //then
        assertAll(() -> assertEquals( Shape.get(1),Shape.SPADE),
                () -> assertEquals( Shape.get(2),Shape.DIAMOND),
                () -> assertEquals( Shape.get(3),Shape.HEART),
                () -> assertEquals( Shape.get(4),Shape.CLOVA),
                () -> assertThrows( IllegalStateException.class, () -> Shape.get(5)));
    }

}
