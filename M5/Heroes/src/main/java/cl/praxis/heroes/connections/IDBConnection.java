package cl.praxis.heroes.connections;

import java.sql.Connection;

public interface IDBConnection {
    public Connection getConnection();
}
