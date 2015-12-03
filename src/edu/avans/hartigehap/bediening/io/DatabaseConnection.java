/*
 * Copyright (C) 2015, David Verhaak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.avans.hartigehap.bediening.io;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DatabaseConnection
{

    private static final Logger LOG = Logger.getLogger(DatabaseConnection.class.getName());

    private Connection connection;

    public DatabaseConnection()
    {
        connection = null;
    }

    public boolean open()
    {
        boolean result = true;
        if(connection == null)
        {
            try
            {
                connection = DriverManager.getConnection("jdbc:mysql://145.48.6.147/ivp4a2", "root", "10ec4u");
                result = true;
            } catch(SQLException exception)
            {
                LOG.log(Level.SEVERE, "", exception);
                result = false;
            }
        }
        return result;
    }

    public boolean isOpen()
    {
        if(connection != null)
        {
            try
            {
                return !connection.isClosed();
            } catch(SQLException exception)
            {
                LOG.log(Level.SEVERE, "", exception);
            }
        }
        return false;
    }

    public void close()
    {
        try
        {
            connection.close();
        } catch(SQLException exception)
        {
            LOG.log(Level.SEVERE, "", exception);
        }
    }

    public PreparedStatement createStatement(String query)
    {
        if(query != null && isOpen())
        {
            try
            {
                return connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            } catch(SQLException exception)
            {
                LOG.log(Level.SEVERE, "", exception);
            }
        }
        return null;
    }

    public boolean executeUpdate(PreparedStatement query)
    {
        try
        {
            return query.executeUpdate() > 0;
        } catch(SQLException exception)
        {
            LOG.log(Level.SEVERE, "", exception);
        }
        return false;
    }

    public ResultSet execute(PreparedStatement query)
    {
        try
        {
            return query.executeQuery();
        } catch(SQLException exception)
        {
            LOG.log(Level.SEVERE, "", exception);
        }
        return null;
    }
}