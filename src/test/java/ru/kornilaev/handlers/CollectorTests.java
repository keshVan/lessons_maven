package ru.kornilaev.handlers;

import org.junit.jupiter.api.Test;
import ru.kornilaev.reflection.Invoke;

import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CollectorTests {

    @Test
    public void collectTest() {
        Map<Method, Object> res = Collector.collect(TestClass.class);
        assertEquals(2, res.size());

        TestClass testClass = new TestClass();
        try {
            Method m1 = TestClass.class.getDeclaredMethod("m1");
            Method m2 = TestClass.class.getDeclaredMethod("m2");

            assertAll("Methods",
                    () -> assertTrue(res.containsKey(m1)),
                    ()-> assertTrue(res.containsKey(m2)));

            assertAll("Values",
                    () -> assertEquals("text", res.get(m1)),
                    () -> assertEquals(42, res.get(m2)));

        } catch (NoSuchMethodException e) {
            fail("Methods should exist");
        }
    }

    @Test
    public void collectWithoutAnnotationTest() {
        Map<Method, Object> res = Collector.collect(TestWithoutAnnotation.class);
        assertEquals(0, res.size());
    }

    @Test
    public void collectWithoutZeroArgsMethodsTest() {
        Map<Method, Object> res = Collector.collect(NoZero.class);
        assertEquals(0, res.size());
    }

    @Test
    public void collectWithVoidReturnType() {
        Map<Method, Object> res = Collector.collect(VoidTest.class);
        assertEquals(0, res.size());
    }
}

class TestClass {
    @Invoke
    String m1() {
        return "text";
    }

    @Invoke
    int m2() {
        return 42;
    }

    String m3() {
        return "place";
    }
}

class TestWithoutAnnotation {
    String m1() {
        return "text";
    }

    int m2() {
        return 42;
    }
}

class NoZero {
    @Invoke
    String m1(int a, int b) {
        return "" + a + b;
    }

    int m2(int a, int b) {
        return 42 + a + b;
    }
}

class VoidTest {
    @Invoke
    void m1() {}

    void m2() {}
}
