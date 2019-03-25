package com.example.fuckinggreatadvice.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Advice implements Serializable {
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("text")
    private String text;

    @Expose
    @SerializedName("sound")
    private String sound;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Advice) {
            Advice advice = (Advice) obj;
            return advice.getId().equals(this.getId());
        }
        return super.equals(obj);
    }
}
