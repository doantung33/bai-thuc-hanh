package controller;

import model.DanhBa;

import java.io.*;
import java.util.ArrayList;

public class DocVaGhiFile {
    public static final String PATH = "contacts.csv";
    public static ArrayList<DanhBa> readFile() {
        ArrayList<DanhBa>danhBas = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            danhBas = (ArrayList<DanhBa>) obj.readObject();
            obj.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhBas;

    }
    private static final String COMA = ",";
    public static void writerFile (DanhBa danhBa){
        File file1 = new File(PATH);
        FileWriter fileWriter = null;
        try {
            if (!file1.exists()){
                System.out.println("Đã tạo file mới");
                file1.createNewFile();
            }
            fileWriter = new FileWriter(file1 , true);
            fileWriter.append(String.valueOf(danhBa.getSoDienThoai()));
            fileWriter.append(COMA);
            fileWriter.append(danhBa.getTen());
            fileWriter.append(COMA);
            fileWriter.append(String.valueOf(danhBa.getTuoi()));
            fileWriter.append(COMA);
            fileWriter.append(danhBa.getGioiTinh());
            fileWriter.append(COMA);
            fileWriter.append(danhBa.getDiaChi()+"\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter!=null){
                try {
                    System.out.println("Đã viết vào file");
                }catch (Exception e){
                    System.out.println();
                }
            }
        }
    }
}
