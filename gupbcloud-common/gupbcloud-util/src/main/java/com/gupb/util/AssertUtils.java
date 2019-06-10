package com.gupb.util;

import com.gupb.util.exception.GupbRuntimeException;

/**
 * AssertUtils.
 *
 * @author gupb
 */
public final class AssertUtils {

    private AssertUtils() {

    }

    /**
     * Not null.
     *
     * @param obj the obj
     */
    public static void notNull(final Object obj) {
        if (obj == null) {
            throw new GupbRuntimeException("argument invalid,Please check");
        }
    }

}
