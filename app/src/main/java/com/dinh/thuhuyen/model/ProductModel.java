package com.dinh.thuhuyen.model;

import java.io.Serializable;

public class ProductModel implements Serializable {


    /**
     * id : 1
     * id_code : 202009291
     * name : Túi đeo chéo khủng long
     * image : Túi đeo chéo khủng long
     */

    private int id;
    private String id_code;
    private String name;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
