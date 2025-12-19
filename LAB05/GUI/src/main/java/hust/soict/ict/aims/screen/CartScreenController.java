package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class CartScreenController implements PropertyChangeListener {
    private Cart cart;

    private JTable tblMedia;
    private JLabel lblTotal;
    private JTextField tfFilter;
    private JRadioButton rdById, rdByTitle;
    private JButton btnPlay;
    private JButton btnRemove;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    public void setTableView(JTable tblMedia) {
        this.tblMedia = tblMedia;
    }

    public void setTotalLabel(JLabel lblTotal) {
        this.lblTotal = lblTotal;
    }

    public void setFilterTextField(JTextField tfFilter) {
        this.tfFilter = tfFilter;
    }

 
    public void setFilterRadioButtons(JRadioButton rdById, JRadioButton rdByTitle) {
        this.rdById = rdById;
        this.rdByTitle = rdByTitle;
    }

   
    public void setPlayButton(JButton btnPlay) {
        this.btnPlay = btnPlay;
    }

   
    public void setRemoveButton(JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    
    public void initialize() {
       
        updateTable();
        
       
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
       
        tblMedia.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = tblMedia.getSelectedRow();
                        Media selectedMedia = null;
                        
                        if (selectedRow >= 0 && selectedRow < cart.getItemsOrdered().size()) {
                            selectedMedia = cart.getItemsOrdered().get(selectedRow);
                        }
                        
                        updateButtonBar(selectedMedia);
                    }
                }
            }
        );
        
   
        tfFilter.getDocument().addDocumentListener(
            new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    showFilteredMedia();
                }
                
                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    showFilteredMedia();
                }
                
                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    showFilteredMedia();
                }
            }
        );
    }

    public void updateTable() {
        if (tblMedia == null || lblTotal == null) return;
        
        DefaultTableModel model = (DefaultTableModel) tblMedia.getModel();
        model.setRowCount(0);
        
        double total = 0;
        for (Media media : cart.getItemsOrdered()) {
            Vector<Object> row = new Vector<>();
            row.add(media.getTitle());
            row.add(media.getCategory());
            row.add(String.format("%.2f", media.getCost()));
            model.addRow(row);
            total += media.getCost();
        }
        
        lblTotal.setText(String.format("%.2f $", total));
    }

    public void updateButtonBar(Media media) {
        if (btnPlay == null || btnRemove == null) return;
        
        if (media == null) {
        
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            
            btnPlay.setVisible(media instanceof Playable);
        }
    }

 
    public void btnPlayPressed() {
      
        int selectedRow = tblMedia.getSelectedRow();
        
        if (selectedRow >= 0) {
            Media media = cart.getItemsOrdered().get(selectedRow);
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (hust.soict.ict.aims.exception.PlayerException e) {
                    javax.swing.JOptionPane.showMessageDialog(null, 
                        e.getMessage(), 
                        "Playback Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void playMedia(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < cart.getItemsOrdered().size()) {
            Media media = cart.getItemsOrdered().get(selectedRow);
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (hust.soict.ict.aims.exception.PlayerException e) {
                    javax.swing.JOptionPane.showMessageDialog(null, 
                        e.getMessage(), 
                        "Playback Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void btnRemovePressed() {
        
        int selectedRow = tblMedia.getSelectedRow();
        
        if (selectedRow >= 0) {
            Media media = cart.getItemsOrdered().get(selectedRow);
            try {
               
                cart.removeMedia(media);
             
                updateTable();
              
                tblMedia.clearSelection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeMedia(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < cart.getItemsOrdered().size()) {
            Media media = cart.getItemsOrdered().get(selectedRow);
            try {
                cart.removeMedia(media);
                updateTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void placeOrder() {
        if (!cart.getItemsOrdered().isEmpty()) {
            double total = calculateTotal();
            cart.getItemsOrdered().clear();
            updateTable();
        }
    }

    private double calculateTotal() {
        double total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        return total;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        updateTable();
    }

  
    public void showFilteredMedia() {
        if (tblMedia == null || tfFilter == null) return;
        
        String filterText = tfFilter.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tblMedia.getModel();
        model.setRowCount(0);
        
        double total = 0;

        for (Media media : cart.getItemsOrdered()) {
            boolean matches = false;
    
            if (filterText.isEmpty()) {
                matches = true;
            }
     
            else if (rdById.isSelected()) {
         
                matches = String.valueOf(media.getId()).contains(filterText);
            }
       
            else if (rdByTitle.isSelected()) {
   
                matches = media.getTitle().toLowerCase().contains(filterText.toLowerCase());
            }
            
   
            if (matches) {
                Vector<Object> row = new Vector<>();
                row.add(media.getTitle());
                row.add(media.getCategory());
                row.add(String.format("%.2f", media.getCost()));
                model.addRow(row);
                total += media.getCost();
            }
        }

        lblTotal.setText(String.format("%.2f $", total));
    }

    public Cart getCart() {
        return cart;
    }
}
