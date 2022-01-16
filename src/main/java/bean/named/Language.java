package bean.named;

import org.mapstruct.Named;

@Named("lang")
public class Language {
    @Named("english")
    public String toEnglish(String lan) {
        return "English";
    }

    @Named("taiwan")
    public String toTaiwan(String lan) {
        return "中文";
    }
}
