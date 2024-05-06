package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class KhoiDau {
    public static int LuaChonTaiXiu(int luaChonTaiXiu,Scanner sc) {
        do{
            System.out.println("******** Chọn: (1) <-> Tài || (2) <-> Xỉu");
            luaChonTaiXiu = sc.nextInt();
        } while(luaChonTaiXiu != 1 && luaChonTaiXiu != 2);

        return luaChonTaiXiu;
    }
    public static double VeTai(int luaChonTaiXiu, int tong, double taiKhoanNguoiChoi, double datCuoc, NumberFormat numf) {
        System.out.println("******** Tổng là: " + tong + " => Tài");
        if (luaChonTaiXiu == 1){
            System.out.println("******** Bạn đã thắng cược");
            taiKhoanNguoiChoi += datCuoc;
            System.out.println("******** Tài khoản của bạn là: " + numf.format(taiKhoanNguoiChoi));

        } else {
            System.out.println("******** Bạn đã thua cược");
            taiKhoanNguoiChoi -= datCuoc;
            System.out.println("******** Tài khoản của bạn là: " + numf.format(taiKhoanNguoiChoi));
        }
        return taiKhoanNguoiChoi;
    }
    public static double VeXiu(int luaChonTaiXiu, int tong, double taiKhoanNguoiChoi, double datCuoc, NumberFormat numf) {
        System.out.println("******** Tổng là: " + tong + " => Xỉu");
        if (luaChonTaiXiu == 2) {
            System.out.println("******** Bạn đã thắng cược");
            taiKhoanNguoiChoi += datCuoc;
            System.out.println("******** Tài khoản của bạn là: " + numf.format(taiKhoanNguoiChoi));

        } else {
            System.out.println("******** Bạn đã thua cược");
            taiKhoanNguoiChoi -= datCuoc;
            System.out.println("******** Tài khoản của bạn là: " + numf.format(taiKhoanNguoiChoi));
        }
        return taiKhoanNguoiChoi;
    }
}
