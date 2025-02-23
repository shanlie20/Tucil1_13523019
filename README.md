# Tugas Kecil 1 IF2211 Strategi Algoritma 
## Penyelesaian IQ Puzzler Pro dengan Algoritma Brute Force
| NIM | Nama |
| :---: | :---: |
| 13523019 | Shannon Aurellius Anastasya Lie |

### Tentang Projek

IQ Puzzler Pro adalah permainan papan yang diproduksi oleh perusahaan Smart Games. Tujuan dari permainan ini adalah pemain harus dapat mengisi seluruh papan dengan 
piece (blok puzzle) yang telah tersedia.
Komponen penting dari permainan IQ Puzzler Pro terdiri dari:
1. Board (Papan) – Board merupakan komponen utama yang menjadi tujuan permainan dimana pemain harus mampu mengisi seluruh area papan menggunakan blok-blok yang
telah disediakan.
2. Blok/Piece – Blok adalah komponen yang digunakan pemain untuk mengisi papan kosong hingga terisi penuh. Setiap blok memiliki bentuk yang unik dan semua blok harus
digunakan untuk menyelesaikan puzzle.

Tugas program ini adalah menemukan cukup satu solusi dari permainan IQ Puzzler Pro dengan menggunakan algoritma Brute Force, atau menampilkan bahwa solusi tidak
ditemukan jika
tidak ada solusi yang mungkin dari puzzle.

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

### Cara Menjalankan Program

```shell
git clone 'https://github.com/shanlie20/Tucil1_13523019'
javac -d bin src/*.java
java -cp bin Main
```

### Penjelasan

1. Cloning repositori dengan cara `git clone 'https://github.com/shanlie20/Tucil1_13523019'` di terminal

2. Jalankan :
`javac -d bin src/*.java`
> [!NOTE]
> Pastikan Java sudah terinstall
3. Jalankan : `java -cp bin Main`
