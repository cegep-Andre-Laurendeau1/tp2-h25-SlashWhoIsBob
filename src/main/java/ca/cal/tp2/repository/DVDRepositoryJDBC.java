package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.DVD;

import java.sql.*;

public class DVDRepositoryJDBC implements DVDRepository {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp1;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE DVD "
                    + "(docID INTEGER not NULL, "
                    + " titre VARCHAR(255), "
                    + " nbExemplaires INTEGER, "
                    + " director VARCHAR(255), "
                    + " duree INTEGER, "
                    + " rating VARCHAR(255), "
                    + " PRIMARY KEY ( docID ))";
            statement.executeUpdate(sql);
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(DVD dvd) {
        try (PreparedStatement ps = conn.prepareStatement(getSQLInsert())) {
            ps.setInt(1, dvd.getDocumentID());
            ps.setString(2, dvd.getTitre());
            ps.setInt(3, dvd.getNbExemplaires());
            ps.setString(4, dvd.getDirector());
            ps.setInt(5, dvd.getDuree());
            ps.setString(6, dvd.getRating());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DVD getDVDById(long id) {
        try (PreparedStatement ps = conn.prepareStatement(getSQLSelect())) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DVD(rs.getInt("docID"),
                            rs.getString("titre"),
                            rs.getInt("nbExemplaires"),
                            rs.getString("director"),
                            rs.getInt("duree"),
                            rs.getString("rating"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private String getSQLInsert() {
        return "INSERT INTO DVD (docID, titre, nbExemplaires, director, duree, rating) VALUES (?, ?, ?, ?, ?, ?)";
    }

    private String getSQLSelect() {
        return "SELECT * FROM DVD WHERE docID = ?";
    }
}
