package com.edu.udea.mezclandocolores.DB;

public class StatusContract {
    public static final String DB_NAME = "mezclandocolores.db";
    public static final int DB_VERSION = 3;
    public static final String TABLE_PRIMARY = "primarycolors";
    public static final String TABLE_SECONDARY = "secondarycolors";
    public static final String TABLE_TERTIARY = "tertiarycolors";

    public class Column_Primary_Color {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String CODE = "code";
    }

    public class Column_Secondary_Color {

        public static final String ID = "id";
        public static final String COLOR1 = "color1";
        public static final String COLOR2 = "color2";
        public static final String RESULT = "result";
    }
}
