package util;

import constant.libraryClasses.SiteEnum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumTool {
    private List<String> getNames(Class<? extends Enum<?>> givenEnum) {
        return Stream.of(givenEnum.getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }

    public boolean isActionASiteName(Class<? extends Enum<?>> givenEnum, String name) {
        return getNames(givenEnum).indexOf(name.toUpperCase()) >= 0;
    }

    public SiteEnum getSiteEnumByName(String name) {
        if(SiteEnum.LIST_BOOKS.name().equalsIgnoreCase(name)) {
            return SiteEnum.LIST_BOOKS;
        } else if (SiteEnum.HOME.name().equalsIgnoreCase(name)) {
            return SiteEnum.HOME;
        } else if (SiteEnum.RETURN.name().equalsIgnoreCase(name)) {
            return SiteEnum.RETURN;
        } else {
            return SiteEnum.QUIT;
        }
    }
}
