package antri;

import javax.swing.*; //menginport semua library dan java tools
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class login {
    private JLabel labelUsername; //GUI untuk program login
    private JLabel labelPassword;
    private JTextField username;
    private JPasswordField password;
    private JButton btnMasuk;
    public JPanel panelMain;

    public login() {
        btnMasuk.addActionListener(new ActionListener() { //action listener untuk tombol Masuk
            @Override
            public void actionPerformed(ActionEvent e) {admin

                if (username.getText().equals("admin") && password.getText().equals("12345")) //pengkondisian username dan pass
                {
                    JOptionPane.showMessageDialog(null, "Login berhasil");
                    JFrame utama = new JFrame("main");
                    utama.setContentPane(new main().utamabox);
                    utama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    utama.setLocationRelativeTo(null);
                    utama.pack();
                    utama.setVisible(true);

                        }
                else //pengkondisian jika username atau password salah akan mengeluarkan output dibawah
                {
                    JOptionPane.showMessageDialog(null, "Username atau Password Belum Sesuai");
                }

            }
        });
    }
    public static void main(String[] args) { //elemen java agar program bisa di run
        JFrame frame = new JFrame("login"); //setelah login selesai akan berlanjut ke kelas dan program main
        frame.setContentPane(new login().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
