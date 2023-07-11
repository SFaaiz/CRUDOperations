package com.faaiz.crudoperations;

import java.util.Comparator;

public class DataModel {

    String imgUrl, name;

    public DataModel(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

//    static class SortByNameAsc implements Comparator<DataModel>{
//
//        @Override
//        public int compare(DataModel dataModel1, DataModel dataModel2) {
//            return dataModel1.getName().compareTo(dataModel2.getName());
//        }
//    }

    static class SortByNameDesc implements Comparator<DataModel>{

        @Override
        public int compare(DataModel dataModel1, DataModel dataModel2) {
//            return dataModel2.getName().compareTo(dataModel1.getName());
            return dataModel2.getName().trim().compareToIgnoreCase(dataModel1.getName().trim());
        }
    }

    static Comparator<DataModel> SortByNameAsc = new Comparator<DataModel>() {
        @Override
        public int compare(DataModel dataModel1, DataModel dataModel2) {
//            return dataModel1.getName().compareTo(dataModel2.getName());
            return dataModel1.getName().trim().compareToIgnoreCase(dataModel2.getName().trim());
        }
    };

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
