package com.keep.dao.repository;

import com.keep.dao.entities.Note;
import com.keep.dao.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Notes Repository
 */
public class NoteDao {

    public Note[] getNotesByUserID(long userid){
        DataSource ds = new DataSource();
        try (
                Connection con = ds.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT n.id, n.note, n.board_id, " +
                        " n.title, n.createdDate " +
                        "FROM note n WHERE n.board_id = " + userid);
        ) {
            List<Note> notes = new ArrayList<>();
            while(rs.next()){
                Note nt = new Note(
                        rs.getLong("id"),
                        rs.getString("note"),
                        rs.getLong("board_id"),
                        rs.getString("createdDate"),
                        rs.getString("title")
                );
                notes.add(nt);
            }

            return (Note[]) notes.toArray();

        } catch(SQLException e){
            e.printStackTrace();
        }

       return null;
    }

    public void saveNote(Note note){
        DataSource ds = new DataSource();

        String sql;
        if(note.getId() == 0L){
            sql = "INSERT INTO note (note, board_id, createdDate, title)  " +
                    "VALUES (?, ?, ?, ?, ?)";
        } else {
            sql = "UPDATE note SET note=?, board_id=?, createdDate=?, title=? " +
                    " WHERE id = " + note.getId();
        }

        try (
                Connection con = ds.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
        ){
            stmt.setString(1, note.getNote());
            stmt.setLong(2, note.getBoard_id());
            stmt.setString(3, note.getCreatedDate());
            stmt.setString(4, note.getTitle());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
