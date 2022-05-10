package com.example.note_application.classes;

public class cls_noteatterbiutes {

   private String notetitle,notebody;
    int noteid;
    public cls_noteatterbiutes() {

    }

    public cls_noteatterbiutes(int noteid, String notetitle, String notebody) {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notebody = notebody;
    }

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotebody() {
        return notebody;
    }

    public void setNotebody(String notebody) {
        this.notebody = notebody;
    }
}
