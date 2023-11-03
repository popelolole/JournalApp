package se.kthraven.journalapp.Model.records;

import se.kthraven.journalapp.Model.enums.Severity;

import java.util.Date;

public record Condition(String id, String condition, String description,
                        Severity severity, Date dateDiagnosed, Date dateRecovered) {
}
