package hust.soict.ict.aims.screen;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.store.Store;


public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfAuthor;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store);
        this.setTitle("Add Book to Store");
    }

    @Override
    protected JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        

        tfTitle = new JTextField(30);
        panel.add(createLabeledInput("Title:", tfTitle));
        
        tfCategory = new JTextField(30);
        panel.add(createLabeledInput("Category:", tfCategory));

        tfAuthor = new JTextField(30);
        panel.add(createLabeledInput("Author:", tfAuthor));

        tfCost = new JTextField(30);
        panel.add(createLabeledInput("Cost:", tfCost));
        
        return panel;
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String author = tfAuthor.getText().trim();
            
            if (title.isEmpty() || category.isEmpty()) {
                throw new IllegalArgumentException("Title and Category cannot be empty");
            }
            
            float cost = Float.parseFloat(tfCost.getText().trim());
            
            Book book = new Book(title, category, cost);
            book.addAuthor(author);
            store.addMedia(book);
            
            JOptionPane.showMessageDialog(this, 
                "Book added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);

            tfTitle.setText("");
            tfCategory.setText("");
            tfAuthor.setText("");
            tfCost.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Invalid numeric input! Please check cost.", 
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
