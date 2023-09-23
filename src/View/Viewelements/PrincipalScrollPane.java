package View.Viewelements;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PrincipalScrollPane extends JScrollPane {

	public PrincipalScrollPane(int x, int y, int width, int height, JPanel panel) {
		this.setBounds(x, y, width, height);
		this.setBorder(null);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(8,15));
		this.getVerticalScrollBar().setUI(new CustomScroll());
		this.getHorizontalScrollBar().setPreferredSize(new Dimension(15,8));
		this.getHorizontalScrollBar().setUI(new CustomScroll());
		this.setViewportView(panel);
	}

	
	
	
	
	
	
}
