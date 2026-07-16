<div align="center">

# 🍄 Mario Games

### *Melompat, Berlari, dan Menyelamatkan Sang Putri*

Sebuah platformer 2D bergaya retro yang dibangun murni menggunakan **Java** di atas framework **Greenfoot**, menghadirkan kembali sensasi berlari, melompat, dan mengumpulkan koin ala game klasik era 8-bit.

![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Greenfoot](https://img.shields.io/badge/Greenfoot-Engine-4C9A2A?style=flat-square&logo=java&logoColor=white)
![Genre](https://img.shields.io/badge/Genre-Platformer-6C63FF?style=flat-square)
![License](https://img.shields.io/badge/License-Open%20Source-3DDC84?style=flat-square)

</div>

---

## 💡 Tentang Proyek

> *"Satu lompatan, satu koin, satu langkah lebih dekat kepada Sang Putri."*

Jauh sebelum grafis 3D dan physics engine canggih ada, satu formula sederhana sudah cukup untuk membuat jutaan orang jatuh cinta: **lari, lompat, kumpulkan koin, kalahkan musuh, selamatkan sang putri**. **Mario Games** menghidupkan kembali formula legendaris itu lengkap dengan dunia yang bergulir mulus (*side-scrolling*), musuh yang berpatroli, blok misteri yang menyimpan koin, hingga Bowser yang menghadang di jalan menuju Puri.

Lebih dari sekadar game, proyek ini adalah etalase pemrograman berorientasi objek (OOP) dalam praktik nyata setiap elemen dunia (Goomba, pipa, awan, bukit, blok) adalah `Actor` mandiri dengan perilaku dan animasinya sendiri, semua diatur rapi oleh satu `World` utama yang menangani scrolling, waktu, skor, dan nyawa secara *real-time*.

| 🎯 Tujuan | 🕹️ Pengalaman yang Dihadirkan |
|---|---|
| Merekonstruksi mekanik platformer klasik era 8-bit | Sensasi nostalgia yang akrab di tangan siapa pun |
| Menerapkan physics sederhana (gravitasi & momentum lompatan) | Pergerakan karakter yang terasa ringan namun presisi |
| Membangun dunia scrolling dinamis sepanjang 6.500px | Level luas yang tetap terasa ringan dan mulus dimainkan |
| Merancang arsitektur berbasis Actor (OOP) | Kode yang rapi, modular, dan mudah dikembangkan lebih jauh |

---

## 🌟 Fitur Utama

- 🎮 **Kendali Gesit** — gerak kiri/kanan dengan tombol panah, melompat seringan menekan `Space`
- 🗺️ **Dunia yang Hidup dan Bergulir** — kamera mengikuti setiap langkah Mario di sepanjang level raksasa
- 👾 **Barisan Musuh** — Goomba yang setia berpatroli, hingga Bowser sebagai penjaga akhir dengan gerak khasnya
- ❓ **Blok Misteri (`tanya`)** — ketuk dari bawah, dan koin pun berhamburan untuk dikumpulkan
- 🧱 **Dunia Kaya Detail** — bata, balok, pipa hijau ikonik, bukit, semak, dan awan yang menghiasi latar
- 🚩 **Garis Akhir Penuh Kemenangan** — sentuh *flagpole* di ujung level untuk memicu animasi juara
- 👸 **Sang Putri Menanti** — muncul dan mengikuti langkah Mario begitu level berhasil ditaklukkan
- ❤️ **Taruhan Nyawa** — 3 kesempatan hidup, berkurang setiap kali tersentuh musuh atau terjatuh ke jurang
- 📊 **HUD Sigap** — skor, jumlah koin, sisa waktu, dan nyawa tersaji langsung tanpa jeda
- 💀 **Game Over yang Dramatis** — animasi frame-by-frame saat nyawa habis, dengan opsi coba lagi secepatnya
- 🖥️ **Gerbang Pembuka** — halaman *Homepage* dengan tombol Play & Exit, disambut musik latar penuh nostalgia
- 🔊 **Panggung Suara** — musik latar, efek lompat, dentingan koin, ledakan, hingga tema kemenangan

---

## 🛠️ Tech Stack

| Layer | Teknologi |
|---|---|
| Bahasa | Java |
| Engine / Framework | Greenfoot |
| Arsitektur | Object-Oriented (kelas `Actor` & `World`) |
| Audio | `GreenfootSound` (WAV & MP3) |
| Grafis | `GreenfootImage` (PNG, GIF, JPG) dengan animasi frame manual |

---

## 📦 Instalasi & Menjalankan

```bash
# 1. Clone repository
git clone https://github.com/<username>/Mario-Games.git
cd Mario-Games

# 2. Buka dengan Greenfoot
# Unduh Greenfoot IDE terlebih dahulu di https://www.greenfoot.org
# Lalu jalankan Greenfoot, pilih "Open Project", dan arahkan ke folder ini
```

> ⚠️ Pastikan seluruh berkas aset (`*.png`, `*.gif`, `*.wav`, `*.mp3`) tetap berada dalam satu direktori bersama berkas `.java`, agar Greenfoot dapat memuat gambar dan suara dengan sempurna.

---

## 🖥️ Cara Bermain

Mulai dari klik pertama hingga bendera kemenangan berkibar:

1. Buka proyek di Greenfoot, lalu klik **Compile**
2. Klik **Run** — halaman *Homepage* akan menyambut dengan musik latar
3. Klik tombol **Play** untuk melangkah masuk ke dunia Mario
4. Gunakan `←` `→` untuk berlari, `Space` atau `↑` untuk melompat
5. Ketuk Blok Misteri dari bawah untuk memanen koin
6. Injak musuh dari atas untuk mengalahkannya — hindari benturan langsung dari samping
7. Raih *flagpole* di ujung level untuk merayakan kemenangan, atau klik **Exit** kapan saja untuk kembali ke menu utama

### 🕹️ Kontrol Permainan

| Tombol | Aksi |
|---|---|
| `←` / `→` | Berlari ke kiri / kanan |
| `Space` atau `↑` | Melompat |
| Klik Mouse | Menekan tombol menu (Play / Exit) |

---

## 📁 Struktur Proyek

```
Mario-Games-main/
├── Homepage.java               # Menu utama & musik pembuka
├── Play.java / Exit.java       # Tombol navigasi menu
├── MarioWorld.java             # Dunia utama: scrolling, HUD, skor, waktu
├── mario.java                  # Logika karakter utama (gerak, lompat, nyawa, animasi)
├── Goomba.java / bowser.java   # Musuh: patroli & pola serangan
├── coin.java / tanya.java      # Koin & Blok Misteri
├── flag.java / flagpole.java / castle.java   # Elemen akhir level
├── princess.java                # Karakter yang diselamatkan
├── HUD.java                     # Tampilan skor, koin, waktu, nyawa
├── GameOver.java                # Layar animasi kalah
├── block.java / brick.java / pipa*.java / Ground.java   # Elemen level & tabrakan
├── hill*.java / bush*.java / cloud*.java     # Dekorasi latar (parallax sederhana)
├── *.png / *.gif / *.jpg        # Aset sprite & latar
├── *.wav / *.mp3                # Efek suara & musik latar
└── README.TXT                   # Catatan proyek asli (dokumentasi standar Greenfoot)
```

---

## 🗺️ Rencana Pengembangan

- [ ] Multi-level dengan sistem transisi antar dunia
- [ ] Power-up (Mushroom, Fire Flower) untuk transformasi Mario
- [ ] Leaderboard skor tertinggi berbasis penyimpanan lokal
- [ ] Mode multiplayer lokal (2 pemain bergantian atau berdampingan)
- [ ] Ekspor build mandiri (`.jar`) agar tak lagi bergantung pada Greenfoot IDE

---

## 🤝 Kontribusi

Kontribusi sangat terbuka bagi siapa saja yang ingin membantu mengembangkan proyek ini:

1. Fork repository ini
2. Buat branch fitur baru (`git checkout -b fitur-baru`)
3. Commit perubahan (`git commit -m 'Menambahkan fitur baru'`)
4. Push ke branch (`git push origin fitur-baru`)
5. Buka Pull Request

---

## 📄 Lisensi

Proyek ini bersifat open source dan bebas digunakan untuk keperluan pembelajaran maupun pengembangan lebih lanjut.

<div align="center">

Dibuat dengan 💙 menggunakan Java & Greenfoot — *"It's-a me, Mario!"*

</div>
