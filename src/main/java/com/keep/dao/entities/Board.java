package com.keep.dao.entities;

import java.util.Objects;

public class Board {

    private Long id;
    private String Board;
    private Long user_id;
    private String createdDate;
    private String title;


    public Board() {

    }

    public Board(Long id, String Board, Long user_id, String createDate, String title) {
        this.id = id;
        this.Board = Board;
        this.user_id = user_id;
        this.createdDate = createDate;
        this.title = title;
    }

    /**
     * get-set idBoard
     */

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get-set Board
     */

    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
    }

    /**
     * get-set user_id
     */

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /**
     * get-set createDate
     */

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {

    }

    /**
     * get-set title
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", board='" + Board + '\'' +
                ", user_id=" + user_id +
                ", createdDate='" + createdDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return id == board1.id &&
                Objects.equals(Board, board1.Board) &&
                Objects.equals(user_id, board1.user_id) &&
                Objects.equals(createdDate, board1.createdDate) &&
                Objects.equals(title, board1.title);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Board, user_id, createdDate, title);
    }
}
