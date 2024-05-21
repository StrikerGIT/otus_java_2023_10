package ru.otus.annotations;

    public class AnnotationTest {
        @Before
        public void setUp() {
            System.out.println("Before test");
        }

        @Test
        public void test1() {
            System.out.println("Test 1 executed");
        }

        @Test
        public void test2() {
            System.out.println("Test 2 executed");
        }

        @After
        public void tearDown() {
            System.out.println("After test");
        }
}
