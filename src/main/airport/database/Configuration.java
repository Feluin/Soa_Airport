package airport.database;
public enum Configuration {
        instance;
        boolean isDebug = false;

        String userDirectory = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String pathToEngineJavaArchive = userDirectory + fileSeparator + "engine" + fileSeparator + "jar";

              String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
       String databaseFile = dataDirectory + "flightRecorderA380.db";

       int maximumNumberOfEnginesPerWing = 2;

       int taxiTimeInSeconds = 5;
       int taxiEngineIncreaseRPMPerSeconds = 50;

       int takeOffTimeInSeconds = 14;
       int takeOffEngineIncreaseRPMPerSecond = 250;
}