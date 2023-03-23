import test.*;

import java.lang.reflect.InvocationTargetException;

public class TestStarter {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        BeforeNotationStarterImpl beforeNotationStarterImpl = new BeforeNotationStarterImpl();
        beforeNotationStarterImpl.runNotation(Tests.class);

        TestNotationStarter testNotationStarter = new TestNotationStarter();
        testNotationStarter.runNotation(Tests.class);

        AfterNotationStarter afterNotationStarter = new AfterNotationStarter();
        afterNotationStarter.runNotation(Tests.class);

    }
}

