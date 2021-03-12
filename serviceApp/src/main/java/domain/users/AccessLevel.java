package domain.users;

public enum AccessLevel {
    PLAYER ("player"),
    ADMIN ("admin");

    String name;

    AccessLevel(String name) {
        this.name = name;
    }
}


