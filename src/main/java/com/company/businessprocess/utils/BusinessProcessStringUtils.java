package com.company.businessprocess.utils;

import org.springframework.util.StringUtils;

public class BusinessProcessStringUtils extends StringUtils {
    public static boolean isBlankAndEmpty(String str) {
        if (isEmpty(str)) {
            return true;
        }
        if (isEmpty(str.trim())) {
            return true;
        }
        return false;
    }
}
