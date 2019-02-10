package com.bus.sistema.app_reservacion.ModSeguridad.Util;

public class DTOEvents {
    private String id;
    private String title;
    private String start;
    private String end;
    private String url;
    private String color;
    public DTOEvents(){

    }

    public DTOEvents(String id, String title, String start, String end, String url, String color) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.url = url;
        this.color = color;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
