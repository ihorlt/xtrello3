package com.keep.dao.entities;

public class List {

    /** The name. */
    private String name;

    /** The closed. */
    private boolean closed;

    /** The id board. */
    private String idBoard;

    /** The pos. */
    private double pos;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if is closed.
     *
     * @return true, if is closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Sets the closed.
     *
     * @param closed
     *            the new closed
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * Gets the id board.
     *
     * @return the id board
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * Sets the id board.
     *
     * @param idBoard
     *            the new id board
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }
}