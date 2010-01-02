/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.jamisoft.db.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 *
 * @author Jose Antonio Jamilena Daza
 */
public class ScriptRunner extends com.ibatis.common.jdbc.ScriptRunner {
    public ScriptRunner(java.sql.Connection connection, boolean autoCommit, boolean stopOnError) {
        super(connection, autoCommit, stopOnError);
    }

    public ScriptRunner(java.lang.String driver, java.lang.String url, java.lang.String username, java.lang.String password, boolean autoCommit, boolean stopOnError) {
        super(driver, url, username, password, autoCommit, stopOnError);
    }
    public void	runScript(Reader reader) throws IOException, SQLException {
        super.runScript(reader);
    }
    public void	setErrorLogWriter(java.io.PrintWriter errorLogWriter) {
        super.setErrorLogWriter(errorLogWriter);
    }
    public void	setLogWriter(java.io.PrintWriter logWriter) {
        super.setLogWriter(logWriter);
    }
}
