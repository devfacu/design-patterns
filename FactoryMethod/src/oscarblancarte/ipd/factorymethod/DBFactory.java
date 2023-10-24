package oscarblancarte.ipd.factorymethod;

import java.util.Properties;
import oscarblancarte.ipd.factorymethod.impl.MySQLDBAdapter;
import oscarblancarte.ipd.factorymethod.impl.PostgresDBAdapter;
import oscarblancarte.ipd.factorymethod.util.PropertiesUtil;

public class DBFactory {

    private static final String DB_FACTORY_PROPERTY_URL = "META-INF/DBFactory.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    public static IDBAdapter getDBAdapter(DBType dbType) {
        return switch (dbType) {
            case MySQL -> new MySQLDBAdapter();
            case Postgresql -> new PostgresDBAdapter();
            default -> throw new IllegalArgumentException("Not supported");
        };
    }

    public static IDBAdapter getDefaultDBAdapter() {
        try {
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
            assert prop != null;
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
            System.out.println("DefaultDBClass ==> " + defaultDBClass);
            return (IDBAdapter) Class.forName(defaultDBClass).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}