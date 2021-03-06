package org.models;

import org.annotations.GreaterThan;
import org.annotations.NonNull;

public class Coordinates {
    @NonNull
    public Float x;

    @GreaterThan(-494)
    public long y;
}
