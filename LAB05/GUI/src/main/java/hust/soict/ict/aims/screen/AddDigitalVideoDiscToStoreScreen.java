package hust.soict.ict.aims.screen;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        this.setTitle("Add DVD to Store");
    }

    @Override
    protected JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       
   
        tfTitle = new JTextField(30);
        panel.add(createLabeledInput("Title:", tfTitle));
         
        tfCategory = new JTextField(30);
        panel.add(createLabeledInput("Category:", tfCategory));
        

        tfDirector = new JTextField(30);
        panel.add(createLabeledInput("Director:", tfDirector));
        
  
        tfLength = new JTextField(30);
        panel.add(createLabeledInput("Length (minutes):", tfLength));
        

        tfCost = new JTextField(30);
        panel.add(createLabeledInput("Cost:", tfCost));
        
        return panel;
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String director = tfDirector.getText().trim();
            
            if (title.isEmpty() || category.isEmpty()) {
                throw new IllegalArgumentException("Title and Category cannot be empty");
            }
            
            int length = Integer.parseInt(tfLength.getText().trim());
            float cost = Float.parseFloat(tfCost.getText().trim());
            
  
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
            store.addMedia(dvd);
            
            JOptionPane.showMessageDialog(this, 
                "DVD added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
               
            tfTitle.setText("");
            tfCategory.setText("");
            tfDirector.setText("");
            tfLength.setText("");
            tfCost.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Invalid numeric input! Please check length and cost.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, 
                "Validation Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
