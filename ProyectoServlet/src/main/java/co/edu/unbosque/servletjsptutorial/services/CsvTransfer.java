package co.edu.unbosque.servletjsptutorial.services;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.servletjsptutorial.dtos.User;

public class CsvTransfer {

    private List<User> csvList;

    public CsvTransfer() {}

    public void setCsvList(List<User> csvList) {
        this.csvList = csvList;
    }

    public List<User> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<>();
    }

}
