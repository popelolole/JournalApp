package se.kthraven.journalapp.Model.records;

import java.util.Collection;
import java.util.Date;

public record Encounter(String id, Person patient, Person doctor,
                        Date date, String location, Collection<Observation> observations) {
}
