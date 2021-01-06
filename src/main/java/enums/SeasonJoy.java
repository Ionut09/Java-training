package enums;

public class SeasonJoy {

    public static void main(String... args) {
        Season[] seasons = Season.values();

        for (Season season : seasons) {
            System.out.println(season.toString() + " : " +
                                season.name() + " : " +
                                season.ordinal() + " : " + //returns an index of the enum instance
                                season.getDescription());
        }

        //convert a String into an enum instance

        String enumString = "SPRinG";
        Season spring = Season.valueOf(enumString.toLowerCase());
        System.out.println(spring);
    }
}
