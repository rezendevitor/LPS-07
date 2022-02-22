package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PadraoLetras extends PlainDocument{
    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(i, string.replaceAll("[^A-Z | ^a-z | ^Â-Ẑ | ^â-ẑ | ^ÃẼỸŨĨÕÃṼÑ | ^ãẽỹũĩõãṽñ | ^çÇ | ^Á-Ź | ^á-ź | ^ÀÈÌÒÙ | ^àèìòù]", ""), as);
    }
}
