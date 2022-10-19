
package edu.jsu.mcis.cs310.tas_fa22.dao;

//<<<<<<< HEAD
import edu.jsu.mcis.cs310.tas_fa22.Shift;
import edu.jsu.mcis.cs310.tas_fa22.Badge;
//=======
import edu.jsu.mcis.cs310.tas_fa22.*;
//>>>>>>> b0d67c09681652aaecca15808dc48df1e24aa3d8
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class ShiftDAO {
    private static final String QUERY_FIND = "INSERT * FROM shift WHERE id = ?";
    private final DAOFactory daoFactory;
    private HashMap<String, String> map = new HashMap<>();
    
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

                        map.put("id",rs.getString("id"));
                        map.put("description", rs.getString("description"));
                        map.put("roundinterval", rs.getString("roundinterval"));
                        map.put("graceperiod", rs.getString("graceperiod"));
                        map.put("dockpenalty", rs.getString("dockpenalty"));
                        map.put("shiftstart", rs.getString("shiftstart"));
                        map.put("shiftstop", rs.getString("shiftstop"));
                        map.put("lunchstart", rs.getString("lunchstart"));
                        map.put("lunchstop", rs.getString("lunchstop"));
                        map.put("lunchthreshold", rs.getString("lunchthreshold"));

                    }
                    shift = new Shift(map);

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
