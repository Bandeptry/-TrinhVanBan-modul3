USE chuyenDoiERSangMoHinhQuanHe;
CREATE TABLE phieuNhap (
	soPX int not null primary key,
	ngayPX DATE 
 
);
CREATE TABLE chiTietPhieuXuat(
	DGXuat int not null,
    SLXuat int not null,
    soPX int primary key,
    maVTu int primary key,
    FOREIGN KEY (soPX) REFERENCES vatTu(maVTu),
    FOREIGN KEY (maVTu) REFERENCES phieuNhap(soPX)
);
CREATE TABLE vatTu(
	maVTu int primary key not null auto_increment,
	tenVTu varchar(50)
);

CREATE TABLE chiTietPhieuNhap(
	DGNhap int not null, 
    SLNhap varchar(50), 
    maVTu int primary key,
    soPhieuNhap int primary key,
    FOREIGN KEY (maVTu) REFERENCES phieuNhap(soPhieuNhap),
    FOREIGN KEY (soPhieuNhap) REFERENCES vatTu(maVTu)
);

CREATE TABLE phieuNhap(
	soPhieuNhap int primary key auto_increment,
    ngayNhap DATE 
);

CREATE TABLE chiTietDatHang(
	maVTu int primary key not null,
	soDH int not null primary key,
	FOREIGN KEY (maVTu) REFERENCES donDH(soDH),
    FOREIGN KEY (soDH) REFERENCES vatTu(maVTu)
); 

CREATE TABLE donDH(
	soDH int not null primary key auto_increment, 
    ngayDonHang DATE,
    FOREIGN KEY (soDH) REFERENCES nhacC(maNhacC)
);

CREATE TABLE nhacC(
	maNhacC int primary key, 
    tenNCC varchar(50) not null,
    diaChi varchar(50)
) ;

CREATE TABLE nhacC_SDT(
	maNhacC int primary key,
	soDienThoai varchar(50)
);