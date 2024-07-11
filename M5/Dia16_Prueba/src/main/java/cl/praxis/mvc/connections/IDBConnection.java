package cl.praxis.mvc.connections;

import java.sql.Connection;

public interface IDBConnection {
    public Connection getConnection();
}
