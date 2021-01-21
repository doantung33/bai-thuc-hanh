package controller;

import model.DanhBa;

import java.util.ArrayList;

public class TinhToan {
    ArrayList<DanhBa>danhBas;

    public TinhToan(ArrayList<DanhBa> danhBas) {
        this.danhBas = danhBas;
    }

    public void add(DanhBa danhBa) {
        danhBas=DocVaGhiFile.readFile();
        danhBas.add(danhBa);
//        DocVaGhiFile.writerFile(danhBa);
    }
    public void delete(int soDT) {
        for (DanhBa d :
                danhBas) {
            if (soDT==(d.getSoDienThoai())){
                danhBas.remove(soDT);
            }
        }
        System.out.println("Đã xóa");

    }
    public void search(String ten) {
        for (DanhBa danhBa:
             danhBas) {
            if (ten.equals(danhBa.getTen())){
                System.out.println(danhBa.toString());
            }
        }
    }public void show() {
        for (DanhBa danhBa:
             danhBas) {
            if (danhBa instanceof DanhBa){
                System.out.println(danhBa.toString());
            }
        }

    }
    public void edit(DanhBa danhBa) {
        DocVaGhiFile.writerFile(danhBa);
    }
}
