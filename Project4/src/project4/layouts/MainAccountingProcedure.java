package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import project4.*;

public class MainAccountingProcedure extends Menu implements ActionListener {

	private static final long serialVersionUID = -3934833398410949394L;
	
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
	
	public MainAccountingProcedure(Terminal terminal) {
		super(terminal);
		this.setTitle("Main Accounting Procedure");
		
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);
		addFooterButton(continueBtn);
		
		memberReportPanel = new JPanel(new GridLayout(0, 1));
		memberReportLabel1 = new JLabel("" + memberPanelPos);
		memberReportPanel.add(memberReportLabel1);
		memberReportLabel2 = new JLabel(memberNames[memberPanelPos]);
		memberReportPanel.add(memberReportLabel2);
		setTitle("Member Report");
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
		if(e.getSource() == continueBtn && memberPanelPos < 2) {
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
		}
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
