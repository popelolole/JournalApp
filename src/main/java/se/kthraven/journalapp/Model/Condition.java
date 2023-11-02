package se.kthraven.journalapp.Model;

import java.util.Date;

public class Condition {
    private final String id;
    private final String condition;
    private String description;
    private Severity severity;
    private final Date dateDiagnosed;
    private Date dateRecovered;

    public Condition(String id, String condition, Severity severity, Date dateDiagnosed) {
        this.id = id;
        this.condition = condition;
        this.severity = severity;
        this.dateDiagnosed = dateDiagnosed;
    }

    public Condition(String id, String condition, String description, Severity severity, Date dateDiagnosed) {
        this.id = id;
        this.condition = condition;
        this.description = description;
        this.severity = severity;
        this.dateDiagnosed = dateDiagnosed;
    }

    public Condition(String id, String condition, String description, Severity severity, Date dateDiagnosed, Date dateRecovered) {
        this.id = id;
        this.condition = condition;
        this.description = description;
        this.severity = severity;
        this.dateDiagnosed = dateDiagnosed;
        this.dateRecovered = dateRecovered;
    }

    public String getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Date getDateRecovered() {
        return dateRecovered;
    }

    public void setDateRecovered(Date dateRecovered) {
        this.dateRecovered = dateRecovered;
    }
}
