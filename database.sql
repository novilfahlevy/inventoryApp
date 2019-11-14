CREATE TABLE `pemasok` (
  `id_pemasok` int PRIMARY KEY,
  `nama` text,
  `merk` text,
  `no_telp` text
);

CREATE TABLE `staff` (
  `id_staff` int PRIMARY KEY,
  `nama` text,
  `bidang` text
);

CREATE TABLE `barang` (
  `id_barang` int PRIMARY KEY,
  `merk` text,
  `id_jenis` int,
  `jumlah` int,
  `harga` int,
  `id_pemasok` int,
  `id_staff` int
);

CREATE TABLE `users` (
  `id` int PRIMARY KEY,
  `nama_lengkap` text,
  `email` text.
  `password` text
);

CREATE TABLE `jenis_barang` (
  `id` int PRIMARY KEY,
  `nama` text
);