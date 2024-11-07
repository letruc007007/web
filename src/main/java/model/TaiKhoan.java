/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {

    private int id;
    private String tendangnhap;
    private String matkhau;

    // Constructor
    public TaiKhoan(String tendangnhap, String matkhau) {
        this.id = id;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "TaiKhoan{"
                + "id=" + id+ ", tendangnhap='" + tendangnhap + '\''+ ", matkhau='" + matkhau + '\''+ '}';
    }
}
