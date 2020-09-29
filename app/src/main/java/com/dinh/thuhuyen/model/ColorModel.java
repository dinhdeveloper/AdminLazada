package com.dinh.thuhuyen.model;

import java.io.Serializable;

public class ColorModel implements Serializable {


    /**
     * id : 1
     * id_product : 1
     * id_code : hfksdf
     * name : Túi đeo chéo khủng long màu đỏ
     * description : màu đỏ
     * price_import : 4000
     * price_export : 10000
     * quantity_import : 4
     * quantity_export : 4
     * date_import : 29-09-2020
     * date_export : 29-09-2020
     * status : Y
     * total_import : 3465654
     * total_export : 344646
     */

    private int id;
    private String id_product;
    private String id_code;
    private String name;
    private String description;
    private String price_import;
    private String price_export;
    private String quantity_import;
    private String quantity_export;
    private String date_import;
    private String date_export;
    private String status;
    private String total_import;
    private String total_export;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice_import() {
        return price_import;
    }

    public void setPrice_import(String price_import) {
        this.price_import = price_import;
    }

    public String getPrice_export() {
        return price_export;
    }

    public void setPrice_export(String price_export) {
        this.price_export = price_export;
    }

    public String getQuantity_import() {
        return quantity_import;
    }

    public void setQuantity_import(String quantity_import) {
        this.quantity_import = quantity_import;
    }

    public String getQuantity_export() {
        return quantity_export;
    }

    public void setQuantity_export(String quantity_export) {
        this.quantity_export = quantity_export;
    }

    public String getDate_import() {
        return date_import;
    }

    public void setDate_import(String date_import) {
        this.date_import = date_import;
    }

    public String getDate_export() {
        return date_export;
    }

    public void setDate_export(String date_export) {
        this.date_export = date_export;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_import() {
        return total_import;
    }

    public void setTotal_import(String total_import) {
        this.total_import = total_import;
    }

    public String getTotal_export() {
        return total_export;
    }

    public void setTotal_export(String total_export) {
        this.total_export = total_export;
    }
}
