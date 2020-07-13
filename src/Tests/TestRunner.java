package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Leidžia paleisti visus testus tuo pačiu metu
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PassCheckTests.class,
        FailCheckTests.class})
public class TestRunner {}
