package com.example.lab3

open class Nguoi(val hoTen: String, val tuoi: Int, val queQuan: String, val maSoGV: String)


class CBGV(hoTen: String, tuoi: Int, queQuan: String, maSoGV: String,
           val luongCung: Double, val luongThuong: Double, val tienPhat: Double) : Nguoi(hoTen, tuoi, queQuan, maSoGV) {

    fun tinhLuongThucLinh(): Double {
        return luongCung + luongThuong - tienPhat
    }
}
class QuanLyKhoa {
    private val danhSachCBGV = mutableListOf<CBGV>()

    fun themCBGV() {
        println("Nhập thông tin cán bộ giáo viên:")
        print("Họ tên: ")
        val hoTen = readLine()!!
        print("Tuổi: ")
        val tuoi = readLine()!!.toInt()
        print("Quê quán: ")
        val queQuan = readLine()!!
        print("Mã số giáo viên: ")
        val maSoGV = readLine()!!
        print("Lương cứng: ")
        val luongCung = readLine()!!.toDouble()
        print("Lương thưởng: ")
        val luongThuong = readLine()!!.toDouble()
        print("Tiền phạt: ")
        val tienPhat = readLine()!!.toDouble()

        val giaoVien = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)

        if (danhSachCBGV.none { it.maSoGV == giaoVien.maSoGV }) {
            danhSachCBGV.add(giaoVien)
            println("Thêm cán bộ giáo viên thành công.")
        } else {
            println("Mã số giáo viên đã tồn tại.")
        }
    }

    fun xoaCBGV() {
        print("Nhập mã số giáo viên cần xoá: ")
        val maSoGV = readLine()!!

        val giaoVien = danhSachCBGV.find { it.maSoGV == maSoGV }
        if (giaoVien != null) {
            danhSachCBGV.remove(giaoVien)
            println("Xoá cán bộ giáo viên thành công.")
        } else {
            println("Không tìm thấy cán bộ giáo viên có mã số $maSoGV.")
        }
    }
    fun xemDanhSachCBGV() {
        if (danhSachCBGV.isEmpty()) {
            println("Danh sách cán bộ giáo viên trống.")
        } else {
            println("Danh sách cán bộ giáo viên:")
            for ((index, giaoVien) in danhSachCBGV.withIndex()) {
                println("${index + 1}. Họ tên: ${giaoVien.hoTen}, Tuổi: ${giaoVien.tuoi}, Quê quán: ${giaoVien.queQuan}, Mã số giáo viên: ${giaoVien.maSoGV}, Lương thực lĩnh: ${giaoVien.tinhLuongThucLinh()} VND")
            }
        }
    }

}


// Sử dụng
fun main() {
    val quanLyKhoa = QuanLyKhoa()

    var choice: Int=0
    do {
        println("----- Chương Trình Quản Lý Sinh Viên -----")
        println("1. Thêm cán bộ giáo viên")
        println("2. Xóa cán bộ giáo viên")
        println("3. Xem danh sách cán bộ giáo viên")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
        val s = readLine()
        if (s != null) choice = s.toInt()
        when (choice) {
            1 -> quanLyKhoa.themCBGV()
            2 -> quanLyKhoa.xoaCBGV()
            3 -> quanLyKhoa.xemDanhSachCBGV()
            0 -> println("Đã thoát chương trình.")
            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
        }
    } while (choice != 0)
}
