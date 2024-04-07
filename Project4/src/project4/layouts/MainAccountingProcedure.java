package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import project4.*;

public class MainAccountingProcedure extends Panel implements ActionListener {

	private static final long serialVersionUID = -3934833398410949394L;
	
	Terminal terminal;
	JButton continueBtn;
	
	int memberPanelPos;
	String[] memberNames = {"John", "Joe", "Mary"};
	
	JPanel memberReportPanel;
	JLabel memberReportLabel1;
	JLabel memberReportLabel2;
	
	JPanel providerReportPanel;
	JLabel providerReportLabel1;
	JLabel providerReportLabel2;
	JLabel providerReportLabel3;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	protected JPanel main;
	private JLabel title;
	
	private JButton loginBtn;
	
	public MainAccountingProcedure(Terminal terminal) {
		super();
		this.terminal = terminal;
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		main = new JPanel();
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		loginBtn = new JButton("Log out");
		loginBtn.addActionListener(terminal);
		loginBtn.addActionListener(this);
		bottomPanel.add(loginBtn);
		
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);
		bottomPanel.add(continueBtn);
		
		title = new JLabel("Main Accounting Procedure");
		topPanel.add(title);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(main, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		
		
		memberReportPanel = new JPanel(new GridLayout(0, 1));
		memberReportLabel1 = new JLabel("" + memberPanelPos);
		memberReportPanel.add(memberReportLabel1);
		memberReportLabel2 = new JLabel(memberNames[memberPanelPos]);
		memberReportPanel.add(memberReportLabel2);
		//setTitle("Member Report");
		main.add(memberReportPanel);
		
		providerReportPanel = new JPanel(new GridLayout(0, 1));
		providerReportLabel1 = new JLabel("Testing");
		providerReportLabel2 = new JLabel("More Testing");
		providerReportLabel3 = new JLabel("Most Testing");
		providerReportPanel.add(providerReportLabel1);
		providerReportPanel.add(providerReportLabel2);
		providerReportPanel.add(providerReportLabel3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		/*if(e.getSource() == continueBtn && memberPanelPos < 2) {
			memberPanelPos++;
			memberReportLabel1.setText("" + memberPanelPos);
			memberReportLabel2.setText(memberNames[memberPanelPos]);
			clear();
			addFooterButton(continueBtn);
			main.add(memberReportPanel);
			setTitle("Member Report");
		} else if (e.getSource() == continueBtn) {
			clear();
			//addFooterButton(continueBtn);
			main.add(providerReportPanel);
			setTitle("Provider Report");
		}*/
		main.revalidate();
		main.repaint();
		
	}
	
	public void MainAccountingStart() {
		memberPanelPos = 0;
	}
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/

}
