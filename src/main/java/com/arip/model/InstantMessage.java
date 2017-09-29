package com.arip.model;

import com.google.common.base.Strings;

import java.util.Date;

/**
 * Created by Arip Hidayat on 9/29/2017.
 */
public class InstantMessage {

    private String from;
    private String to;
    private String content;
    private Date date;

    public InstantMessage() {
        this.date = new Date();
    }

    public boolean isPublic() {
        return Strings.isNullOrEmpty(to);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
