package com.engeto.homework;

public class Room {

//region Room`s Attributes
    public int roomNumber;
    private int bedNumber;
    private boolean hasBalcony;
    private boolean hasSeaView;
    private int pricePerNight;
    //endregion

    //region Room`s Constructors

    public Room(int roomNumber, int bedNumber, boolean hasBalcony, boolean hasSeaView, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
        this.pricePerNight = pricePerNight;
    }
    //endregion

    //region Methods

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }




    @Override
    public String toString() {
        return  "Pokoj číslo: " + roomNumber +
                "\nPočet lůžek: " + bedNumber +
                "\nBalkón: " + (hasBalcony ? "ANO" : "NE") +
                "\nVýhled na moře: " + (hasSeaView ? "ANO" : "NE") +
                "\nCena za noc: " + pricePerNight + " Kč" + "\n";
        }
    //endregion
    }

