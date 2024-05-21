package ru.otus.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String className =  "ru.otus.annotations.AnnotationTest";   // "AnnotationTest.java";
        runTests(className);
    }


    public static void runTests(String className) {
        try {
            Class<?> testClass = Class.forName(className);
            Method[] methods = testClass.getDeclaredMethods();

            List<Method> beforeMethods = new ArrayList<>();
            List<Method> testMethods = new ArrayList<>();
            List<Method> afterMethods = new ArrayList<>();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Before.class)) {
                    beforeMethods.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                } else if (method.isAnnotationPresent(After.class)) {
                    afterMethods.add(method);
                }
            }

            int total = testMethods.size();
            int passed = 0;
            int failed = 0;

            for (Method testMethod : testMethods) {
                Object testInstance = testClass.getDeclaredConstructor().newInstance();

                try {
                    for (Method beforeMethod : beforeMethods) {
                        beforeMethod.invoke(testInstance);
                    }

                    try {
                        testMethod.invoke(testInstance);
                        System.out.println(testMethod.getName() + " passed.");
                        passed++;
                    } catch (Exception e) {
                        System.out.println(testMethod.getName() + " failed: " + e.getCause());
                        failed++;
                    }

                    for (Method afterMethod : afterMethods) {
                        afterMethod.invoke(testInstance);
                    }
                } catch (Exception e) {
                    System.out.println("Error during setup or teardown: " + e.getCause());
                }
            }

            System.out.println("Total: " + total + ", Passed: " + passed + ", Failed: " + failed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static @interface Anotations {
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Test {
        }

        @Retention(RetentionPolicy.RUNTIME)
        public @interface Before {
        }

        @Retention(RetentionPolicy.RUNTIME)
        public @interface After {
        }
    }
}
