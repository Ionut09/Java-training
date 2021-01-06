package enums;

public enum Season {
    SUMMER("is hot"), //0 - ordinal
    SPRING,                     //1 - ordinal
    FALL,                       //2 - ordinal
    WINTER("is cold");

    private String description;

    Season() {//private by default, you cannot make them otherwise
    }

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
