package com.dinh.thuhuyen.model;

import java.io.Serializable;

public class QuantityImportModel implements Serializable {

    /**
     * id : 1
     * id_product : 1
     * name : túi khủng long màu đỏ
     * quantity_import : 4
     * total_import : 16000
     */

    private int id;
    private String id_product;
    private String name;
    private String quantity_import;
    private String total_import;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity_import() {
        return quantity_import;
    }

    public void setQuantity_import(String quantity_import) {
        this.quantity_import = quantity_import;
    }

    public String getTotal_import() {
        return total_import;
    }

    public void setTotal_import(String total_import) {
        this.total_import = total_import;
    }
}
