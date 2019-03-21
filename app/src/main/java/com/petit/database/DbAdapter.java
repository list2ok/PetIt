package com.petit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {

    @SuppressWarnings("unused")
    private static final String LONG_TAG = DbAdapter.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public static final String DATABASE_TABLE = "segnalazioni";

    public static final String KEY_ID = "_id";
    public static final String KEY_COLORE_PELO = "colorePelo";
    public static final String KEY_TIPO_PELO = "tipoPelo";
    public static final String KEY_TAGLIA = "taglia";
    public static final String KEY_STATO_FISICO = "statoFisico";
    public static final String KEY_STATO_MENTALE = "statoMentale";
    public static final String KEY_NOTE = "note";

    public DbAdapter(Context context) {
        this.context = context;
    }

    public DbAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValues(String colorePelo, String tipoPelo, String taglia,
                                              String statoFisico, String statoMentale, String note) {
        ContentValues values = new ContentValues();
        values.put(KEY_COLORE_PELO, colorePelo);
        values.put(KEY_TIPO_PELO, tipoPelo);
        values.put(KEY_TAGLIA, taglia);
        values.put(KEY_STATO_FISICO, statoFisico);
        values.put(KEY_STATO_MENTALE, statoMentale);
        values.put(KEY_NOTE, note);

        return values;
    }

    //rimettere private
    public long creaSegnalazione(String colorePelo, String tipoPelo, String taglia,
                                  String statoFisico, String statoMentale, String note) {
        ContentValues initialValues = createContentValues(colorePelo, tipoPelo, taglia,
                statoFisico, statoMentale, note);
        return database.insertOrThrow(DATABASE_TABLE, null, initialValues);
    }

    public Cursor fetchAllSegnalazioni() {
        return database.query(DATABASE_TABLE, new String[]{KEY_ID, KEY_COLORE_PELO, KEY_TIPO_PELO, KEY_TAGLIA,
                KEY_STATO_FISICO, KEY_STATO_MENTALE, KEY_NOTE}, null, null, null, null, null);
    }

    //update a contact
    public boolean aggiornaSegnalazione( long segnalazioneID, String colorePelo, String tipoPelo, String taglia,
                                         String statoFisico, String statoMentale, String note) {
        ContentValues updateValues = createContentValues(colorePelo, tipoPelo, taglia, statoFisico, statoMentale, note);
        return database.update(DATABASE_TABLE, updateValues, KEY_ID + "=" + segnalazioneID,
                null) > 0;
    }

    public boolean rimuoviSegnalazione(long segnalazioneID) {
        return database.delete(DATABASE_TABLE, KEY_ID + "=" + segnalazioneID, null) > 0;

    }

}
