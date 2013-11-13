/****************************************************************/
/*                      LocationGuard	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.sql.*;
/**
 * Summary description for LocationGuard
 *
 */
public class LocationGuard extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel contentPane;
	public Socket getLoReq;
	public Socket sndReq;
	public Socket cliRet;
	public String cliApp="localhost";
	public ServerSocket allRec;
	public String uName="";
	public String pWord="";
	public String FlSer="";
	public String top="";
	public Connection co;
	public Statement st;
	public ResultSet rs;
	public Socket sndFl;
	public int ch=0;
	public Socket rcvSer;
	public ServerSocket rcv;
	public Socket resp;
	public String cliAdd="";
	public String flSer1="";
	// End of variables declaration


	public LocationGuard()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
		try
		{
			FileInputStream fis=new FileInputStream("FileServer1.txt");
				while((ch=fis.read())!=-1)
				flSer1+=(char)ch;
				flSer1.trim();

				FileInputStream fis1=new FileInputStream("ClientAddress.txt");
				while((ch=fis1.read())!=-1)
				cliAdd+=(char)ch;
				cliAdd.trim();
			

			allRec=new ServerSocket(7000);
			rcv=new ServerSocket(9000);
			while(true)
			{
				getLoReq=allRec.accept();
				DataInputStream dis=new DataInputStream(getLoReq.getInputStream());
				top=dis.readUTF();
				System.out.println(top);
					jLabel3.setText("Work in Progress");
						jLabel4.setText("Work in Progress");
							jLabel7.setText("Transfering request to Server");

							

				sndFl=new Socket(flSer1,8000);
				DataOutputStream dos=new DataOutputStream(sndFl.getOutputStream());
				dos.writeUTF(top);
				jLabel7.setText("Transfered request to Server");

				rcvSer=rcv.accept();
				DataInputStream dis1=new DataInputStream(rcvSer.getInputStream());
				String recd=dis1.readUTF();
				System.out.println(recd);
				jLabel7.setText("Response Accepted from Server");

				resp=new Socket(cliAdd,9100);
				//JOptionPane.showMessageDialog(this,"");
				DataOutputStream dos1=new DataOutputStream(resp.getOutputStream());
				//JOptionPane.showMessageDialog(this,"sended");
				dos1.writeUTF(recd);	
				jLabel7.setText("Response sent to Client");

			}
			
		}
		catch (Exception cv)
		{
			cv.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel2.setFont(new Font("Book Antiqua",Font.BOLD,14));
		jLabel3 = new JLabel();
		jLabel3.setFont(new Font("Book Antiqua",Font.BOLD,14));
		jLabel4 = new JLabel();
		jLabel4.setFont(new Font("Book Antiqua",Font.BOLD,14));
		jLabel5 = new JLabel();
		jLabel5.setFont(new Font("Book Antiqua",Font.BOLD,14));
		jLabel6 = new JLabel();
		jLabel6.setFont(new Font("Book Antiqua",Font.BOLD,14));
		jLabel7 = new JLabel();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		//jLabel1.setText("jLabel1");
		jLabel1.setIcon(new ImageIcon("Java1.PNG"));
		//
		// jLabel2
		//
		jLabel2.setText("Location Guard Status");
		//
		// jLabel3
		//
		jLabel3.setText("Idle");
		//
		// jLabel4
		//
		jLabel4.setText("Idle");
		//
		// jLabel5
		//
		jLabel5.setText("Routing Guard Status");
		//
		// jLabel6
		//
		jLabel6.setText("Access Status");
		//
		// jLabel7
		//
		jLabel7.setText("Ready");
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 1,0,576,90);
		addComponent(contentPane, jLabel2, 47,125,205,27);
		addComponent(contentPane, jLabel3, 47,163,489,42);
		addComponent(contentPane, jLabel4, 47,256,484,38);
		addComponent(contentPane, jLabel5, 51,213,186,28);
		addComponent(contentPane, jLabel6, 148,338,134,33);
		addComponent(contentPane, jLabel7, 334,335,400,41);
		//
		// LocationGuard
		//
		this.setTitle("LocationGuard ");
		this.setLocation(new Point(50, 45));
		this.setSize(new Dimension(587, 449));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//






























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		/*JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}*/
		new LocationGuard();
	}
//= End of Testing =


}
