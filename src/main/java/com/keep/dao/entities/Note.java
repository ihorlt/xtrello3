package com.keep.dao.entities;

import java.util.Objects;

/**
 * Note Entity
 */
public class Note {
    private long id;
    private String note;
    private Long board_id;
    private String createdDate;
    private String title;

    public Note() {
    }

    public Note(long id, String note, Long board_id, String createdDate, String title) {
        this.id = id;
        this.note = note;
        this.board_id = board_id;
        this.createdDate = createdDate;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", board_id=" + board_id +
                ", createdDate='" + createdDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return id == note1.id &&
                Objects.equals(note, note1.note) &&
                Objects.equals(board_id, note1.board_id) &&
                Objects.equals(createdDate, note1.createdDate) &&
                Objects.equals(title, note1.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, note, board_id, createdDate, title);
    }
}
