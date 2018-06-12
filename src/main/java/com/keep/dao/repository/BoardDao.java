package com.keep.dao.repository;

import com.keep.dao.entities.Board;
import com.keep.dao.entities.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class BoardDao {

    public void saveBoard(Board board){
        DataSource ds = new DataSource();

        String sql;
        if(board.getId() == 0L){
            sql = "INSERT INTO board (Board, user_id, createDate, title)  " +
                    "VALUES (?, ?, ?, ?)";
        } else {
            sql = "UPDATE board SET Boardр=?, user_id=?, createDate=?, title=? " +
                    " WHERE id = " + board.getId();
        }

        try (
                Connection con = ds.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
        ){
            stmt.setString(1, board.getBoard());
            stmt.setLong(2, board.getUser_id());
            stmt.setString(3, board.getCreatedDate());
            stmt.setString(4, board.getTitle());

            //записує в базу даних
            stmt.execute();
            if(board.getId() == 0L){
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    long last_inserted_id = rs.getLong(1);
                    NoteDao noteDao = new NoteDao();
                    Note note1 = new Note(0L, "", last_inserted_id, new GregorianCalendar().getTime().toString(), "TO DO");
                    //TODO створ

                    Note note2 = new Note(0L, "", last_inserted_id, new GregorianCalendar().getTime().toString(), "DOING");
                    //DOING створ

                    Note note3 = new Note(0L, "", last_inserted_id, new GregorianCalendar().getTime().toString(), "DONE");
                    //DONE створ

                    Note note4 = new Note(0L, "", last_inserted_id, new GregorianCalendar().getTime().toString(), "CANCELED");
                    //CANCELED створ


                }
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
