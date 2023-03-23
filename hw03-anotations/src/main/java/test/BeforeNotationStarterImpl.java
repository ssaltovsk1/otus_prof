package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeNotationStarterImpl implements NotationStarter  {
    @Override
    public void runNotation(Class className) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object clazz = className.newInstance();
        var clazzGetClass = clazz.getClass();
        var clazzReflectMethods = clazzGetClass.getMethods();

        List<Method> listWithBeforeMethods = new ArrayList<>(Arrays.stream(clazzReflectMethods).
                filter(x -> x.isAnnotationPresent(Before.class)).toList());

        for (Method method : listWithBeforeMethods) {
            method.invoke(clazz);
        }
    }
}
