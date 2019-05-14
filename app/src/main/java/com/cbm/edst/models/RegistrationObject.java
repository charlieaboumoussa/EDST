package com.cbm.edst.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//This entity is a dummy entity. It should not be saved in ROOM. It is just for testing.. ana charlie 3m bektob
@Entity(tableName = "REGISTRATION_TABLE")
public class RegistrationObject {

    @SerializedName("Id")
    @ColumnInfo(name = "ID")
    @PrimaryKey
    private long mId;

    @Expose
    @SerializedName("Name")
    @ColumnInfo(name = "NAME")
    private String mName;

    public RegistrationObject(long id, String name) {
        mId = id;
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
