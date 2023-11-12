package se.kthraven.journalapp.Persistence.entities;

import jakarta.persistence.*;
import se.kthraven.journalapp.Model.enums.Severity;

import java.util.Date;

@Entity
@Table(name = "t_condition")
public class ConditionDB {
    @Id
    private String id;
    @Column(name = "c_condition")
    private String condition;
    private String description;

    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Column(name = "date_diagnosed")
    private Date dateDiagnosed;
    @Column(name = "date_recovered")
    private Date dateRecovered;

    public ConditionDB(){

    }

    public ConditionDB(String id, String condition, Severity severity, Date dateDiagnosed) {
        this.id = id;
        this.condition = condition;
        this.severity = severity;
        this.dateDiagnosed = dateDiagnosed;
    }

    public ConditionDB(String id, String condition, String description, Severity severity, Date dateDiagnosed) {
        this.id = id;
        this.condition = condition;
        this.description = description;
        this.severity = severity;
        this.dateDiagnosed = dateDiagnosed;
    }

    public ConditionDB(String id, String condition, String description, Severity severity, Date dateDiagnosed, Date dateRecovered) {
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

    public void setCondition(String condition){
        this.condition = condition;
    }

    public Date getDateDiagnosed() {
        return dateDiagnosed;
    }

    public void setDateDiagnosed(Date dateDiagnosed) {
        this.dateDiagnosed = dateDiagnosed;
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
