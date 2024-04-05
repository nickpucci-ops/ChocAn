package project4.layouts;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project4.*;

public abstract class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3406615400583481430L;
	
	protected Terminal terminal;
	private JPanel topPanel;
	private JPanel bottomPanel;
	protected JPanel main;
	private JLabel title;
	
	private JButton logoutBtn;
	
	Menu(Terminal terminal) {
		super();
		this.terminal = terminal;
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		main = new JPanel();
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.addActionListener(terminal);
		logoutBtn.addActionListener(this);
		bottomPanel.add(logoutBtn);
		
		title = new JLabel();
		topPanel.add(title);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(main, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	protected void setTitle(String title) {
		this.title.setText(title);
	}
	
	protected void clear() {
		bottomPanel.removeAll();
		bottomPanel.add(logoutBtn);
		bottomPanel.revalidate();
		bottomPanel.repaint();
		main.removeAll();
	}
	
	protected void addFooterButton(JButton button) {
		bottomPanel.add(button);
		bottomPanel.revalidate();
		bottomPanel.repaint();
	}
	
	protected JButton getLogoutBtn() {
		return logoutBtn;
	}
}
