package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNotationStarter implements NotationStarter {
    @Override
    public void runNotation(Class className) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Object clazz = className.newInstance();
        var clazzGetClass = clazz.getClass();
        var clazzReflectMethods = clazzGetClass.getMethods();
        List<Method> listWithTestMethods = new ArrayList<>(Arrays.stream(clazzReflectMethods).
                filter(x -> x.isAnnotationPresent(Test.class)).toList());
        System.out.println("Методов @Test - " + listWithTestMethods.size());
        for (Method method : listWithTestMethods) {
            method.invoke(clazz);
        }
    }
}
