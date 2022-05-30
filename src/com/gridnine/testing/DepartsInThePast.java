package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Class to get Predicate for "Departing in the past" filter
 */
interface DepartsInThePast {
    static Predicate<Flight> getPredicate() {
        return f -> f.getSegments()
                     .stream()
                     .allMatch(s -> s.getDepartureDate()
                                     .isAfter(LocalDateTime.now()));
    }
}
