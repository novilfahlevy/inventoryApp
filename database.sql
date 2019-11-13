CREATE TABLE `pemasok` (
  `id_pemasok` int PRIMARY KEY,
  `nama` text,
  `id_truck` int,
  `merk` text,
  `no_telp` text,
  `id_barang` int,
  `jenis` text
);

CREATE TABLE `staff` (
  `id_staff` int PRIMARY KEY,
  `nama` text,
  `jobdesc` text
);

CREATE TABLE `barang` (
  `id_barang` int PRIMARY KEY,
  `merk` text,
  `jenis` text,
  `id_pemasok` int,
  `id_staff` int,
  `harga_beli` int
);

CREATE TABLE `gudang` (
  `id_gudang` int PRIMARY KEY,
  `id_barang` int,
  `jumlah` int,
  `id_staff` int
);

ALTER TABLE `staff` ADD FOREIGN KEY (`id_staff`) REFERENCES `gudang` (`id_gudang`);

ALTER TABLE `pemasok` ADD FOREIGN KEY (`id_pemasok`) REFERENCES `staff` (`id_staff`);

ALTER TABLE `pemasok` ADD FOREIGN KEY (`id_pemasok`) REFERENCES `barang` (`id_barang`);

ALTER TABLE `barang` ADD FOREIGN KEY (`id_barang`) REFERENCES `gudang` (`id_gudang`);

ALTER TABLE `barang` ADD FOREIGN KEY (`id_barang`) REFERENCES `staff` (`id_staff`);
