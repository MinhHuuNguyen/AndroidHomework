package com.example.minh.pokemonquizemall;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 20/11/2016.
 */

public class DbHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "pokemon.db";
    private static final int DB_VERSION = 1;
    private final static String POKEMON_TABLE_NAME = "pokemon";
    private static final String POKEMON_COLUMN_ID = "id";
    private static final String POKEMON_COLUMN_NAME = "name";
    private static final String POKEMON_COLUMN_TAG = "tag";
    private static final String POKEMON_COLUMN_GEN = "gen";
    private static final String POKEMON_COLUMN_IMG = "img";
    private static final String POKEMON_COLUMN_COLOR = "color";

    private static final String[] POKEMON_COLUMNS = new String[]{POKEMON_COLUMN_ID, POKEMON_COLUMN_NAME, POKEMON_COLUMN_TAG, POKEMON_COLUMN_GEN, POKEMON_COLUMN_IMG, POKEMON_COLUMN_COLOR};
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public List<Pokemon> selectAll(){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(POKEMON_TABLE_NAME, POKEMON_COLUMNS, null, null, null, null, null);
        while (cursor.moveToNext()){
            pokemons.add(createPokemon(cursor));
        }
        cursor.close();
        db.close();
        return pokemons;
    }

    private Pokemon createPokemon(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(POKEMON_COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(POKEMON_COLUMN_NAME));
        String tag = cursor.getString(cursor.getColumnIndex(POKEMON_COLUMN_TAG));
        int gen = cursor.getInt(cursor.getColumnIndex(POKEMON_COLUMN_GEN));
        String img = cursor.getString(cursor.getColumnIndex(POKEMON_COLUMN_IMG));
        String color = cursor.getString(cursor.getColumnIndex(POKEMON_COLUMN_COLOR));
        Pokemon pokemon = new Pokemon(id, name, tag, gen, img, color);
        return pokemon;
    }

    public Pokemon selectRandomPokemon(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(POKEMON_TABLE_NAME, POKEMON_COLUMNS,null, null, null, null, "RANDOM()", "1");
        if (cursor.moveToNext()){
            return createPokemon(cursor);
        }
        return null;
    }

    private static DbHelper instance;
    public static DbHelper getInstance(){
        return instance;
    }
    public static void init(Context context){
        instance = new DbHelper(context);
    }
}
