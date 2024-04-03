select* from Sach	
select* from SachChiTiet;
select * from HinhAnh
Alter table Sach
Add QR nvarchar(255);


UPDATE Sach
SET QR = 'SCT001'
WHERE idSach = 1;

alter PROCEDURE [dbo].[getSPCTtheoQR] 
    @qr NVARCHAR(255)
AS
BEGIN
    SELECT 
        Sach.MaSach,
        SachChiTiet.MaSachChiTiet,
        Sach.TenSach,
        TacGia.TenTacGia,
        TheLoai.TenTheLoai,
        NhaCungCap.TenNhaCungCap,
        HinhAnh.Ten AS HinhAnhTen,
        NhaXuatBan.TenNhaXuatBan,
        SachChiTiet.DonGia,
        SachChiTiet.SoLuong,
        SachChiTiet.NgayTao,
        SachChiTiet.TrangThai,
        SachChiTiet.NgaySua,
        SachChiTiet.MoTa 
    FROM 
        Sach 
    JOIN 
        SachChiTiet ON Sach.idSach = SachChiTiet.idSach 
    JOIN 
        HinhAnh ON SachChiTiet.idHinhAnh = HinhAnh.idHinhAnh 
    JOIN 
        NhaCungCap ON SachChiTiet.idNhaCungCap = NhaCungCap.idNhaCungCap 
    JOIN 
        NhaXuatBan ON SachChiTiet.idNhaXuatBan = NhaXuatBan.idNhaXuatBan 
    JOIN 
        TacGia ON SachChiTiet.idTacGia = TacGia.idTacGia 
    JOIN 
        TheLoai ON SachChiTiet.idTheLoai = TheLoai.idTheLoai 
    WHERE 
        SachChiTiet.QR = @qr;
END
GO


EXEC getSPCTtheoQR @qr = 'SCT001';






