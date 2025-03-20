package project.crypto.service;

import lombok.Getter;

@Getter
public enum SortTypes {
    SORT_BY_NAME("name"),
    SORT_BY_PRICE("price"),
    SORT_BY_QUANTITY("quantity");

    private final String name;

    SortTypes(String name) {
        this.name = name;
    }

}
