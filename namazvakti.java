package namazvakti_prje;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.ImageIcon;

import javax.swing.JFrame;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JLabel;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NamazVaktii {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NamazVaktii window = new NamazVaktii();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws JavaLayerException 
	 * @throws IOException 
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	public NamazVaktii() throws JavaLayerException, JsonIOException, JsonSyntaxException, IOException, ParseException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws JavaLayerException 
	 * @throws IOException 
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	private void initialize() throws JavaLayerException, JsonIOException, JsonSyntaxException, IOException, ParseException, InterruptedException{

		frame = new JFrame();
		frame.setTitle("Namaz Vakti");
		frame.setIconImage(new ImageIcon("img/namazvakti_fav.png").getImage());
		frame.getContentPane().setBackground(new Color(51, 204, 102));
		frame.setBounds(100, 100, 269, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		URL url = null;
		try {
			url = new URL("http://cuneydanlayisli.com/namaz2/mosque.png");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(url);		
	//	Image img = new ImageIcon(this.getClass().getResource("/mosque.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(66, 24, 107, 97);
		frame.getContentPane().add(lblNewLabel);
		
		ArrayList<String> sonuc = namazvakticek("2");
		
		System.out.println(Arrays.toString(sonuc.toArray()));
		
		
		
		JLabel lblImsak = new JLabel("\u0130msak:");
		lblImsak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImsak.setBounds(75, 198, 41, 22);
		frame.getContentPane().add(lblImsak);
		
		JLabel lblSabah = new JLabel("Sabah:");
		lblSabah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabah.setBounds(75, 238, 50, 14);
		frame.getContentPane().add(lblSabah);
		
		JLabel lblogle = new JLabel("Ögle:");
		lblogle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblogle.setBounds(75, 278, 50, 14);
		frame.getContentPane().add(lblogle);
		
		JLabel lblaksam = new JLabel("İkindi:");
		lblaksam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaksam.setBounds(75, 318, 50, 14);
		frame.getContentPane().add(lblaksam);
		
		JLabel lblikindi = new JLabel("Akşam:");
		lblikindi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblikindi.setBounds(75, 358, 50, 14);
		frame.getContentPane().add(lblikindi);
		
		JLabel lblyatsi = new JLabel("Yatsı");
		lblyatsi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblyatsi.setBounds(75,398, 50, 14);
		frame.getContentPane().add(lblyatsi);
		
		
		JLabel lblsonuc_imsak = new JLabel("İmsak Vakti");
		lblsonuc_imsak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_imsak.setBounds(126, 202, 46, 14);
		frame.getContentPane().add(lblsonuc_imsak);
		
		
		
		JLabel lblsonuc_sabah = new JLabel("Sabah Vakti");
		lblsonuc_sabah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_sabah.setBounds(126, 238, 46, 14);
		frame.getContentPane().add(lblsonuc_sabah);
		
		JLabel lblsonuc_ogle = new JLabel("Ogle Vakti");
		lblsonuc_ogle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_ogle.setBounds(126, 278, 46, 14);
		frame.getContentPane().add(lblsonuc_ogle);
		
		JLabel lblsonuc_ikindi = new JLabel("İkindi Vakti");
		lblsonuc_ikindi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_ikindi.setBounds(126, 318, 46, 14);
		frame.getContentPane().add(lblsonuc_ikindi);
		
		JLabel lblsonuc_aksam = new JLabel("Aksam Vakti");
		lblsonuc_aksam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_aksam.setBounds(126, 358, 46, 14);
		frame.getContentPane().add(lblsonuc_aksam);
		
		JLabel lblsonuc_yatsi = new JLabel("Yatsı Vakti");
		lblsonuc_yatsi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_yatsi.setBounds(126, 398, 46, 14);
		frame.getContentPane().add(lblsonuc_yatsi);
		
		
		
		lblsonuc_imsak.setText(sonuc.get(0));
		lblsonuc_sabah.setText(sonuc.get(1));
		lblsonuc_ogle.setText(sonuc.get(2));
		lblsonuc_ikindi.setText(sonuc.get(3));
		lblsonuc_aksam.setText(sonuc.get(4));
		lblsonuc_yatsi.setText(sonuc.get(5));
		
		JLabel lblGithub = new JLabel("açık kaynak");
		lblGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
						if(Desktop.isDesktopSupported())
						{
						  try {
							Desktop.getDesktop().browse(new URI("http://www.example.com"));
						} catch (IOException | URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					
			}
		});
		lblGithub.setBackground(new Color(51, 204, 102));
		
	
		lblGithub.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGithub.setBounds(160, 433, 83, 14);
		frame.getContentPane().add(lblGithub);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(75, 154, 83, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel kalanvakit = new JLabel("New label");
		kalanvakit.setBounds(70, 180, 46, 14);
		frame.getContentPane().add(kalanvakit);
		
		
		
		double imsakvakti = Double.parseDouble(sonuc.get(0).replaceAll(":","."));
		double sabahvakti = Double.parseDouble(sonuc.get(1).replaceAll(":","."));
		double oglevakti = Double.parseDouble(sonuc.get(2).replaceAll(":","."));
		double ikindivakti = Double.parseDouble(sonuc.get(3).replaceAll(":","."));
		double aksamvakti = Double.parseDouble(sonuc.get(4).replaceAll(":","."));
		double yatsivakti = Double.parseDouble(sonuc.get(5).replaceAll(":","."));
		
   		
	    	    
	





		
	
	
    	
		
	 
	             Timer kontrol=new Timer();
	             TimerTask gorev =new TimerTask() {
	 
	                    @Override
	                    public void run() {
	                   
	                        Date tarihsaat=new Date();
	                  		 
	                   		Calendar calendar = Calendar.getInstance();
	                   		calendar.setTime(tarihsaat);
	                   		int hours = calendar.get(Calendar.HOUR_OF_DAY);
	                   		long minutes = calendar.get(Calendar.MINUTE);
	                   		
	      		
	                   		String zat = hours + ":" + minutes;
	                   	
	                   		double suanki_saatdakika = Double.parseDouble(zat.replaceAll(":","."));
	                          
	              
	            
							if(suanki_saatdakika < imsakvakti){
								lblNewLabel_1.setText("Yatsı vakti");
								System.out.println(imsakvakti);
								System.out.println(suanki_saatdakika);
								
							}else if(suanki_saatdakika < sabahvakti){
								lblNewLabel_1.setText("İmsak vakti");
								System.out.println(sabahvakti);
								System.out.println(suanki_saatdakika);
						
							}else if(suanki_saatdakika < oglevakti){
								lblNewLabel_1.setText("Sabah vakti");
								System.out.println(oglevakti);
								System.out.println(suanki_saatdakika);
						
								
							}else if(suanki_saatdakika < ikindivakti){
								lblNewLabel_1.setText("Ogle vakti ");
								System.out.println(ikindivakti);
								System.out.println(suanki_saatdakika);
						
								
							}else if(suanki_saatdakika < aksamvakti){
								lblNewLabel_1.setText("İkindi vakti ");
								System.out.println(aksamvakti);
								System.out.println(suanki_saatdakika);
						
								
							}else if(suanki_saatdakika < yatsivakti){
								lblNewLabel_1.setText("Akşam vakti ");
								System.out.println(yatsivakti);
								System.out.println(suanki_saatdakika);
						
							 }
							}
    	
	             };
	        	 
	             kontrol.schedule(gorev,0,3000);

		
	
		
		
	}

	
	public ArrayList<String> namazvakticek(String il_num) throws JsonIOException, JsonSyntaxException, IOException{
		
			 String sURL = "http://cuneydanlayisli.com/namaz2/index.php?islem=getNamazVakitleri&ulke_id=" + il_num + "&sehir_id=520&ilce_id=9343"; //just a string

			    // Connect to the URL using java's native library
			    URL url = new URL(sURL);
			    HttpURLConnection request = (HttpURLConnection) url.openConnection();
			    request.connect();

			    // Convert to a JSON object to print data
			    JsonParser jp = new JsonParser(); //from gson
			    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
			    
			    String imsak = rootobj.get("Imsak").getAsString(); //just grab the zipcode
			    String sabah = rootobj.get("Gunes").getAsString(); //just grab the zipcode
			    String ogle = rootobj.get("Ogle").getAsString(); //just grab the zipcode
			    String Ikindi = rootobj.get("Ikindi").getAsString(); //just grab the zipcode
			    String Aksam = rootobj.get("Aksam").getAsString(); //just grab the zipcode
			    String Yatsi = rootobj.get("Yatsi").getAsString(); //just grab the zipcode
			    
			    ArrayList<String> isimler = new ArrayList<String>();
			    
			    isimler.add(imsak);
			    isimler.add(sabah);
			    isimler.add(ogle);
			    isimler.add(Ikindi);
			    isimler.add(Aksam);
			    isimler.add(Yatsi);
			    
			/*    System.out.println("Sabah: " + sabah);
			    System.out.println("Ogle: " + ogle);
			    System.out.println("İkindi: " + Ikindi);
			    System.out.println("Akşam: " + Aksam);
		*/
			    return(isimler);
			  //  return new String[] {};
	
}
}
