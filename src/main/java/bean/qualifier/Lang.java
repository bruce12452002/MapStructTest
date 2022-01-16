package bean.qualifier;

import annotation.English;
import annotation.QualifierTest;
import annotation.Taiwan;

@QualifierTest
public class Lang {
    @English
    public String toEnglish(String lan) {
        return "English";
    }

    @Taiwan
    public String toTaiwan(String lan) {
        return "中文";
    }
}
