package ru.stqa.pft.mantis.model;

import biz.futureware.mantis.rpc.soap.client.ObjectRef;

public class Issue {

    private int id;
    private String summery;
    private String description;
    private Project project;

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummery() {
        return summery;
    }

    public Issue withSummery(String summery) {
        this.summery = summery;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }
}
