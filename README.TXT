 <div align="center">

# 🍄 Mario Games — Greenfoot Edition

### *Petualangan Klasik Mario, Dibangun Ulang dengan Java & Greenfoot*

Sebuah permainan platformer bergaya **Super Mario Bros**, dikembangkan menggunakan Java di atas *framework* **Greenfoot**. Lompat, kumpulkan koin, hindari musuh, dan capai akhir level untuk menyelamatkan sang putri!

![Java](https://img.shields.io/badge/Java-Language-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Greenfoot](https://img.shields.io/badge/Framework-Greenfoot-4E9A06?style=flat-square)
![Genre](https://img.shields.io/badge/Genre-2D%20Platformer-blueviolet?style=flat-square)
![License](https://img.shields.io/badge/License-Open%20Source-green?style=flat-square)

</div>

---

## 💡 Tentang Proyek

> *"Setiap loncatan membawamu lebih dekat ke istana."*

**Mario Games** adalah permainan platformer 2D sederhana bergaya *Super Mario Bros*, dibangun sebagai proyek pembelajaran menggunakan Java dan Greenfoot. Pemain mengendalikan karakter Mario yang berlari, melompat, menghindari musuh seperti Goomba dan Bowser, mengumpulkan koin, hingga akhirnya bertemu dengan Putri di akhir level.

## ✨ Fitur Utama

- 🏠 **Halaman Utama (Homepage)** — menu awal dengan tombol *Play* dan musik latar
- 🕹️ **Kontrol Mario** — gerak kiri/kanan dan lompat menggunakan keyboard
- 🌍 **Dunia yang Bisa Di-*scroll*** — level sepanjang 6500px dengan kamera mengikuti pergerakan Mario
- 🪙 **Sistem Koin & Skor** — kumpulkan koin untuk menambah skor
- 👾 **Musuh Interaktif** — hadapi Goomba dan Bowser yang dapat mengalahkan Mario
- 🧱 **Elemen Level Klasik** — pipa, blok, tangga bata, bukit, awan, dan semak khas dunia Mario
- 🚩 **Flagpole & Castle** — tanda akhir level untuk menyelesaikan permainan
- 👸 **Karakter Putri** — tujuan akhir petualangan Mario
- 💀 **Layar Game Over Animatif** — animasi Game Over dengan opsi restart (tekan *Space*/*Enter*)
- 🎵 **Musik & Efek Suara** — musik latar dan efek suara untuk lompat, koin, tabrakan, dan lainnya
- 🚪 **Tombol Keluar (Exit)** — kembali ke halaman utama kapan saja

## 🛠️ Tech Stack

<div align="center">

| Layer | Teknologi |
|:---:|:---:|
| **Bahasa** | Java |
| **Framework Game** | Greenfoot |
| **Grafis** | Sprite 2D (PNG/GIF) |
| **Audio** | WAV & MP3 (musik latar & efek suara) |

</div>

## 📦 Instalasi & Menjalankan

Karena proyek ini dibangun di atas **Greenfoot**, cara menjalankannya sedikit berbeda dari proyek Java biasa:

```bash
# 1. Clone repository
git clone https://github.com/alnafs23/Mario-Games.git
cd Mario-Games
```

**2. Unduh dan instal Greenfoot**
Unduh IDE Greenfoot secara gratis di situs resminya: [greenfoot.org](https://www.greenfoot.org/)

**3. Buka proyek**
- Jalankan Greenfoot
- Pilih **Open Project** dan arahkan ke folder `Mario-Games` (berisi file `project.greenfoot`)

**4. Jalankan permainan**
- Klik tombol **Run** / **Act** pada scenario **Homepage**
- Klik tombol **Play** pada layar utama untuk memulai permainan

## 🎮 Cara Bermain

| Tombol | Aksi |
|:---:|---|
| ⬅️ / ➡️ | Gerakkan Mario ke kiri/kanan |
| `Space` | Melompat |
| 🖱️ Klik | Interaksi dengan tombol menu (*Play*, *Exit*) |

**Tujuan permainan:**
1. Kumpulkan koin sebanyak mungkin sepanjang level
2. Hindari atau kalahkan musuh seperti Goomba dan Bowser
3. Capai *flagpole* dan istana di akhir level
4. Temukan Putri untuk menyelesaikan petualangan
5. Jika kalah, tekan `Space` atau `Enter` pada layar Game Over untuk kembali ke menu utama

## 📁 Struktur Proyek

```
Mario-Games/
├── MarioWorld.java        # Dunia utama permainan (scrolling, level, musik)
├── mario.java              # Logika karakter utama (gerak, skor, koin)
├── Homepage.java           # Halaman menu utama
├── Play.java / Exit.java   # Tombol navigasi (mulai/keluar)
├── GameOver.java           # Layar animasi Game Over
├── HUD.java                # Tampilan skor & informasi pemain
├── Goomba.java / bowser.java  # Musuh dalam permainan
├── coin.java / flag.java / flagpole.java  # Item & elemen level
├── princess.java           # Karakter tujuan akhir
├── block.java / brick.java / pipa*.java / castle.java  # Elemen dunia
├── *.png / *.gif           # Aset sprite & gambar
├── *.wav / *.mp3           # Musik & efek suara
├── project.greenfoot       # File konfigurasi proyek Greenfoot
└── README.md               # Dokumentasi proyek
```

## 🗺️ Rencana Pengembangan

- [ ] Penambahan level baru dengan tingkat kesulitan berbeda
- [ ] Sistem power-up (misalnya jamur, bunga api)
- [ ] Leaderboard skor tertinggi
- [ ] Efek transisi antar level yang lebih halus

## 🤝 Kontribusi

Kontribusi sangat terbuka bagi siapa saja yang ingin membantu mengembangkan proyek ini:

1. *Fork* repository ini
2. Buat branch fitur baru (`git checkout -b fitur-baru`)
3. *Commit* perubahan (`git commit -m 'Menambahkan fitur baru'`)
4. *Push* ke branch (`git push origin fitur-baru`)
5. Buka *Pull Request*

## 📄 Lisensi

Proyek ini bersifat **open source** dan dibuat untuk keperluan pembelajaran. Aset grafis dan audio bertema Mario digunakan untuk tujuan edukasi non-komersial.

---

<div align="center">

**Dibuat dengan 💙 oleh [alnafs23](https://github.com/alnafs23)**

</div>
