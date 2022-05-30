package com.gridnine.testing;

import java.time.Duration;
import java.util.function.Predicate;

/**
 * Class to get Predicate for "More than two hours ground time" filter
 */
interface MoreTwoHoursGroundTime {
    final static int MORE_THAN_HOURS = 2;
    static Predicate<Flight> getPredicate() {
        return f -> f.getSegments()
                     .stream()
                     .map(s -> Duration.between(s.getDepartureDate(), s.getArrivalDate()))
                     .reduce(Duration.ofHours(MORE_THAN_HOURS), Duration::plus)
                     .compareTo(Duration.between(f.getSegments()
                                                  .get(0)
                                                  .getDepartureDate(),
                                                 f.getSegments()
                                                  .get(f.getSegments().size() - 1)
                                                  .getArrivalDate())) > 0;
    }
}
