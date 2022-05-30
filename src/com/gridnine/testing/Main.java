package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List flights = FlightBuilder.createFlights();

        System.out.println(" Initial List.");
        flights.forEach(System.out::println);

        System.out.println("\n Departs In The Past filter.");
        Predicate departsInThePastPredicate = DepartsInThePast.getPredicate();
        flights.stream().filter(departsInThePastPredicate).forEach(System.out::println);

        System.out.println("\n Departs Before Arrives filter.");
        Predicate departsBeforeArrivesPredicate = DepartsBeforeArrives.getPredicate();
        flights.stream().filter(departsBeforeArrivesPredicate).forEach(System.out::println);

        System.out.println("\n More Two Hours Ground Time filter.");
        Predicate moreTwoHoursGroundTimePredicate = MoreTwoHoursGroundTime.getPredicate();
        flights.stream().filter(moreTwoHoursGroundTimePredicate).forEach(System.out::println);

        System.out.println("\n All filters.");
        flights.stream()
                  .filter(departsInThePastPredicate)
                  .filter(departsBeforeArrivesPredicate)
                  .filter(moreTwoHoursGroundTimePredicate)
                  .forEach(System.out::println);
    }
}
