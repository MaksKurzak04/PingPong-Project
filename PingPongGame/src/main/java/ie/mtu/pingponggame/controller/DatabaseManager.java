package ie.mtu.pingponggame.controller;

import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.model.GameBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public Game getGame(String name) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from game where name='"+name+"';";
        System.out.println(sql);
        ResultSet rs= statement.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString("player1Name"));
            System.out.println(rs.getString("player1Name"));
            GameBuilder builder = new GameBuilder().
                    withPlayer1Name(rs.getString("player1Name")).
                    withPlayer2Name(rs.getString("player2Name")).
                    withPlayer1Score(rs.getInt("player1Score")).
                    withPlayer2Score(rs.getInt("player1Score")).
                    withTarget(rs.getInt("target"));
            Game game = builder.build();
            return game;
        }
        return null;
    }
}
