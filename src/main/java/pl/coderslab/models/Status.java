package pl.coderslab.models;

public enum Status {

    ACCEPTED("Accepted"),
    APPROVED_EXPENSES("Expenses approved"),
    REPAIR_IN_PROGRESS("Repair in progress"),
    REPAIR_COMPLETE("Repair complete"),
    RESIGNATION("Resgnation");

    public String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
