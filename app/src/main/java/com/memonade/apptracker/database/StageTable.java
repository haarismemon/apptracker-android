package com.memonade.apptracker.database;

/**
 * This class contains all the static string constants for Stage to help
 * create the Stage Table in the database
 * @author HaarisMemon
 */
public class StageTable {

    //static String constants for all the columns in the Stage Table
    public static final String TABLE_APPLICATION_STAGE = "application_stage";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STAGE_NAME = "stage_name";
    public static final String COLUMN_IS_COMPLETED = "is_completed";
    public static final String COLUMN_IS_WAITING = "is_waiting";
    public static final String COLUMN_IS_SUCCESSFUL = "is_successful";
    public static final String COLUMN_DEADLINE_DATE = "deadline_date";
    public static final String COLUMN_START_DATE = "start_date";
    public static final String COLUMN_COMPLETE_DATE = "complete_date";
    public static final String COLUMN_REPLY_DATE = "reply_date";
    public static final String COLUMN_NOTES = "notes";
    public static final String COLUMN_CREATED_ON = "created_on";
    public static final String COLUMN_MODIFIED_ON = "modified_on";
    public static final String COLUMN_APPLICATION_ID = "application_id";

    /**
     * List of all columns in the Stage Table as String constants
     */
    public static final String[] ALL_COLUMNS = {
            COLUMN_ID, COLUMN_STAGE_NAME, COLUMN_IS_COMPLETED,
            COLUMN_IS_WAITING, COLUMN_IS_SUCCESSFUL, COLUMN_DEADLINE_DATE, COLUMN_START_DATE,
            COLUMN_COMPLETE_DATE, COLUMN_REPLY_DATE, COLUMN_NOTES, COLUMN_CREATED_ON,
            COLUMN_MODIFIED_ON, COLUMN_APPLICATION_ID
    };

    /**
     * SQL Create statement to create the Stage table will all the columns, if not exists already
     */
    public static final String SQL_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_APPLICATION_STAGE +
                    " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_STAGE_NAME + " VARCHAR, " +
                    COLUMN_IS_COMPLETED + " INTEGER DEFAULT 0, " +
                    COLUMN_IS_WAITING + " INTEGER DEFAULT 0, " +
                    COLUMN_IS_SUCCESSFUL + " INTEGER DEFAULT 0, " +
                    //TEXT as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
                    COLUMN_DEADLINE_DATE + " DATETIME, " +
                    COLUMN_START_DATE + " DATETIME, " +
                    COLUMN_COMPLETE_DATE + " DATETIME, " +
                    COLUMN_REPLY_DATE + " DATETIME, " +
                    COLUMN_NOTES + " VARCHAR, " +
                    COLUMN_CREATED_ON + " DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME')), " +
                    COLUMN_MODIFIED_ON + " DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME'))," +
                    COLUMN_APPLICATION_ID + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_APPLICATION_ID + ") REFERENCES " + ApplicationTable.TABLE_APPLICATION + "(" + ApplicationTable.COLUMN_ID + ") " +
                    ")";

    /**
     * SQL Create statement to drop the Stage Table
     */
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_APPLICATION_STAGE;

}
