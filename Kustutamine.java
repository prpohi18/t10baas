/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttaevik.baas;

import java.sql.*;
public class Kustutamine{
    public static void kustuta(Connection cn, String[] arg) throws Exception{
		int id;
        PreparedStatement st=cn.prepareStatement("DELETE FROM inimesed WHERE ID=(?)");
        st.setDouble(1, Integer.parseInt(arg[0]));
        st.executeUpdate();
    }
}
