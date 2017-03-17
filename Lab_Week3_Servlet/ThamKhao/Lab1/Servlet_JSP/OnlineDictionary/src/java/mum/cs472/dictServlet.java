package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author SOKLY
 */
public class dictServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JSONObject dictionaryData = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        String term = request.getParameter("term");
        //String limit = request.getParameter("limit");
        try {
            conn = dbConn.openConnection();
            String sql = "SELECT * FROM entries WHERE word LIKE ? ORDER BY word";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,term + "%");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                JSONObject obj = new JSONObject();
                obj.put("word", result.getString("word"));
                obj.put("wordType", result.getString("wordtype"));
                obj.put("definition", result.getString("definition"));
                jsonArray.add(obj);
            }
            
            result.close();
            ps.close();
            dbConn.closeConnection(conn);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dictionaryData.put("dictionaryData",jsonArray);
        PrintWriter out = response.getWriter();
        out.println(dictionaryData);

    }

}
