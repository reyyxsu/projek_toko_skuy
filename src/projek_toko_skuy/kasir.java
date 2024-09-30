/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek_toko_skuy;

import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.util.Date;



/**
 *
 * @author Ariyal Zarhan
 */
public class kasir extends javax.swing.JFrame {

    /**
     * Creates new form kasir
     */
    
    private Connection connect() {
        Connection conn = null;
        try {
            // URL koneksi database MySQL
            String url = "jdbc:mysql://localhost:3306/toko_ariyal"; // Sesuaikan dengan URL dan nama database Anda
            String user = "root"; // Username database
            String password = ""; // Password database

            // Membuat koneksi ke database
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    private void updateTime() {
        // Format tanggal dan waktu
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        String currentTime = formatter.format(new Date());
        // Set teks JLabel
         txTanggal.setText(currentTime);
    }
    
     private void loadComboBoxData() {
        Connection conn = connect();
        java.sql.Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            // Query untuk mengambil data dari database
            String sql = "SELECT id FROM barang"; // Sesuaikan dengan nama tabel dan kolom
            rs = stmt.executeQuery(sql);

            // Menghapus item yang ada sebelumnya
            cbKode.removeAllItems();

            // Menambahkan data ke ComboBox
            while (rs.next()) {
                String namaBarang = rs.getString("id");
                cbKode.addItem(namaBarang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mengambil harga berdasarkan barang yang dipilih
    private void loadNamaBarang(String namaBarang) {
        Connection conn = connect();
        java.sql.Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            // Query untuk mengambil harga berdasarkan barang yang dipilih
            String sql = "SELECT nama_barang FROM barang WHERE id = '" + namaBarang + "'"; // Sesuaikan dengan kolom
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // Mengambil harga barang dan menampilkan di JTextField
                String NamaBarang = rs.getString("nama_barang");
                txNama.setText(NamaBarang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void loadHargaBarang(String hargaBarang) {
        Connection conn = connect();
        java.sql.Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            // Query untuk mengambil harga berdasarkan barang yang dipilih
            String sql = "SELECT harga_barang FROM barang WHERE id = '" + hargaBarang + "'"; // Sesuaikan dengan kolom
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // Mengambil harga barang dan menampilkan di JTextField
                String HargaBarang = rs.getString("harga_barang");
                txHarga.setText(HargaBarang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void loadData()
    {
        try{
            Connection c = Koneksi.getKoneksi();
            java.sql.Statement s = c.createStatement();
            String sql = "SELECT * FROM rekap_penjualan";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                Object[] o = new Object[2];
                o [0] = r.getString("uang_masuk");
                o [1] = r.getString("tanggal_pemasukan");
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("terjadi kesalahan");
        }
    }
    private void clear()
    {
        txNama.setText("");
        txHarga.setText("");
        txJumlah.setText("");
        txTotal.setText("");
        txUangDiberikan.setText("");
        txKembalian.setText("");
        txArea.setText("");
    }
    
    public kasir() {
        initComponents();
        txTotal.setEnabled(false);
        txTanggal.setEnabled(false);
        txKembalian.setEnabled(false);
        txHarga.setEnabled(false);
        txNama.setEnabled(false);
        loadData();
        loadComboBoxData();
        cbKode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedBarang = (String) cbKode.getSelectedItem();
                if (selectedBarang != null) {
                    loadNamaBarang(selectedBarang); // Panggil fungsi untuk mengisi harga berdasarkan barang yang dipilih
                    loadHargaBarang(selectedBarang);
                }
            }
        });
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
    });
           timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txUangDiberikan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txKembalian = new javax.swing.JTextField();
        btnPrint = new javax.swing.JToggleButton();
        btnHitung = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txArea = new javax.swing.JTextArea();
        btnGenerate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbKode = new javax.swing.JComboBox<>();
        btnTotal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        txTanggal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOKO ARIYAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(313, 313, 313))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Kode Barang:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Harga Barang:");

        txHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHargaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Jumlah Barang:");

        txJumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Belanja:");

        txTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Uang Yang Diberikan:");

        txUangDiberikan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Uang Kembalian:");

        txKembalian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnPrint.setText("PRINT RECEIPT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnHitung.setText("HITUNG HARGA BARANG & JUMLAH BARANG");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txArea.setColumns(20);
        txArea.setRows(5);
        jScrollPane1.setViewportView(txArea);

        btnGenerate.setText("GENERATE PRINT");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel8.setText("PREVIEW STRUK");

        cbKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodeActionPerformed(evt);
            }
        });

        btnTotal.setText("TOTAL");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nama Barang:");

        txNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaActionPerformed(evt);
            }
        });

        jLabel10.setText("Timestamp:");

        btnProses.setText("PROSES DATABASE");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        jButton1.setText("CEK DATA PEMASUKAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CEK BARANG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel5))
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNama)
                                    .addComponent(txJumlah)
                                    .addComponent(txTotal)
                                    .addComponent(txUangDiberikan)
                                    .addComponent(txHarga)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKode, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnHitung)
                                        .addGap(81, 81, 81))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnTotal)
                                        .addGap(183, 183, 183)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(141, 141, 141))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrint)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerate)
                        .addGap(142, 142, 142)
                        .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txUangDiberikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHitung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(20, 20, 20)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(btnClear)
                    .addComponent(btnExit)
                    .addComponent(btnGenerate)
                    .addComponent(btnProses)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try
        {
            txArea.print();
        }
        catch (Exception e)
        {

        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
    try {
    int hargaBarang = Integer.parseInt(txHarga.getText());
    int jumlahBarang = Integer.parseInt(txJumlah.getText());
    int totalBelanjaBarang = hargaBarang * jumlahBarang;

    // Logika untuk diskon per barang
    double diskonPerBarang = 0;
    if (totalBelanjaBarang > 200000) { // Diskon 5% jika belanja lebih dari 200 ribu
        diskonPerBarang = 0.05 * totalBelanjaBarang;
    } else if (totalBelanjaBarang > 100000) { // Diskon 2% jika belanja lebih dari 100 ribu
        diskonPerBarang = 0.02 * totalBelanjaBarang;
    }

    // Kurangi total belanja barang dengan diskon per barang
    totalBelanjaBarang -= diskonPerBarang;

    // Tambahkan ke total keseluruhan belanja
    totalKeseluruhanBelanja += totalBelanjaBarang;

    // Tampilkan barang dan harga di area struk
    txArea.append("Barang: " + txNama.getText() + "\n");
    txArea.append("Harga: " + hargaBarang + "\n");
    txArea.append("Jumlah: " + jumlahBarang + "\n");
    txArea.append("Diskon per Barang: " + String.format("%.0f", diskonPerBarang) + "\n");
    txArea.append("Subtotal: " + totalBelanjaBarang + "\n");

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
}

// Pindahkan logika untuk diskon keseluruhan dan tampilan akhir di luar blok try-catch
double diskonKeseluruhan = 0;
if (totalKeseluruhanBelanja > 200000) { // Diskon 5% jika total belanja lebih dari 200 ribu
    diskonKeseluruhan = 0.05 * totalKeseluruhanBelanja;
} else if (totalKeseluruhanBelanja > 100000) { // Diskon 2% jika total belanja lebih dari 100 ribu
    diskonKeseluruhan = 0.02 * totalKeseluruhanBelanja;
}

double totalAkhirBelanja = totalKeseluruhanBelanja - diskonKeseluruhan;

// Tampilkan diskon total keseluruhan dan total belanja setelah diskon hanya sekali di akhir
txArea.append("Diskon Total Keseluruhan: " + String.format("%.0f", diskonKeseluruhan) + "\n");
txArea.append("Total Belanja Setelah Diskon Keseluruhan: " + totalAkhirBelanja + "\n\n");
txTotal.setText(""+totalAkhirBelanja);
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        txArea.setText("=======================================\n");
        txArea.setText(txArea.getText()+"                 STRUK BELANJA TOKO ARIYAL\n");
        txArea.setText(txArea.getText()+"Nama Barang: " + cbKode.getSelectedItem() + "\n");
        txArea.setText(txArea.getText()+"Harga Barang: Rp " + txHarga.getText() + "\n");
        txArea.setText(txArea.getText()+"Jumlah Barang: " + txJumlah.getText() + " pcs" + "\n");
        txArea.setText(txArea.getText()+"Total Belanja: Rp " + txTotal.getText() + "\n");
        txArea.setText(txArea.getText()+"Total Uang Diberikan: Rp " + txUangDiberikan.getText() + "\n");
        txArea.setText(txArea.getText()+"Kembalian: Rp " + txKembalian.getText() + "\n");
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private int totalKeseluruhanBelanja = 0;
    
    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
       try {
    int uangDiberikan = Integer.parseInt(txUangDiberikan.getText());

    // Pastikan total belanja setelah diskon dihitung dengan benar
    double diskonKeseluruhan = 0;
    if (totalKeseluruhanBelanja > 200000) { // Diskon 5% jika total belanja lebih dari 200 ribu
        diskonKeseluruhan = 0.05 * totalKeseluruhanBelanja;
    } else if (totalKeseluruhanBelanja > 100000) { // Diskon 2% jika total belanja lebih dari 100 ribu
        diskonKeseluruhan = 0.02 * totalKeseluruhanBelanja;
    }

    // Hitung total belanja akhir setelah diskon
    double totalAkhirBelanja = totalKeseluruhanBelanja - diskonKeseluruhan;

    // Cek apakah uang yang diberikan cukup
    if (uangDiberikan >= totalAkhirBelanja) {
        double uangKembalian = uangDiberikan - totalAkhirBelanja;

        // Tampilkan uang diberikan, uang kembalian, dan tanggal di area struk
        txArea.append("Uang Diberikan: " + uangDiberikan + "\n");
        txArea.append("Kembalian: " + uangKembalian + "\n");
        txArea.append("Tanggal dan Waktu: " + txTanggal.getText() + "\n");

        // Tampilkan uang kembalian di field kembalian
        txKembalian.setText(String.format("%.0f", uangKembalian));

        // Reset total keseluruhan belanja setelah pembayaran selesai
        totalKeseluruhanBelanja = 0;
    } else {
        // Pesan error jika uang yang diberikan kurang dari total belanja
        JOptionPane.showMessageDialog(this, "Uang yang diberikan kurang!", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (NumberFormatException e) {
    // Pesan error jika input uang yang diberikan tidak valid
    JOptionPane.showMessageDialog(this, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_btnTotalActionPerformed

    private void cbKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKodeActionPerformed

    private void txHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHargaActionPerformed

    private void txNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        String uang_masuk = txTotal.getText();
        String tanggal_pemasukan = txTanggal.getText();
        String inputText = txNama.getText();
        if(inputText.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "DATA MASIH KOSONG!!");
        }
        else
        {
            try
            {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO rekap_penjualan VALUES (?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, uang_masuk);
            p.setString(2, tanggal_pemasukan);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Data Pemasukan Sudah Masuk!!");
            
        }
        catch(SQLException e)
        {
            System.out.println("Terjadi Kesalahan");
        }
        finally
        {
            loadData();
            clear();
        }
        }
        
    }//GEN-LAST:event_btnProsesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        DataPemasukan satu = new DataPemasukan();
        satu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        DataBarang satu = new DataBarang();
        satu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnHitung;
    private javax.swing.JToggleButton btnPrint;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox<String> cbKode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txArea;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txJumlah;
    private javax.swing.JTextField txKembalian;
    private javax.swing.JTextField txNama;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txUangDiberikan;
    // End of variables declaration//GEN-END:variables
}
