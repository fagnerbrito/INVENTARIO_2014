package net.fagner.trf5.inventario2013;
	
    import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
    
	public class TimeTrackerDatabaseHelper {
	
	private static final int  DATABASE_VERSION = 49;
	private static final String TABLE_NAME = "reltombos";
	private static final String DATABASE_NAME = "inventariotrf52013.db";
    public static final String TIMETRACKER_COLUMN_ID = "_id";
	public static final String TIMETRACKER_COLUMN_TOMBO= "tombo";
	public static final String TIMETRACKER_COLUMN_TIME = "time";
	public static final String TIMETRACKER_COLUMN_DATA = "data";
	public static final String TIMETRACKER_COLUMN_DESCRICAO = "descricao";
	public static final String TIMETRACKER_COLUMN_ICONE = "icone";
	public static final String TIMETRACKER_COLUMN_SITUACAO = "situacao";
	public static final String TIMETRACKER_COLUMN_INVENTARIADA = "inventariadaid";
	
	private TimeTrackerOpenHelper openHelper;
    private SQLiteDatabase database;
    
    public TimeTrackerDatabaseHelper(Context context) {
	openHelper = new TimeTrackerOpenHelper(context);
    database = openHelper.getWritableDatabase();
}
    
    public void saveTimeRecord(String time, String data, Integer icone, String descricao, Integer tombo, String situacao, Integer inventariada) {
     ContentValues contentValues = new ContentValues();
	 contentValues.put(TIMETRACKER_COLUMN_TOMBO, tombo);
	 contentValues.put(TIMETRACKER_COLUMN_TIME, time);
	 contentValues.put(TIMETRACKER_COLUMN_DATA, data);
	 contentValues.put(TIMETRACKER_COLUMN_DESCRICAO, descricao);
	 contentValues.put(TIMETRACKER_COLUMN_ICONE, icone);
	 contentValues.put(TIMETRACKER_COLUMN_SITUACAO, situacao);
	 contentValues.put(TIMETRACKER_COLUMN_INVENTARIADA, inventariada);
	database.insert(TABLE_NAME, null, contentValues);
    }
    
    public void insereinventariada(String setor, String sala, Integer andar, String inventariante) {
        ContentValues contentValues = new ContentValues();
   	 contentValues.put("setor", setor);
   	 contentValues.put("sala", sala);
   	 contentValues.put("andar", andar);
   	 contentValues.put("inventariante", inventariante);
   	database.insert("inventariada", null, contentValues);
       }
    
    public Integer buscainventariadamaisrecente() {
    	   
       Cursor temp = database.rawQuery("select max(_id) from inventariada",null);
        temp.moveToFirst();
        return temp.getInt(0);
      }
       
    
    public String[] buscadadosinventariada(Integer id) {
 	   
        Cursor temp = database.rawQuery("select * from inventariada where _id="+id,null);
         temp.moveToFirst();
         return new String[]{temp.getString(1),temp.getString(2),temp.getString(3), temp.getString(4)};
       }
        
    
    public boolean checaTomboExiste(Integer tombo) {
   
   	 Cursor temp = database.rawQuery("select max(tombo) from " + TABLE_NAME + " where [" + TIMETRACKER_COLUMN_TOMBO +"]=" + tombo,null);
     temp.moveToFirst();
     return temp.getInt(0) == tombo;
   }
    
    public boolean deletaTombo(Integer id) {
    	   
    	return database.delete(TABLE_NAME, TIMETRACKER_COLUMN_ID + "=" + id, null) > 0; 	
       }
    
    
    public Cursor getTimeRecordList() {
    return database.rawQuery("select reltombos._id _id, time, data, descricao, tombo, situacao, icone, sala, setor, andar, inventariante from " + TABLE_NAME + ", inventariada where reltombos.inventariadaid=inventariada._id order by reltombos._id DESC", null);
    }
    
    private class TimeTrackerOpenHelper extends SQLiteOpenHelper {
    	TimeTrackerOpenHelper(Context context) {
    		super(context, context.getExternalFilesDir(null).getAbsolutePath() + "/" + DATABASE_NAME, null, DATABASE_VERSION);
    }
    
   	
    public void onCreate(SQLiteDatabase database) {
    		database.execSQL(
    				"CREATE TABLE " + TABLE_NAME + "( "
    				+ TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, "
    				+ TIMETRACKER_COLUMN_TIME + " TEXT, "
    				+ TIMETRACKER_COLUMN_DATA + " TEXT, "
    				+ TIMETRACKER_COLUMN_DESCRICAO + " TEXT, "
    				+ TIMETRACKER_COLUMN_TOMBO + " INTEGER, "
    				+ TIMETRACKER_COLUMN_SITUACAO + " TEXT, "
    				+ TIMETRACKER_COLUMN_ICONE + " INTEGER, "
    				+ TIMETRACKER_COLUMN_INVENTARIADA + " INTEGER) "
    				);
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('15:30',  'monitor', 12345, 0)");
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('11:20',  'gabinete', 23456, 1)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('22:40',  'tv', 34567, 5)");
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('05:30',  'cadeira', 55567, 3)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('23:23',  'frigobar', 98767, 5)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('12:12',  'scanner', 44331, 4)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('19:20',  'monitor', 57576, 0)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('14:03',  'mesa', 33344, 2)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('20:21',  'vibrador', 11111, 5)");	
    		//database.execSQL("INSERT INTO reltombos(time, descricao, tombo, icone) VALUES('17:44',  'picotadora', 10101, 5)");	
    		database.execSQL("CREATE TABLE " + "inventariada" + "( "
			+ "_id" + " INTEGER PRIMARY KEY, "
			+ "setor" + " TEXT, "
			+ "sala" + " TEXT, "
			+ "andar" + " INTEGER, "
			+ "inventariante" + " TEXT)"
			);
    		
    		database.execSQL("INSERT INTO inventariada (setor, sala, andar, inventariante) values('Pessoal', 'sala1', 2, 'Fagner Brito')");
     		 //database.insereinventariada("Pessoal", "Sala1", 2, "Fagner Brito");
    	}			
    
    	public void onUpgrade(SQLiteDatabase database,
    			
   			 int oldVersion, int newVersion) {
    		 database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    		 database.execSQL("DROP TABLE IF EXISTS " + "inventariada");
    	
    		 onCreate(database);
    	}
    	}
    	
    }
    
