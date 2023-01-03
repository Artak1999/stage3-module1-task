package com.mjc.school;

import static com.mjc.school.Menu.ACTION;

public enum Action {
    GET_ALL_NEWS(1, "Get all news."),
    GET_NEWS_BY_ID(2, "Get news by id."),
    CREATE_NEWS(3, "Create news."),
    UPDATE_NEWS(4, "Update news."),
    REMOVE_NEWS_BY_ID(5, "Remove news by id."),
    EXIT(6, "Exit.");

    private final Integer actionNumber;
    private final String action;

    Action(Integer actionNumber, String action) {
        this.actionNumber = actionNumber;
        this.action = action;
    }

    public String getAction() {
        return ACTION + action;
    }

    public String getActionNumber() {
        return actionNumber + ": " + action;
    }
}
