package org.models;

import org.annotations.GreaterThan;
import org.annotations.NonNull;

public class Coordinates {
    @NonNull
    private Float x;

    @GreaterThan(-494)
    private long y;
}
