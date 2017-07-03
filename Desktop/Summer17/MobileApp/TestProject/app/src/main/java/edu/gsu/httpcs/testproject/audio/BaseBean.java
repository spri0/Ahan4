package edu.gsu.httpcs.testproject.audio;

import java.io.Serializable;

/**
 * Created by spri0 on 6/24/17.
 */

public class BaseBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
