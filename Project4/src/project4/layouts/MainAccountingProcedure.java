package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import project4.*;

public class MainAccountingProcedure extends Menu implements ActionListener {

	private static final long serialVersionUID = -3934833398410949394L;
	
	JPanel memberReportPanel;
	JButton continueBtn;
	JLabel memberReportLabel;
	JTextField memberReportText;
	
	public MainAccountingProcedure(Terminal terminal) {
		super(terminal);
		this.setTitle("Main Accounting Procedure");
		
		memberReportPanel = new JPanel(new GridLayout(0, 2));
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);
		memberReportPanel.add(continueBtn);
		memberReportLabel = new JLabel("Test");
		memberReportPanel.add(memberReportLabel);
		memberReportText = new JTextField(16);
		memberReportPanel.add(memberReportText);
		main.add(memberReportPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == continueBtn) {
			
		}
		
	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/

}
