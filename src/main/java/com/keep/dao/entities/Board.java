package com.keep.dao.entities;

public class Board {

    private Long id;
    private String Board;
    private Long user_id;
    private String createdDate;
    private String title;


    public Board() {

    }

    public Board (Long id, String Board, Long user_id, String createDate, String title) {
        this.id = id;
        this.Board = Board;
        this.user_id = user_id;
        this.createdDate = createDate;
        this.title = title;
    }

    /** get-set idBoard */

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** get-set Board*/

    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
    }

    /** get-set user_id*/

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /** get-set createDate */

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {

    }

    /** get-set title */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





}
