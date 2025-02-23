# Tugas Kecil 1 IF2211 Strategi Algoritma 
## Penyelesaian IQ Puzzler Pro dengan Algoritma Brute Force
| NIM | Nama |
| :---: | :---: |
| 13523019 | Shannon Aurellius Anastasya Lie |

### Penjelasan Singkat Program

IQ Puzzler Pro adalah permainan papan yang diproduksi oleh perusahaan Smart Games. Tujuan dari permainan ini adalah pemain harus dapat mengisi seluruh papan dengan 
piece (blok puzzle) yang telah tersedia.
Komponen penting dari permainan IQ Puzzler Pro terdiri dari:
1. Board (Papan) – Board merupakan komponen utama yang menjadi tujuan permainan dimana pemain harus mampu mengisi seluruh area papan menggunakan blok-blok yang
telah disediakan.
2. Blok/Piece – Blok adalah komponen yang digunakan pemain untuk mengisi papan kosong hingga terisi penuh. Setiap blok memiliki bentuk yang unik dan semua blok harus
digunakan untuk menyelesaikan puzzle.

Program ini merupakan solver untuk permainan IQ Puzzler Pro menggunakan algoritma Brute Force. Program akan membaca papan permainan dari file input yang berisi ukuran papan dan daftar blok yang harus ditempatkan. Kemudian, program akan mencari cukup satu solusi dari permainan IQ Puzzler Pro dengan menggunakan algoritma Brute Force, atau menampilkan bahwa solusi tidak
ditemukan jika tidak ada solusi yang mungkin dari puzzle.

Fitur utama dari program ini:
- Membaca input dari file teks.
- Menampilkan solusi dalam format teks berwarna.
- Menyimpan solusi dalam file teks.
- Menyimpan solusi dalam bentuk gambar.

### Struktur Program

```bash
.
├── bin       # Berisi file class hasil kompilasi
│ ├── Block.class
│ ├── Input.class
│ ├── Main.class
│ ├── Output.class
│ ├── Solve.class
│
├── doc       # Dokumentasi proyek
│ ├── Tucil1_K1_13523019_Shannon Aurellius Anastasya Lie.pdf
│
├── src # Kode sumber utama
│ ├── Block.java
│ ├── Input.java
│ ├── Main.java
│ ├── Output.java
│ ├── Solve.java
│
├── test       # Berisi file uji coba
│ ├── input    # File input untuk pengujian
│ │ ├── case1.txt
│ │ ├── case2.txt
│ │ ├── case3.txt
│ │ ├── case4.txt
│ │ ├── case5.txt
│ │ ├── case6.txt
│ │ ├── case7.txt
│ │
│ ├── output    # Hasil dari program berdasarkan input uji
│ │ ├── image   # Gambar solusi dari tiap kasus
│ │ │ ├── solusiCase1.png
│ │ │ ├── solusiCase2.png
│ │ │ ├── solusiCase3.png
│ │ │ ├── solusiCase4.png
│ │ │ ├── solusiCase5.png
│ │ │ ├── solusiCase6.png
│ │ │ ├── solusiCase7.png
│ │ │
│ │ ├── text   # Hasil solusi dalam bentuk teks
│ │ │ ├── solusiCase1.txt
│ │ │ ├── solusiCase2.txt
│ │ │ ├── solusiCase3.txt
│ │ │ ├── solusiCase4.txt
│ │ │ ├── solusiCase5.txt
│ │ │ ├── solusiCase6.txt
│ │ │ ├── solusiCase7.txt
│
├── README.md   # Dokumentasi proyek
```

### Requirement dan Instalasi
Program ini dibuat menggunakan Java. Untuk menjalankannya, pastikan sistem sudah terinstal:
- Java Development Kit (JDK) 8 atau lebih baru
- IDE atau Terminal untuk menjalankan kode Java
- ImageIO library untuk menyimpan solusi dalam bentuk gambar (sudah termasuk dalam Java SE)

### Cara Menjalankan Program

```shell
git clone 'https://github.com/shanlie20/Tucil1_13523019'
javac -d bin src/*.java
java -cp bin Main
```

### Penjelasan

1. Cloning repositori dengan cara `git clone 'https://github.com/shanlie20/Tucil1_13523019'` di terminal
> [!NOTE]
> Pastikan `java` dan `javac` sudah terinstall yang dapat dicek dengan cara
> ```shell
> java -version
> javac -version
> ```

2. Jalankan :
`javac -d bin src/*.java`

3. Jalankan : `java -cp bin Main`
