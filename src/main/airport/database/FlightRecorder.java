package airport.database;

import java.sql.*;

public enum FlightRecorder {
        instance;

        private Connection connection;
       private String driverName = "jdbc:hsqldb:";
       private String username = "sa";
       private String password = "";

       public void startup() {
           try {
               Class.forName("org.hsqldb.jdbcDriver");
             String databaseURL = driverName + Configuration.instance.databaseFile;
               connection = DriverManager.getConnection(databaseURL, username, password);
               if (Configuration.instance.isDebug)
                   System.out.println("FlighRecorder - connection : " + connection);
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }

       public void init() {
          dropTable();
           createTable();
       }

       public synchronized void update(String sqlStatement) {
           try {
               Statement statement = connection.createStatement();
               int result = statement.executeUpdate(sqlStatement);
               if (result == -1)
                   System.out.println("error executing " + sqlStatement);
               statement.close();
           } catch (SQLException sqle) {
               System.out.println(sqle.getMessage());
           }
      }

       public void dropTable() {
           System.out.println("--- dropTable");

           StringBuilder sqlStringBuilder = new StringBuilder();
           sqlStringBuilder.append("DROP TABLE data");
          System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

           update(sqlStringBuilder.toString());
       }

      public void createTable() {
           StringBuilder sqlStringBuilder = new StringBuilder();
           sqlStringBuilder.append("CREATE TABLE data ").append(" ( ");
          sqlStringBuilder.append("id BIGINT NOT NULL").append(",");
          sqlStringBuilder.append("aircraft_id BIGINT NOT NULL").append(", ");
          sqlStringBuilder.append("unix_timestamp BIGINT NOT NULL").append(", ");
          sqlStringBuilder.append("event_message VARCHAR(150) NOT NULL").append(", ");
          sqlStringBuilder.append("PRIMARY KEY (id)");
           sqlStringBuilder.append(" )");
           update(sqlStringBuilder.toString());
      }

       public String buildSQLStatement(long id, int aircraft_id, long unix_timestamp, String event_message) {
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append("INSERT INTO data (id,aircraft_id,unix_timestamp, event_message) VALUES (");
          stringBuilder.append(id).append(",");
           stringBuilder.append("'").append(aircraft_id).append("'").append(",");
           stringBuilder.append("'").append(unix_timestamp).append("'").append(", ");
           stringBuilder.append("'").append(event_message).append("'");
           stringBuilder.append(")");
           System.out.println(stringBuilder.toString());
           return stringBuilder.toString();
       }

       public void insert(int aircraft_id, String event_message) {
           long millis = System.currentTimeMillis();

           update(buildSQLStatement(System.nanoTime(), aircraft_id, millis/1000, event_message));
       }
       public void shutdown() {
           try {
               Statement statement = connection.createStatement();
               statement.execute("SHUTDOWN");
               connection.close();
              if (Configuration.instance.isDebug)
                   System.out.println("FlightRecorder - isClosed : " + connection.isClosed());
          } catch (SQLException sqle) {
              System.out.println(sqle.getMessage());
           }
      }
   }