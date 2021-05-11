import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class mainWindow {

	protected Shell shell;
	private Text txtBday;
	private Text txtBmonth;
	private Text txtByear;
	private Text txtYear;
	private Text txtMonth;
	private Text txtDay;
	private Text txtTotalDays;
	private Text txtTotalSleep;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainWindow window = new mainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(437, 370);
		shell.setText("Sleep Calculator");
		
		Label lblEnterYourBirth = new Label(shell, SWT.NONE);
		lblEnterYourBirth.setBounds(40, 85, 108, 15);
		lblEnterYourBirth.setText("Enter Your Birth Date");
		
		txtBday = new Text(shell, SWT.BORDER);
		txtBday.setText("0");
		txtBday.setBounds(93, 117, 76, 21);
		
		txtBmonth = new Text(shell, SWT.BORDER);
		txtBmonth.setText("0");
		txtBmonth.setBounds(93, 144, 76, 21);
		
		txtByear = new Text(shell, SWT.BORDER);
		txtByear.setText("0");
		txtByear.setBounds(93, 171, 76, 21);
		
		Label lblDay = new Label(shell, SWT.NONE);
		lblDay.setBounds(41, 117, 33, 15);
		lblDay.setText("Day");
		
		Label lblMonth = new Label(shell, SWT.NONE);
		lblMonth.setBounds(40, 144, 43, 15);
		lblMonth.setText("Month");
		
		Label lblYear = new Label(shell, SWT.NONE);
		lblYear.setBounds(40, 174, 38, 15);
		lblYear.setText("Year");
		
		txtYear = new Text(shell, SWT.BORDER);
		txtYear.setText("0");
		txtYear.setBounds(301, 171, 76, 21);
		
		Label lblYear_1 = new Label(shell, SWT.NONE);
		lblYear_1.setText("Year");
		lblYear_1.setBounds(248, 174, 38, 15);
		
		Label lblMonth_1 = new Label(shell, SWT.NONE);
		lblMonth_1.setText("Month");
		lblMonth_1.setBounds(248, 144, 43, 15);
		
		txtMonth = new Text(shell, SWT.BORDER);
		txtMonth.setText("0");
		txtMonth.setBounds(301, 144, 76, 21);
		
		txtDay = new Text(shell, SWT.BORDER);
		txtDay.setText("0");
		txtDay.setBounds(301, 117, 76, 21);
		
		Label lblDay_1 = new Label(shell, SWT.NONE);
		lblDay_1.setText("Day");
		lblDay_1.setBounds(249, 117, 33, 15);
		
		Label lblEnterTodaysDate = new Label(shell, SWT.NONE);
		lblEnterTodaysDate.setText("Enter Today's Date");
		lblEnterTodaysDate.setBounds(248, 85, 108, 15);
		
		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				// Init
				int currentYear = Integer.parseInt(txtYear.getText()), currentMonth = Integer.parseInt(txtMonth.getText()), currentDay = Integer.parseInt(txtDay.getText()), birthYear = Integer.parseInt(txtByear.getText()), birthMonth = Integer.parseInt(txtBmonth.getText()), birthDay = Integer.parseInt(txtBday.getText()), totalDays, totalSleep, diffYear, diffDay, diffMonth;
				
				diffYear = (currentYear - birthYear) * 365; 
	            /* Calculate the difference between the months
	            and multiply by 30 to get the number of days. */
	            diffMonth = (currentMonth - birthMonth) * 30; 
	            // Calculate the difference between the days.
	            diffDay = (currentDay - birthDay);

	            // Sum up the number of days for total number of days alive.
	            totalDays = (diffDay + diffMonth + diffYear);
	            // Multiply the daysAlive by 8 to get the number of hours of sleep.
	            totalSleep = totalDays * 8;
	            
	            txtTotalSleep.setText("You have been alive for " + Integer.toString(totalSleep) + " days.");
	            txtTotalDays.setText("You have slept for " + Integer.toString(totalDays) + " hours.");
				
				
			}
		});
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCalculate.setBounds(21, 235, 75, 25);
		btnCalculate.setText("Calculate");
		
		Button btnExit = new Button(shell, SWT.NONE);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setText("Exit");
		btnExit.setBounds(21, 271, 75, 25);
		
		txtTotalDays = new Text(shell, SWT.BORDER);
		txtTotalDays.setText("0");
		txtTotalDays.setBounds(115, 237, 285, 21);
		
		txtTotalSleep = new Text(shell, SWT.BORDER);
		txtTotalSleep.setText("0");
		txtTotalSleep.setBounds(115, 275, 285, 21);
		
		Label lblSleepCalculator = new Label(shell, SWT.NONE);
		lblSleepCalculator.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSleepCalculator.setBounds(115, 26, 193, 30);
		lblSleepCalculator.setText("SLEEP CALCULATOR");

	}

}
