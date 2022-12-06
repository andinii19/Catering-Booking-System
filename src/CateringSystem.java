import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CateringSystem {
    private JTextField textNama;
    private JTextField textPesanan;
    private JComboBox cbCatering;
    private JComboBox cbPaket;
    private JComboBox cbLauk;
    private JComboBox cbTanggal;
    private JComboBox cbTahun;
    private JComboBox cbBulan;
    private JButton simpanButton;
    private JPanel rootPanel;
    private JComboBox cbNasi;
    private JTable tableCatering;
    private Catering catering;
    private DefaultTableModel tableModel;

    public CateringSystem()throws FileNotFoundException {
        this.catering = new Catering();
        this.initComponets();
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                catering.restartHarga();
                catering.setNamaCostumer(textNama.getText());
                catering.setJumlahPesanan(Integer.parseInt(textPesanan.getText()));
                catering.setJenisCatering(cbCatering.getSelectedItem().toString());
                catering.setJenisPaket(cbPaket.getSelectedItem().toString());
                String menuCatering = cbLauk.getSelectedItem().toString()+" dan "+cbNasi.getSelectedItem().toString();
                catering.setMenuCatering(menuCatering);
                String tanggalPengantaran = cbTanggal.getSelectedItem().toString()+"/"+cbBulan.getSelectedItem().toString()+"/"+cbTahun.getSelectedItem().toString();
                catering.setTanggal(tanggalPengantaran);


                tableModel.addRow(new Object[]{catering.getNamaCostumer(), catering.getJumlahPesanan(), catering.getJenisCatering(), catering.getJenisPaket(), catering.getMenuCatering(), catering.getTanggal(), catering.hargaAkhir()});

                String hasil = "\n\nNama Costumer : "+catering.getNamaCostumer() +"\nJumlah Pesanan : "+catering.getJumlahPesanan()
                + "\nJenis Catering : " +catering.getJenisCatering() + "\nJenis Paket : "+catering.getJenisPaket()
                +"\nMenu Catering : "+menuCatering +"\nTanggal Pengantaran : "+tanggalPengantaran +"\nTotal Harga : " +catering.hargaAkhir();


                String writingForResult  = String.format("Nama Kustomer : %s\nJumlah Pesanan : %s\nJenis Catering : %s\nJenis Paket : %s\nMenu Catering : %s\nTanggal Pengantaran: %s\nTotal Harga : %s\n\n",
                        catering.getNamaCostumer(), catering.getJumlahPesanan(), catering.getJenisCatering(), catering.getJenisPaket(), catering.getMenuCatering(), catering.getTanggal(), catering.hargaAkhir());

                String stringTempArray = String.format("%s#%s#%s#%s#%s#%s#%s\n",
                        catering.getNamaCostumer(), catering.getJumlahPesanan(), catering.getJenisCatering(), catering.getJenisPaket(), catering.getMenuCatering(), catering.getTanggal(), catering.hargaAkhir());

                try {
                    new DataMechanism().storedDataToTempFile(stringTempArray);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    new DataMechanism().insertingDataToFile(writingForResult);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }




            }
        });
    }

    private void initComponets() throws FileNotFoundException {

        Object[] tableColumn = {"Nama Costumer", "Jumlah Pesanan", "Jenis Catering", "Jenis Paket", "Menu Catering", "Tanggal Pengantaran", "Total Harga"};

        tableModel = new DefaultTableModel(new DataMechanism().getmObject(), tableColumn);
        tableCatering.setModel(tableModel);
        tableCatering.setAutoCreateRowSorter(true);

        for(int i = 0; i < 7; i++) {
            TableColumn col = tableCatering.getColumnModel().getColumn(i);
            DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
            dtcr.setHorizontalAlignment(SwingConstants.CENTER);
            col.setCellRenderer(dtcr);
        }
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }
}
