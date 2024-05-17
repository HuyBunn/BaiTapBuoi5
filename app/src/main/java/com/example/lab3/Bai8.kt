package com.example.lab3

import java.time.LocalDate

class SinhVien(val hoTen: String, val tuoi: Int, val lop: String)

class TheMuon(val maPhieuMuon: String, val ngayMuon: String, val hanTra: String, val soHieuSach: Int, val sinhVien: SinhVien) {
    override fun toString(): String {
        return "Mã phiếu mượn: $maPhieuMuon, Ngày mượn: $ngayMuon, Hạn trả: $hanTra, Số hiệu sách: $soHieuSach, Sinh viên mượn sách: ${sinhVien.hoTen}"
    }
}

class QuanLyTheMuon {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon() {
        println("Nhập thông tin phiếu mượn sách:")
        print("Mã phiếu mượn: ")
        val maPhieuMuon = readLine()!!
        print("Ngày mượn (yyyy-MM-dd): ")
        val ngayMuon = readLine()!!
        print("Hạn trả (yyyy-MM-dd): ")
        val hanTra = readLine()!!
        print("Số hiệu sách: ")
        val soHieuSach = readLine()!!.toInt()
        print("Họ tên sinh viên: ")
        val hoTenSV = readLine()!!
        print("Tuổi: ")
        val tuoiSV = readLine()!!.toInt()
        print("Lớp: ")
        val lopSV = readLine()!!

        val sinhVien = SinhVien(hoTenSV, tuoiSV, lopSV)
        val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
        themTheMuon(theMuon)
    }

    fun xoaTheMuon() {
        print("Nhập mã phiếu mượn cần xoá: ")
        val maPhieuMuon = readLine()!!
        xoaTheMuon(maPhieuMuon)
    }

    fun hienThiDanhSachTheMuon() {
        if (danhSachTheMuon.isEmpty()) {
            println("Danh sách thẻ mượn trống.")
        } else {
            println("Danh sách thẻ mượn:")
            for ((index, theMuon) in danhSachTheMuon.withIndex()) {
                println("${index + 1}. $theMuon")
            }
        }
    }

    private fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    private fun xoaTheMuon(maPhieuMuon: String) {
        val theMuon = danhSachTheMuon.find { it.maPhieuMuon == maPhieuMuon }
        if (theMuon != null) {
            danhSachTheMuon.remove(theMuon)
            println("Xoá phiếu mượn thành công.")
        } else {
            println("Không tìm thấy phiếu mượn có mã $maPhieuMuon.")
        }
    }
}


fun main() {
    val quanLyTheMuon = QuanLyTheMuon()

    var choice: Int=0
    do {
        println("----- Chương Trình Quản Lý Mượn Trả Sách -----")
        println("1. Thêm phiếu mượn sách")
        println("2. Xoá phiếu mượn sách")
        println("3. Xem danh sách phiếu mượn sách")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
        val s = readLine()
        if (s != null) choice = s.toInt()

        when (choice) {
            1 -> quanLyTheMuon.themTheMuon()
            2 -> quanLyTheMuon.xoaTheMuon()
            3 -> quanLyTheMuon.hienThiDanhSachTheMuon()
            0 -> println("Đã thoát chương trình.")
            else -> println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
        }
    } while (choice != 0)
}
