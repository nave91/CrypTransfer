import java.net.*;
import java.io.*;
import java.sql.*;
public class LogSer 
{
	public ServerSocket lg;
	public Socket lgs;
	public Connection co;
	public Statement st;
	public ResultSet rs;
	public Socket cliRet;
	public String cliApp="localhost";
	public String uName="";
	public String pWord="";
	public String pup="";

	public LogSer()
	{
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			co=DriverManager.getConnection("Jdbc:Odbc:DOS","sa","");
			st=co.createStatement();
			rs=st.executeQuery("select * from Login");

		lg=new ServerSocket(5000);
		while(true)
		{
			lgs=lg.accept();
			DataInputStream dis=new DataInputStream(lgs.getInputStream());
			uName=dis.readUTF();
			pWord=dis.readUTF();
			pup=dis.readUTF();
			System.out.println("1");
			rs=st.executeQuery("select * from Login");

			while(rs.next())
					{
						if(uName.equals(rs.getString(1))&&pWord.equals(rs.getString(2)))
						{
							cliRet=new Socket(cliApp,6000);
							DataOutputStream  dos1=new DataOutputStream(cliRet.getOutputStream());
							dos1.writeUTF("yes");
							break;
						}

						else
						{
							cliRet=new Socket(cliApp,6000);
							DataOutputStream dos1=new DataOutputStream(cliRet.getOutputStream());
							dos1.writeUTF("no");
							
						}


			
		}} }
		catch(Exception we)
		{
			we.printStackTrace();
		}

		
	}
	public static void main(String[] args) 
	{
		new LogSer();
	}
}
