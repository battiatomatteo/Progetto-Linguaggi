package TestMenu;

import TestClasses.GenericEntry;

public class TestMenuEntry {
    private final GenericEntry testObj;
    private final String displayName;

    public TestMenuEntry(GenericEntry classObj, String displayName) {
        this.testObj = classObj;
        this.displayName = displayName;
    }

    public GenericEntry getTestObj() {
        return testObj;
    }
    public String getDisplayName() {
        return displayName;
    }
}
