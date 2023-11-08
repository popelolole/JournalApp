package se.kthraven.journalapp.Model.classes;

import se.kthraven.journalapp.Model.enums.Severity;
import se.kthraven.journalapp.Persistence.entities.ConditionDB;

import java.util.Date;

public class Condition {
    private String id;
    private String condition;
    private String description;
    private Severity severity;
    private Date dateDiagnosed;
    private Date dateRecovered;

    public static Condition from(ConditionDB conditionDb){
        if(conditionDb == null)
            return null;
        Condition condition = new Condition();
        condition.id = conditionDb.getId();
        condition.condition = conditionDb.getCondition();
        condition.description = conditionDb.getDescription();
        condition.severity = conditionDb.getSeverity();
        condition.dateDiagnosed = conditionDb.getDateDiagnosed();
        condition.dateRecovered = conditionDb.getDateRecovered();
        return condition;
    }

    public Condition(){

    }

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
