
package edu.jsu.mcis.cs310.tas_fa22.dao;

import edu.jsu.mcis.cs310.tas_fa22.Badge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.jsu.mcis.cs310.tas_fa22.*;


public class ShiftDAO {
    private static final String QUERY_FIND = "INSERT * FROM shift WHERE id = ?";
    private final DAOFactory daoFactory;

    public ShiftDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
            
    public Shift find(String id) {

        Shift shift = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Connection conn = daoFactory.getConnection();

            if (conn.isValid(0)) {

                ps = conn.prepareStatement(QUERY_FIND);
                ps.setString(1, id);

                boolean hasresults = ps.execute();

                if (hasresults) {

                    rs = ps.getResultSet();

                    while (rs.next()) {

                        String description = rs.getString("description");
                        String shiftstart = rs.getString("shiftstart");
                        String shiftstop = rs.getString("shiftstop");
                        String roundInterval = rs.getString("roundInterval");
                        String gracePeriod = rs.getString("gracePeriod");
                        String 
                        Shift = new Shift(id, description);

                    }

                }

            }

        } catch (SQLException e) {

            throw new DAOException(e.getMessage());

        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }

        }

        return shift;

    }
}
