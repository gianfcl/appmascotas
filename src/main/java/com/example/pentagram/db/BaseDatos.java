package com.example.pentagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pentagram.R;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + " ( " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA     + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT , " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO   + " INTEGER " +
                " ) ";

        String queryCrearTablaMascotaLikes = " CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES + " ( " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA   + " INTEGER , " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE   + " INTEGER , " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION + " TEXT DEFAULT (date('now') ) ," +
                " FOREIGN KEY ( " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + " ) " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + " ( " + ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA + " ) " +
                " ) ";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES);
        onCreate(db);
    }


    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()) {
            Mascota mascotaactual = new Mascota();
            mascotaactual.setId(registros.getInt(0));
            mascotaactual.setNombre(registros.getString(1));
            mascotaactual.setFoto(registros.getInt(2));


            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaactual.getId() +
                    " AND "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION +" = date('now')";

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaactual.setLike(registrosLikes.getInt(0));

                mascotas.add(mascotaactual);
            }
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        //SQLiteDatabase db = this.getWritableDatabase();
        //db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null, contentValues);
        //db.close();
    }


    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA_LIKES, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascotas(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE+") as likes" +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "="+mascota.getId() +
                " AND "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION +" = date('now')";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Mascota> obtenerDatosFotosMiMascotas() {
        ArrayList<Mascota> fotosmimascota = new ArrayList<>();
        String query = " SELECT A."+ ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA +" , " +
                " COUNT(B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE+") as likes , " +
                " strftime('%d',B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION+") as DIA " +
                " FROM "+ConstantesBaseDatos.TABLE_MASCOTA+" as A " +
                " LEFT JOIN "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES+" as B " +
                " ON A."+ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA+"=B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                " WHERE A."+ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA + " = 5 "+
                " GROUP BY A."+ ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA +" , " +
                " strftime('%d',B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION+") ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()) {
            Mascota mascotaactual = new Mascota();
            mascotaactual.setId(registros.getInt(0));
            mascotaactual.setNombre("Firulais");
            mascotaactual.setFoto(R.drawable.mascota1);
            mascotaactual.setLike(registros.getInt(1));

            fotosmimascota.add(mascotaactual);
        }
        db.close();
        return fotosmimascota;
    }

    public ArrayList<Mascota> obtenerDatosTopMascotas() {
        ArrayList<Mascota> topmascota = new ArrayList<>();
        String query = " SELECT A."+ ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA +" , " +
                " A."+ ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" , " +
                " A."+ ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" , " +
                " COUNT( B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE+" ) as cantlikes " +
                " FROM "+ConstantesBaseDatos.TABLE_MASCOTA+" as A " +
                " LEFT JOIN "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES+" as B " +
                " ON A."+ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA+"=B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                " WHERE B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_FECHA_CREACION + " = date('now') "+
                " GROUP BY A."+ ConstantesBaseDatos.TABLE_MASCOTA_ID_MASCOTA +" , " +
                " A."+ ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" , " +
                " A."+ ConstantesBaseDatos.TABLE_MASCOTA_FOTO+
                " ORDER BY COUNT( B."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_LIKE + ") DESC"+
                " LIMIT 5 ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()) {
            Mascota mascotaactual = new Mascota();
            mascotaactual.setNombre(registros.getString(1));
            mascotaactual.setFoto(registros.getInt(2));
            mascotaactual.setLike(registros.getInt(3));

            topmascota.add(mascotaactual);
        }
        db.close();
        return topmascota;
    }
}
