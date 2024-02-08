# Final Proyek Struktur Data
<ul>
  <li>Mata Kuliah: Struktur Data</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Kelompok
<ul>
  <li>Kelompok: 12</li>
  <li>Proyek: Sistem Voting</li>
  <li>Anggota:</li>
  <ul>
    <li>Ketua: <a href="https://github.com/HirapuAH">Hilbram Ramadhan Putra</a></li>
    <li>Anggota 1: <a href=""> M Syahdanu Al Ghifary</a></li>
    <li>Anggota 2: <a href=""> Muhammad Mulqi Sapi'i</a></li>
  </ul>
</ul>

## Judul Proyek
<p>SISTEM VOTING</p>

## Penjelasan Proyek
<p>Program ini merupakan aplikasi sederhana untuk melakukan voting atau pemilihan, di mana peserta dapat memilih<br>kandidat (paslon) pada beberapa kategori tertentu, misalnya ada peserta voting bernama Joshua,<br>Tersedia 3 contoh Kategori yaitu :<br>- CaPres<br>- DPR<br>- BumDes<br>Dia memilih Kategoti yaitu CaPres (Calon Presiden) setelah memilih Kategori yang diinginkan, selanjutnya dia<br>memilih salah satu Paslon Yaitu :<br>- Hj Ujang<br>- Hj Maman<br>Dan Joshua memilih Paslon urutan pertama yaitu Hj Ujang.Setelah Melakukan Vote nanti data Votenya akan<br>tersimpan di riwayat Voting dan sebagai bukti bahwa Joshua telah menjalankan / Melakukan Voting dengan<br>Kategori dan Paslon yang telah dipilih.</p>

## Komponen Proyek
<p><h4>1. Menu Pilih Peserta</h4></p>
<p>Materi record class peserta array list Record class peserta di gunakan untuk merepresentasikan peserta dengan atribut nama ,id ,dan status Array list fungsinya untuk ‘class buatDataPeserta()’ yang di gunakan untuk menyimpan data peserta.Serta setiap peserta yang direpresentasikan sebagai objek dari record class’peserta’.
</p>
<p><h4>2. Menu Kategori dan Paslon</h4></p>
<p>Materi Record Class paslon,kategori,List,dan arrayListRecord class paslon,kategori, dan pengguna list untuk menyimpan dataMateri array list fungsi nya untuk menyimpan data paslon setiap paslon direpresentasikan sebagai objek dari record class ‘paslon’
</p>
<p><h4>3. Menu Mulai Voting</h4></p>
<p><h4># Materi : Queue, Scanner, dan Record Class Suara, arrayList</h4></p>
<p>
•	Penggunaan Queue untuk menyimpan riwayat suara.<br>
•	Penggunaan Scanner untuk input pengguna.<br>
•	Record class Suara untuk merepresentasikan suara yang diberikan peserta.<br>
•	Fungsi voting menggunakan ArrayList untuk menyimpan pilihan peserta dalam suatu kategori pemilihan.<br>
# Fungsi:<br>
•	Memungkinkan peserta untuk memberikan suara dalam kategori dan paslon yang dipilih.<br>
•	Memperbarui jumlah suara paslon setelah voting.<br>
•	Fungsi buatDataKategori() menggunakan ArrayList untuk menyimpan data kategori pemilihan.<br>
•	Setiap kategori direpresentasikan sebagai objek dari record class Kategori.<br>
•	ArrayList kategoriList diinisialisasi dan diisi dengan objek-objek kategori.
</p>
<p><h4>4. Menu Lihat Hasil Voting</h4></p>
<p>
#	Materi: List dan Iterasi<br>
•	Penggunaan List untuk menyimpan data hasil voting.<br>
•	Iterasi untuk menampilkan hasil voting.<br>
#	Fungsi:<br>
•	Menampilkan jumlah suara yang diterima oleh setiap pasangan calon dalam setiap kategori pemilihan.
</p>
<p><h4>5. Menu Lihat Riwayat Voting</h4></p>
<p>
#	Materi: Queue, Record Class Suara, dan Iterasi,linkedlist<br>
•	Fungsi lihatRiwayatVoting() menggunakan LinkedList (Queue) untuk menyimpan riwayat suara.<br>
•	Saat suara diberikan, objek Suara ditambahkan ke LinkedList riwayatSuara.<br>
•	Penggunaan Queue untuk menyimpan riwayat suara.<br>
•	Record class Suara untuk merepresentasikan suara yang diberikan peserta.<br>
•	Iterasi untuk menampilkan riwayat voting.<br>
#	Fungsi:<br>
•	Menampilkan detail suara yang diberikan oleh setiap peserta beserta kategori dan paslon yang dipilih.
</p>
<p><h4>6. Menu Cari Kategori</h4></p>
<p>
#	Materi: List, Record Class Kategori, dan Iterasi<br>
•	Penggunaan List untuk menyimpan data kategori.<br>
•	Record class Kategori untuk merepresentasikan kategori pemilihan.<br>
•	Iterasi untuk mencari kategori berdasarkan nama.<br>
#	Fungsi:<br>
•	Memungkinkan pengguna untuk mencari kategori dan menampilkan paslon dalam kategori tersebut.
</p>
<p><h4>7. Menu Cari Peserta Yang Menyoblos</h4></p>
<p>
#	Materi: Queue, Record Class Suara, dan Iterasi<br>
•	Penggunaan Queue untuk menyimpan riwayat suara.<br>
•	Record class Suara untuk merepresentasikan suara yang diberikan peserta.<br>
•	Iterasi untuk mencari peserta berdasarkan nama dan menampilkan detailnya.<br>
#	Fungsi:<br>
•	Memungkinkan pengguna untuk mencari peserta yang telah memberikan suara.
</p>
<p><h4>8. Menu Keluar</h4></p>
<p>
#	Materi: Loop dan Penggunaan boolean<br>
•	Penggunaan loop untuk menjalankan program secara berulang.<br>
•	Penggunaan boolean untuk mengontrol keluar dari loop utama.<br>
#	Fungsi:<br>
•	Mengakhiri program dengan memberikan pesan terima kasih kepada pengguna.
</p>

## Pembagian Tim
<p>Hilbram Ramadhan Putra : Dokumentasi dan Perancangan Apliksi</p>
<p>M Syahdanu Al Ghifary  : Editing Video dan Mengatur persiapan presentasi</p>
<p>Muhammad Mulqi Sapi'i  : Perancangan Aplikasi dan Ide-ide Aplikasi</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/HirapuAH/STTB_kel12_223PA/blob/main/votings/src/main/java/votings/Votings.java">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/0DU_meaq368?si=HuBg_e0cf_aygzj9">Youtube</a></li>
</ul>
