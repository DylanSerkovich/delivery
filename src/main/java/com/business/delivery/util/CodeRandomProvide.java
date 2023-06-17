package com.business.delivery.util;

import net.bytebuddy.utility.RandomString;

public class CodeRandomProvide {

    static public String get(int number) {
        return RandomString.make(number);
    }

}
