package com.gridnine.testing;

import java.util.function.Predicate;

/**
 * Class to get Predicate for "Departs before arrives" filter
 */
interface DepartsBeforeArrives {
    static Predicate<Flight> getPredicate() {
        return f -> f.getSegments()
                     .stream()
                     .allMatch(s -> s.getDepartureDate()
                                     .isBefore(s.getArrivalDate()));
    }
}
