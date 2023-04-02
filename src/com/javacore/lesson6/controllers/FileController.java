package com.javacore.lesson6.controllers;

import com.javacore.lesson6.models.Order;

import java.io.*;
import java.util.Map;

public class FileController {

    private String filePath;
    private String fileName;
    private static String absoluteFilePath;
    private static File file;

    public FileController(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
        absoluteFilePath = filePath + File.separator + fileName;
        file = new File(absoluteFilePath);
    }

    public void checkFile() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public Map<Integer, Order> fillEmptyOrdersStorageFile(Map<Integer, Order> orders) throws IOException {
        checkFile();
        try {
            if (orders.size() == 0 && file.length() > 0) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                orders = (Map<Integer, Order>) ois.readObject();
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return orders;
    }

    public void updateOrdersStorageFile(Map<Integer, Order> orders) throws IOException {
        checkFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(orders);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
