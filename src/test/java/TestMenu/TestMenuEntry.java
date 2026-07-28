package TestMenu;

import TestClasses.GenericTest;

public class TestMenuEntry {
    private final GenericTest testObj;
    private final String displayName;

    public TestMenuEntry(GenericTest classObj, String displayName) {
        this.testObj = classObj;
        this.displayName = displayName;
    }

    public GenericTest getTestObj() {
        return testObj;
    }
    public String getDisplayName() {
        return displayName;
    }
}
