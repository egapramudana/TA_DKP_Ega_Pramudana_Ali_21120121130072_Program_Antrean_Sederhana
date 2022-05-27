package antri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.LinkedList;

public class main extends Component {
    public JPanel utamabox;
    private JLabel lbNo;
    private JLabel lbNama;
    private JLabel lbBanyak;
    private JLabel lbTotal;
    private JButton ambilNomorButton;
    private JTextArea txAntri;
    private JButton selanjutnyaButton;
    private JTextField txNama;
    private JButton resetButton;

    Queue antrian =  new LinkedList<>(); //pendeklarasian perintah queue untuk variabel antrian dan nama
    Queue nama =  new LinkedList<>();

    int nomor = 0; //pendeklarasian integer nomor = 0

    public main() { //kelas main
    inisialisasi() ; //pemanggilan method inisialisasi yg berisi tampilan awal antrean yg belum diisi
        ambilNomorButton.addActionListener(new ActionListener() { //tombol ambil nomor jika diklik akan memanggil method ambilNomor
            @Override
            public void actionPerformed(ActionEvent e) {
                ambilNomor(); //pemanggilan method ambilNomor

            }
        });
        selanjutnyaButton.addActionListener(new ActionListener() { //tombol selanjutnya jika diklik akan memanggil method selanjutnya
            @Override
            public void actionPerformed(ActionEvent e) {
                selanjutnya(); //pemanggilan method selanjutnya
            }
        });
        txNama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) { //perintah untuk menampilkan keyword yg diinputkan di daftar antrean
                super.keyPressed(e);
                char c = e.getKeyChar();

                txNama.setEditable(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c));
            }
        });
        resetButton.addActionListener(new ActionListener() { //tombol reset jika diklik akan memanggil method reset
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(); //pemanggilan method reset
            }
        });
    }


    private void inisialisasi() { //inisialisasi method tampilan awal antrean yang belum diisi
        lbBanyak.setText("0");
        lbTotal.setText("0");
        lbNo.setText("Antrean Kosong");
        lbNama.setText("-----------");
    }

    public void reset() { //jika tombol reset ditekan maka terhubung ke actionlistener yang akan membuat outputnya dibwh
        JOptionPane.showMessageDialog(null, "Antrean ter-reset"); //menampilkan teks pane
        lbBanyak.setText("0"); //menampilkan jml banyak antraen 0
        lbTotal.setText("0"); //menampilkan total antrean 0
        lbNo.setText("Antrean Kosong"); //menampilkan teks antrean kosong
        lbNama.setText("-----------"); //menampilkan label nama ------------
        txAntri.setText(""); //mengosongkan daftar antrean
        antrian.clear(); //clear merupakan perintah untuk mengosongkan semua elemen
        nama.clear();
        nomor = 0; //inisialisasi nomor
    }




    public void ambilNomor() {
        if (txNama.getText().equals("")) { //jika teks silahkan masukkan nama kosong akan mengeluarkan output dibawah
            JOptionPane.showMessageDialog(null, "Silakan Masukkan Nama Terlebih Dahulu !");

        }
        else {
            nomor++; //untuk increment nomor +1
            String nm = txNama.getText(); //inisialisasi variabel nm supaya nama dipanggil ke text
            String ant = "Antrian " + nomor; //inisialisasi variabel ant supaya keluarannya Antrean ke berapa
            antrian.add(ant); //pendeklarasian variabel untuk dipanggil
            nama.add(nm);
            String jml = String.valueOf(antrian.size()); //inisialisasi variabel jml
            lbBanyak.setText(jml); //label jumlah banyak antrean yg berlangsung
            lbNo.setText(""+antrian.peek()); //label no antrean peek yg akan mengeluarkan no antrean yg pertama diinputkan
            lbTotal.setText(""+nomor); //label total untuk total antrean
            txAntri.append(nm + "\n"); //text daftar antrean
            lbNama.setText(""+nama.peek()); //label nama antrean peek yang akan mengeluarkan nama antrean yg pertama diinputkan
            txNama.setText(""); //menampilkan teks nama
        }

    }
    private void selanjutnya(){
        if(antrian.isEmpty()){ //jika tombol selanjutnya di klik dan teks kosong, outputnya seperti dibawah
            JOptionPane.showMessageDialog(null, "Ambil Nomor antrian terlebih dahulu !");
        }
        txAntri.setText(""); //text daftar antrean
        antrian.poll(); //poll digunakan untuk menerima dan membuang data queue yang pertama diinputkan
        nama.poll();
        String jml = String.valueOf(antrian.size()); //inisialisasi variabel jml
        lbBanyak.setText(jml); //label jumlah banyak antrean yg berlangsung
        nama.forEach((Object element) -> { //merupakan perintah perulangan untuk semua elemen di dalam method
            txAntri.append("" + element + "\n"); //menampilkan daftar antrean
        });
        if(antrian.isEmpty()){ //jika antrean habis & kosong akan menampilkan output pada label di bawah
            lbNo.setText("Antrean Kosong");
            lbNama.setText("------------");
        }else{ //jika antrean masih ada maka akan berlanjut peek queue ke antrean berikutnya
            lbNo.setText(""+antrian.peek());
            lbNama.setText(""+nama.peek());
        }
    }

    public static void main(String[] args) { //elemen untuk program agar bisa berjalan
        JFrame utama = new JFrame("main");
        utama.setContentPane(new main().utamabox);
        utama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        utama.setLocationRelativeTo(null);
        utama.pack();
        utama.setVisible(true);
    }
}