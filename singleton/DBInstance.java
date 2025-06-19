

public class DBInstance {
    private static DBInstance dbInstance=null;
    private DBInstance(){};

    public static DBInstance getInstance(){
        if (dbInstance==null){
            synchronized(DBInstance.class){
                if(dbInstance==null){
                    dbInstance=new DBInstance();
                }
            }
        }
        return dbInstance;
    }
}
