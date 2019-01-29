package airport.database;
public enum Configuration {
        instance;
        boolean isDebug = false;

        String userDirectory = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");

        String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
        String databaseFile = dataDirectory + "SoA.db";
}