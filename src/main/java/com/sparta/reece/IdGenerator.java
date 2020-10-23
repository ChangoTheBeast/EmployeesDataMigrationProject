package com.sparta.reece;

import java.util.HashSet;
import java.util.Set;

public class IdGenerator {
    public static boolean firstRun = true;
    public static Set<Integer> ids = new HashSet<>();

    public static int generateID(long lineCount, Set<Integer> uniqueIds) {
        if (firstRun) {
            for (int i = 1; i <= lineCount; i++) {
                ids.add(i);
            }
            firstRun = false;
        }
        Set<Integer> temporaryIds = new HashSet<>(ids);
        temporaryIds.removeAll(uniqueIds);
        for (Integer integer : temporaryIds) {
            return integer;
        }
        return -1;
    }
}
