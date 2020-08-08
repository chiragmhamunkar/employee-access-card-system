package com.example.accesscard.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    public static <T> boolean isEmpty(Collection<T> list){
        return list == null || list.isEmpty();
    }
}
