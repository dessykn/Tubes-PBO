/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author user
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

public class Aplikasi {

    private ArrayList<Dosen> daftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<KelompokTA> daftarKelompok = new ArrayList<KelompokTA>();
    private ArrayList<TugasAkhir> daftarTugasAkhir = new ArrayList<TugasAkhir>();

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }

    public Mahasiswa getMahasiswa(long nim) throws FileNotFoundException, IOException, ClassNotFoundException {
        Mahasiswa satu = null;
        FileInputStream fis = new FileInputStream("Data Mahasiswa.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < 50; i++) {
                if (daftarMahasiswa.get(i).getNim() == nim) {
                    satu = daftarMahasiswa.get(i);
                }
            }
        }
        return satu;
    }

    public void deleteMahasiswa(long nim) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Mahasiswa.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarMahasiswa.size(); i++) {
                    if (daftarMahasiswa.get(i).getNim() == nim) {
                        daftarMahasiswa.remove(i);
                    }
                }
            }
        }
    }

    public Dosen getDaftarDosen(long nip) throws FileNotFoundException, IOException, ClassNotFoundException {
        Dosen dua = null;
        FileInputStream fis = new FileInputStream("Data Mahasiswa.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < daftarDosen.size(); i++) {
                if (daftarDosen.get(i).getNip() == nip) {
                    dua = daftarDosen.get(i);
                }
            }
        }
        return dua;
    }

    public void deleteDosen(long nip) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Dosentxt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarDosen.size(); i++) {
                    if (daftarDosen.get(i).getNip() == nip) {
                        daftarDosen.remove(i);
                    }
                }
            }
        }
    }

    public KelompokTA getKelompok(String topik) throws FileNotFoundException, IOException, ClassNotFoundException {
        KelompokTA tiga = null;
        FileInputStream fis = new FileInputStream("Data Mahasiswa.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < daftarKelompok.size(); i++) {
                if (daftarKelompok.get(i).getTopik().equals(topik)) {
                    tiga = daftarKelompok.get(i);
                }
            }
        }
        return tiga;
    }

    public void deleteKelompok(String nama) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Kelompok TA.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarKelompok.size(); i++) {
                    if (daftarKelompok.get(i).getNamaKelompok().equals(nama)) {
                        daftarKelompok.remove(i);
                    }
                }
            }
        }
    }

    public void setKelompok(KelompokTA kelompok) {
        daftarKelompok.add(kelompok);
    }

    public TugasAkhir getTugas(String judul) throws FileNotFoundException, IOException, ClassNotFoundException {
        TugasAkhir empat = null;
        FileInputStream fis = new FileInputStream("Data Mahasiswa.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (ois.readObject() != null) {
            for (int i = 0; i < daftarTugasAkhir.size(); i++) {
                if (daftarTugasAkhir.get(i).getJudul().equals(judul)) {
                    empat = daftarTugasAkhir.get(i);
                }
            }
        }
        return empat;
    }

    public void setTugas(TugasAkhir tugas) {
        daftarTugasAkhir.add(tugas);
    }

    public void deleteTugasAkhir(String judul) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Data Tugas Akhir.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (ois.readObject() == null) {
            System.out.println("Data tsb tidak ada !");
        } else {
            while (ois.readObject() != null) {
                for (int i = 0; i < daftarTugasAkhir.size(); i++) {
                    if (daftarTugasAkhir.get(i).getJudul().equals(judul)) {
                        daftarTugasAkhir.remove(i);
                    }
                }
            }
        }
    }

    public void menuMhsCreate(String nama, String jenis, long nim) throws FileNotFoundException, IOException {
        Mahasiswa m = new Mahasiswa(nama, jenis, nim);
        addMahasiswa(m);
        FileOutputStream fos = new FileOutputStream("Data Mahasiswa.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(m);
        oos.flush();
        System.out.println("Data Telah Disimpan");
    }

    public void menuMhsDelete(long nim) throws IOException, FileNotFoundException, ClassNotFoundException {
        deleteMahasiswa(nim);
        System.out.println("Data Telah Dihapus");
    }

    public void menuDosenCreate(String nama, String jenis, long nip, String kode) throws FileNotFoundException, IOException {
        Dosen d = new Dosen(nama, jenis, nip, kode);
        addDosen(d);
        FileOutputStream fos = new FileOutputStream("Data Dosen.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        oos.flush();
        System.out.println("Data Telah Disimpan");
    }

    public void menuDosenDelete(long nip) throws IOException, FileNotFoundException, ClassNotFoundException {
        deleteDosen(nip);
        System.out.println("Data Telah Dihapus");
    }

    public void menuKelompokCreate(String nama, String topik, int num) throws FileNotFoundException, IOException {
        KelompokTA kl = new KelompokTA(nama, topik, num);
        setKelompok(kl);
        FileOutputStream fos = new FileOutputStream("Data Kelompok.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(kl);
        oos.flush();
        System.out.println("Data Telah Disimpan");
    }

    public void menuKelompokDelete(String nama) throws IOException, FileNotFoundException, ClassNotFoundException {
        deleteTugasAkhir(nama);
        System.out.println("Data Telah Dihapus");
    }

    public void menuTugasCreate(String judul, String kk) throws FileNotFoundException, IOException {
        TugasAkhir ta = new TugasAkhir(judul, kk);
        setTugas(ta);
        FileOutputStream fos = new FileOutputStream("Data Tugas Akhir.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ta);
        oos.flush();
        System.out.println("Data Telah Disimpan");
    }

    public void menuTugasDelete(String judul) throws IOException, FileNotFoundException, ClassNotFoundException {
        deleteTugasAkhir(judul);
        System.out.println("Data Telah Dihapus");
    }

    public void daftarMhsKelompok(long nim, String nama) throws IOException, FileNotFoundException, ClassNotFoundException {
        getKelompok(nama).addAnggota(getMahasiswa(nim));
    }

    public void daftarKelompokDosen(String nama, long nip) throws IOException, FileNotFoundException, ClassNotFoundException {
        getDaftarDosen(nip).addKelompokTA(getKelompok(nama));
    }

    public void daftarDosenTugas(String judul, long nip, int posisi) throws IOException, FileNotFoundException, ClassNotFoundException {
        getTugas(judul).setPembimbing(getDaftarDosen(nip), posisi);
    }

    public void daftarTugasMhs(long nim, String judul) throws IOException, FileNotFoundException, ClassNotFoundException {
        getMahasiswa(nim).createTugasAkhir(getTugas(judul));
    }

    public void mainMenu() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner inputan = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Main Menu Sisfo TA");
            System.out.println();
            System.out.println("1. Daftar Data Mahasiswa");
            System.out.println("2. Daftar Data Dosen");
            System.out.println("3. Daftar Data Kelompok TA");
            System.out.println("4. Daftar Data Tugas Akhir");
            System.out.println();
            System.out.println("5. Delete Data Mahasiswa");
            System.out.println("6. Delete Data Dosen");
            System.out.println("7. Delete Data Kelompok TA");
            System.out.println("8. Delete Data Tugas AKhir");
            System.out.println();
            System.out.println("9. Daftar Mahasiswa ke Kelompok TA");
            System.out.println("10. Daftar Kelompok TA ke Dosen");
            System.out.println("11. Set Dosen Pembimbing Tugas Akhir");
            System.out.println("12. Daftar Tugas Akhir untuk Mahasiswa");
            System.out.println();
            System.out.print("Masukkan Pilihan Menu: ");
            pilihan = inputan.nextInt();
            switch (pilihan) {
                case 1:
                    String nm = null;
                    String jk = null;
                    long nim = 0;
                    try {
                        System.out.print("Nama Mahasiswa: ");
                        nm = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama And, ini Kolom Nama !");
                    }
                    try {
                        System.out.print("NIM : ");
                        nim = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Masukkan NIM Anda !");
                    }
                    try {
                        System.out.print("Jenis Kelamin : ");
                        jk = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Hanya Pria atau Wanita, tidak boleh yg lain!");
                    }
                    menuMhsCreate(nm, jk, nim);
                    break;
                case 2:
                    String nm1 = null;
                    String jk1 = null;
                    long nip = 0;
                    String kd = null;
                    try {
                        System.out.print("Nama Dosen : ");
                        nm1 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama Anda, ini Kolom Nama !");
                    }
                    try {
                        System.out.print("NIP : ");
                        nip = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input NIP Anda !");
                    }
                    try {
                        System.out.print("Jenis Kelamin : ");
                        jk1 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Hanya Pria atau Wanita, tidak boleh yg lain!");
                    }
                    try {
                        while (kd == null || kd.length() > 3) {
                            System.out.print("Kode Dosen (3 Huruf): ");
                            kd = inputan.next();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Hanya 3 Huruf !");
                    }
                    menuDosenCreate(nm1, jk1, nip, kd);
                    break;
                case 3:
                    String nk = null;
                    String tp = null;
                    int jml = 0;
                    try {
                        System.out.print("Nama Kelompok : ");
                        nk = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input Nama Kelompok Anda !");
                    }
                    try {
                        System.out.println("Topik Tugas Akhir");
                        System.out.print("(topik berbeda dengan judul) : ");
                        tp = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Topik Tugas Akhir Anda !");
                    }
                    try {
                        System.out.print("Jumlah Max Anggota : ");
                        jml = inputan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Angka yang membatasi Jumlah Anggota Kelompok Anda");
                    }
                    menuKelompokCreate(nk, tp, jml);
                    break;
                case 4:
                    String jdl = null;
                    String kk = null;
                    try {
                        System.out.print("Judul Tugas Akhir : ");
                        jdl = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Judul Tugas Anda !");
                    }
                    try {
                        while (kk == null || !"ICM".equals(kk) || !"SIDE".equals(kk) || !"TELE".equals(kk)) {
                            System.out.print("Jenis Kelompok Keahlian(KK) : ");
                            kk = inputan.next();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Hanya 'ICM', 'SIDE', 'TELE' !");
                    }
                    menuTugasCreate(jdl, kk);
                    break;
                case 5:
                    long nim2 = 0;
                    try {
                        System.out.print("NIM Mahasiswa : ");
                        nim2 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input NIM yang ingin di hapus !");
                    }
                    menuMhsDelete(nim2);
                    break;
                case 6:
                    long nip2 = 0;
                    try {
                        System.out.print("NIP Dosen : ");
                        nip2 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("Input NIP yang ingin di hapus !");
                    }
                    menuDosenDelete(nip2);
                    break;
                case 7:
                    String kel = null;
                    try {
                        System.out.print("Nama Kelompok : ");
                        kel = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Nama Kelompok yang ingin di hapus !");
                    }
                    menuKelompokDelete(kel);
                    break;
                case 8:
                    String jdl2 = null;
                    try {
                        System.out.print("Judul Tugas Akhir : ");
                        jdl2 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Input judul yang ingin di hapus !");
                    }
                    menuTugasDelete(jdl2);
                    break;
                case 9:
                    long nim3 = 0;
                    String nama2 = null;
                    try {
                        System.out.print("Masukkan NIM Anda : ");
                        nim3 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("NIM Anda, berupa angka !");
                    }
                    try {
                        System.out.print("Masukkan Nama Kelompok : ");
                        nama2 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Nama Kelompok!");
                    }
                    daftarMhsKelompok(nim3, nama2);
                    break;
                case 10:
                    long nip3 = 0;
                    String nama3 = null;
                    try {
                        System.out.print("Masukkan NIP Anda : ");
                        nip3 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.print("NIP Anda, berupa angka !");
                    }
                    try {
                        System.out.print("Masukkan Nama Kelompok : ");
                        nama3 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.print("Nama Kelompok!");
                    }
                    daftarKelompokDosen(nama3, nip3);
                    break;
                case 11:
                    long nip4 = 0;
                    String judul2 = null;
                    int posisi = 0;
                    try {
                        System.out.print("Masukkan NIP Anda : ");
                        nip4 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.print("NIP Anda, berupa angka !");
                    }
                    try {
                        System.out.print("Masukkan Judul Tugas Akhir : ");
                        judul2 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Judul Tugas Akhir Mahasiswa bimbingan Anda!");
                    }
                    try {
                        System.out.println("Urutan Dosen Pembimbing");
                        System.out.print("(1 atau 2) : ");
                        posisi = inputan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("1 atau 2");
                    }
                    daftarDosenTugas(judul2, nip4, posisi);
                    break;
                case 12:
                    long nim5 = 0;
                    String judul3 = null;
                    try {
                        System.out.print("Masukkan NIM Anda : ");
                        nim5 = inputan.nextLong();
                    } catch (InputMismatchException e) {
                        System.out.println("NIM Anda, berupa angka !");
                    }
                    try {
                        System.out.print("Masukkan Judul Tugas Akhir : ");
                        judul3 = inputan.next();
                    } catch (InputMismatchException e) {
                        System.out.println("Judul Tugas Akhir Anda!");
                    }
                    daftarTugasMhs(nim5, judul3);
                    break;
                default:
                    System.out.println("Pilih 1-12 untuk Pilihan Menu atau 0 untuk Keluar");
                    Runtime.getRuntime().exec("cls");
                    break;
            }
        } while (pilihan != 0);
    }
}
