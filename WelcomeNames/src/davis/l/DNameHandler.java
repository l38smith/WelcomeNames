package davis.l;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class DNameHandler {

    private DNamePath path;
    private Connection conn;

    public DNameHandler(DNamePath path) throws Exception {
        //Store the path
        this.path = path;

        // connect to the database
        connect();

        // Initialize the database
        init();
    }

    protected void connect() throws Exception {
        // Driver
        String driver
            = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);

        // Connection
        String connectionUrl
            = String.format("jdbc:derby:%"
                + "s;user=;zabc=;create=true", path.toAbsolutePath());

        System.out.printf("JDBC Url: %s\n", connectionUrl);
        conn = DriverManager.getConnection(connectionUrl);

    }

    protected void init() throws Exception {

        if (path.existedAtStartup()) {
            System.out.printf(" Database already initialized%n");
        } else {
            StringJoiner sj
                = new StringJoiner(",", "create table names (",
                    ")");
            sj.add(" id         bigint ");
            sj.add(" firstName  varchar(100) ");
            sj.add(" lastName   varchar(100) ");

            try (
                Statement stmt = conn.createStatement();) {
                stmt.execute(sj.toString());
                System.out.printf("Names table Created%n");
            }

        }

    }

    public List<DNames> findNames() throws Exception {
        
        StringBuilder sp = new StringBuilder();
        sp.append("  select   \n");
       
        sp.append("  id       \n");
        sp.append("  ,firstName \n");
        sp.append("  ,lastName   \n");
        sp.append(" from \n");
        sp.append(" names \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());
            ResultSet rs
            = stmt.executeQuery();) {
           
            List<DNames> names = new LinkedList<>();
            while (rs.next()) {
                DNames n = new DNames();

                n.setId(rs.getLong(1));
                n.setFirstName(rs.getString(2));
                n.setLastName(rs.getString(3));
                names.add(n);

            }
            return names;
        }

    }

    public int insert(DNames newName) throws Exception {

       
        StringBuilder sp = new StringBuilder();
        sp.append(" insert into names ( \n");
        sp.append("  id           \n");
        sp.append(" ,firstName   \n");
        sp.append(" ,lastName     \n");
        sp.append(" ) \n");
        sp.append(" values (  \n");
        sp.append(" ?    \n");
        sp.append(" ,?    \n");
        sp.append(" ,?    \n");
        sp.append(" )    \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            long id = System.currentTimeMillis();
            newName.setId(id);
            stmt.setLong(1, newName.getId());

            stmt.setString(2, newName.getFirstName());
            stmt.setString(3, newName.getLastName());

            int insertCount = stmt.executeUpdate();
            return insertCount;
        }
    }

    public int fnameInsert(DNames first) throws Exception {
        StringBuilder sp = new StringBuilder();
        sp.append("insert into names ( \n");
        sp.append(" id       \n");
        sp.append("   , firstName  \n");
        sp.append(" ) \n");
        sp.append(" ?    \n");
        sp.append(" ,?    \n");
        sp.append(" )    \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            long id = System.currentTimeMillis();
            first.setId(id);
            stmt.setLong(1, first.getId());
            stmt.setString(2, first.getFirstName());

            int fnameCount = stmt.executeUpdate();
            return fnameCount;

        }
    }

    public int delete(Long id) throws Exception {
        // Prepared Statement
        StringBuilder sp = new StringBuilder();
        sp.append(" delete from   \n");
        sp.append(" names         \n");
        sp.append(" where         \n");
        sp.append("  id = ?       \n");
        sp.append("  \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            stmt.setLong(1, id);

            int deleteCount = stmt.executeUpdate();
            return deleteCount;
        }
    }

    public int update(Long id, String firstName, String lastName)
        throws Exception {

        StringBuilder sp = new StringBuilder();
        sp.append(" update          \n");
        sp.append(" names           \n");
        sp.append(" set             \n");
        sp.append(" firstname = ?   \n");
        sp.append("    \n");
        sp.append("    , ");
        sp.append(" lastname = ?    \n");
        sp.append(" where           \n");
        sp.append("     id =  ?     \n");
        sp.append("    \n");

       

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            
            stmt.setString(1, firstName);
            
            
            stmt.setString(2, lastName);
            
           
            stmt.setLong(3, id);

            int updateCount = stmt.executeUpdate();
            return updateCount;
        }

    }

    public int updateFirst(Long id, String firstName) throws Exception {

        StringBuilder sp = new StringBuilder();
        sp.append(" update          \n");
        sp.append(" names           \n");
        sp.append(" set             \n");
        sp.append(" firstName = ?   \n");
        sp.append("    \n");
        sp.append(" where           \n");
        sp.append("     id =  ?     \n");
        sp.append("    \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            stmt.setLong(1, id);
            stmt.setString(2, firstName);

            int updateFirstCount = stmt.executeUpdate();
            return updateFirstCount;
        }

    }

    public int updateLast(Long id, String lastName) throws Exception {

        StringBuilder sp = new StringBuilder();
        sp.append(" update          \n");
        sp.append(" names           \n");
        sp.append(" set             \n");
        sp.append(" lastName = ?   \n");
        sp.append("    \n");
        sp.append(" where           \n");
        sp.append("     id =  ?     \n");
        sp.append("    \n");

        try (
            PreparedStatement stmt
            = conn.prepareStatement(sp.toString());) {

            stmt.setLong(1, id);
            stmt.setString(2, lastName);

            int updateFirstCount = stmt.executeUpdate();
            return updateFirstCount;
        }

    }

}
