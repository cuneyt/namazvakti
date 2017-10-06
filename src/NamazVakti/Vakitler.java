package NamazVakti;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
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
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javazoom.jl.decoder.JavaLayerException;
public class Vakitler extends JFrame {

	public JFrame frame;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Vakitler window = new Vakitler("istanbul","530");
					window.setVisible(true);
					
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
	public Vakitler(String ilid, String ilceid) throws JavaLayerException, JsonIOException, JsonSyntaxException, IOException, ParseException, InterruptedException {
	System.out.println("ilid" + ilid + "ilçeid" + ilceid);
		


		frame = new JFrame();
		setTitle("Namaz Vakti");
	
		//setIconImage(Toolkit.getDefaultToolkit().getImage(NamazVakti.class.getResource("/img/1.png")));
		
		getContentPane().setBackground(new Color(51, 204, 102));
		setBounds(100, 100, 269, 494);
		setSize(250, 500);
		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		setResizable(false);
		
		
		
	

		
		
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
		getContentPane().add(lblNewLabel);
		
		ArrayList<String> sonuc = namazvakticek("2",ilid,ilceid);
		
		ArrayList<String> sonucsaniyeli = namazvakticek_saniyeli("2",ilid,ilceid);
		
		System.out.println(Arrays.toString(sonuc.toArray()));
		
		
		
		JLabel lblImsak = new JLabel("\u0130msak:");
		lblImsak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImsak.setBounds(76, 208, 41, 22);
		getContentPane().add(lblImsak);
		
		JLabel lblSabah = new JLabel("Sabah:");
		lblSabah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSabah.setBounds(76, 248, 50, 14);
		getContentPane().add(lblSabah);
		
		JLabel lblogle = new JLabel("Ögle:");
		lblogle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblogle.setBounds(76, 288, 50, 14);
		getContentPane().add(lblogle);
		
		JLabel lblaksam = new JLabel("Ýkindi:");
		lblaksam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaksam.setBounds(76, 328, 50, 14);
		getContentPane().add(lblaksam);
		
		JLabel lblikindi = new JLabel("Akþam:");
		lblikindi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblikindi.setBounds(76, 368, 50, 14);
		getContentPane().add(lblikindi);
		
		JLabel lblyatsi = new JLabel("Yatsý");
		lblyatsi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblyatsi.setBounds(76,408, 50, 14);
		getContentPane().add(lblyatsi);
		
		
		JLabel lblsonuc_imsak = new JLabel("Ýmsak Vakti");
		lblsonuc_imsak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_imsak.setBounds(127, 212, 46, 14);
		getContentPane().add(lblsonuc_imsak);
		
		
		
		JLabel lblsonuc_sabah = new JLabel("Sabah Vakti");
		lblsonuc_sabah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_sabah.setBounds(127, 248, 46, 14);
		getContentPane().add(lblsonuc_sabah);
		
		JLabel lblsonuc_ogle = new JLabel("Ogle Vakti");
		lblsonuc_ogle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_ogle.setBounds(127, 288, 46, 14);
		getContentPane().add(lblsonuc_ogle);
		
		JLabel lblsonuc_ikindi = new JLabel("Ýkindi Vakti");
		lblsonuc_ikindi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_ikindi.setBounds(127, 328, 46, 14);
		getContentPane().add(lblsonuc_ikindi);
		
		JLabel lblsonuc_aksam = new JLabel("Aksam Vakti");
		lblsonuc_aksam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_aksam.setBounds(127, 368, 46, 14);
		getContentPane().add(lblsonuc_aksam);
		
		JLabel lblsonuc_yatsi = new JLabel("Yatsý Vakti");
		lblsonuc_yatsi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsonuc_yatsi.setBounds(127, 408, 46, 14);
		getContentPane().add(lblsonuc_yatsi);
		
		
		
		lblsonuc_imsak.setText(sonuc.get(0));
		lblsonuc_sabah.setText(sonuc.get(1));
		lblsonuc_ogle.setText(sonuc.get(2));
		lblsonuc_ikindi.setText(sonuc.get(3));
		lblsonuc_aksam.setText(sonuc.get(4));
		lblsonuc_yatsi.setText(sonuc.get(5));
		
		JLabel lblGithub = new JLabel("açýk kaynak");
		lblGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
						if(Desktop.isDesktopSupported())
						{
						  try {
							Desktop.getDesktop().browse(new URI("https://github.com/mcuneyda/namazvakti"));
						} catch (IOException | URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					
			}
		});
		lblGithub.setBackground(new Color(51, 204, 102));
		
	
		lblGithub.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGithub.setBounds(123, 433, 50, 14);
		getContentPane().add(lblGithub);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(76, 132, 83, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel vaktincikmasina = new JLabel("Vaktin \u00C7\u0131kmas\u0131na");
		vaktincikmasina.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vaktincikmasina.setBounds(76, 157, 97, 14);
		getContentPane().add(vaktincikmasina);
		
		JLabel vaktincikmasina_sure = new JLabel("New label2");
		vaktincikmasina_sure.setBounds(96, 182, 77, 14);
		getContentPane().add(vaktincikmasina_sure);
		
		JMenu mnNewMenu = new JMenu("Konum");
		mnNewMenu.setBounds(0, 0, 107, 22);
		getContentPane().add(mnNewMenu);
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				KonumSec konumum = null;
				try {
					konumum = new KonumSec();
				} catch (JsonIOException | JsonSyntaxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				konumum.setVisible(true);
			
					
			}
		});
		

	
		
		String imsakvaktiw = sonuc.get(0);
		String oglevaktis = sonuc.get(2);
		System.out.println("yatsivakti: " + oglevaktis);
		
		String imsakvaktisaniyeli = sonucsaniyeli.get(0);
		String sabahvaktisaniyeli = sonucsaniyeli.get(1);
		String oglevaktisaniyeli = sonucsaniyeli.get(2);
		String ikindivaktisaniyeli = sonucsaniyeli.get(3);
		String aksamvaktisaniyeli = sonucsaniyeli.get(4);
		String yatsivaktisaniyeli = sonucsaniyeli.get(5);
		
		String imsakvakti = sonuc.get(0);
		String sabahvakti = sonuc.get(1);
		String oglevakti = sonuc.get(2);
		String ikindivakti = sonuc.get(3);
		String aksamvakti = sonuc.get(4);
		String yatsivakti = sonuc.get(5);
		
		
		
		double imsakvakti_zaman = Double.parseDouble(sonuc.get(0).replaceAll(":","."));
		double sabahvakti_zaman = Double.parseDouble(sonuc.get(1).replaceAll(":","."));
		double oglevakti_zaman = Double.parseDouble(sonuc.get(2).replaceAll(":","."));
		double ikindivakti_zaman = Double.parseDouble(sonuc.get(3).replaceAll(":","."));
		double aksamvakti_zaman = Double.parseDouble(sonuc.get(4).replaceAll(":","."));
		double yatsivakti_zaman = Double.parseDouble(sonuc.get(5).replaceAll(":","."));
		
	  
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	      //getTime() returns the current date in default time zone
	      Date date = calendar.getTime();
	      int day = calendar.get(Calendar.DATE);
	      //Note: +1 the month for current month
	      int month = calendar.get(Calendar.MONTH) + 1;
	      int year = calendar.get(Calendar.YEAR);
	      int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	      int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	      int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
	    String yil = Integer.toString(year);
	    String ay = Integer.toString(month);
	    String gun = Integer.toString(day);





		
	
	
    	
		
	 
	             Timer kontrol=new Timer();
	             TimerTask gorev =new TimerTask() {
	 
	                    @Override
	                    public void run() {
	                   
	                        Date tarihsaat=new Date();

	   
	                        

	                   		Calendar calendar = Calendar.getInstance();
	                   		calendar.setTime(tarihsaat);
	                   		int hours = calendar.get(Calendar.HOUR_OF_DAY);
	                   		long minutes = calendar.get(Calendar.MINUTE);
	                   		int saniye = calendar.get(Calendar.SECOND);
	                   		
	                   		System.out.println();
	                   		
	              
	                   		String zat = hours + ":" + minutes + ":" + saniye;
	                   		String zat2 = hours + ":" + minutes;
	                   		System.out.println("þuan: " + zat);
	                  		double suanki_saatdakika = Double.parseDouble(zat2.replaceAll(":","."));
	   
							
							long imsakvaktihedef = tarihciktisi(imsakvaktisaniyeli,gun,ay,yil);
							Date imsakvaktidate = new Date(imsakvaktihedef);
							
							long sabahvaktihedef = tarihciktisi(sabahvaktisaniyeli,gun,ay,yil);
							Date sabakvaktidate = new Date(sabahvaktihedef);
							
							long oglevaktihedef = tarihciktisi(oglevaktisaniyeli,gun,ay,yil);
							Date oglevaktidate = new Date(oglevaktihedef);
							
							long ikindivaktihedef = tarihciktisi(ikindivaktisaniyeli,gun,ay,yil);
							Date ikindivaktidate = new Date(ikindivaktihedef);
							
							long aksamvaktihedef = tarihciktisi(aksamvaktisaniyeli,gun,ay,yil);
							Date aksamvaktidate = new Date(aksamvaktihedef);
							
							long yatsivaktihedef = tarihciktisi(yatsivaktisaniyeli,gun,ay,yil);
							Date yatsivaktidate = new Date(yatsivaktihedef);
							
							
							
							DateFormat dfwwa = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
							Date dateobj = new Date();
							String tasd  = dfwwa.format(dateobj);
							Date bugunkitarih = null;
							try {
								bugunkitarih = dfwwa.parse(tasd);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
							
							
		
							
							
							
						
							
							
							long imsakfarki =    imsakvaktidate.getTime() - bugunkitarih.getTime();
							long sabahfarki =    sabakvaktidate.getTime() - bugunkitarih.getTime();
							long oglefarki =    oglevaktidate.getTime() - bugunkitarih.getTime();
							long ikindifarki =    ikindivaktidate.getTime() - bugunkitarih.getTime();
							long aksamfarki =    aksamvaktidate.getTime() - bugunkitarih.getTime();
							long yatsifarki =    yatsivaktidate.getTime() - bugunkitarih.getTime();
							
							
							
					
							
						

	                        
			                String imsakvakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(imsakfarki),
			                    TimeUnit.MILLISECONDS.toMinutes(imsakfarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(imsakfarki)),
			                    TimeUnit.MILLISECONDS.toSeconds(imsakfarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(imsakfarki)));
			                
			                String sabahvakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(sabahfarki),
				                    TimeUnit.MILLISECONDS.toMinutes(sabahfarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(sabahfarki)),
				                    TimeUnit.MILLISECONDS.toSeconds(sabahfarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sabahfarki)));
			                
			                String oglevakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(oglefarki),
				                    TimeUnit.MILLISECONDS.toMinutes(oglefarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(oglefarki)),
				                    TimeUnit.MILLISECONDS.toSeconds(oglefarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(oglefarki)));
			                
			                String ikindivakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(ikindifarki),
				                    TimeUnit.MILLISECONDS.toMinutes(ikindifarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ikindifarki)),
				                    TimeUnit.MILLISECONDS.toSeconds(ikindifarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ikindifarki)));
			                
			                String aksamvakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(aksamfarki),
				                    TimeUnit.MILLISECONDS.toMinutes(aksamfarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(aksamfarki)),
				                    TimeUnit.MILLISECONDS.toSeconds(aksamfarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(aksamfarki)));
			                
			                String yatsivakti_kalanzaman = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(yatsifarki),
				                    TimeUnit.MILLISECONDS.toMinutes(yatsifarki) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(yatsifarki)),
				                    TimeUnit.MILLISECONDS.toSeconds(yatsifarki) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(yatsifarki)));
			                
			              
			                

	
							if(suanki_saatdakika < imsakvakti_zaman){
								 lblNewLabel_1.setText("Yatsi vakti");
								 vaktincikmasina_sure.setText(sabahvakti_kalanzaman);
								 System.out.println("Ýmsak:" + sabahvakti_kalanzaman);
							
								
								
							}else if(suanki_saatdakika < sabahvakti_zaman){
								lblNewLabel_1.setText("Imsak vakti");
								 vaktincikmasina_sure.setText(sabahvakti_kalanzaman);
								 System.out.println("Ýmsak:" + sabahvakti_kalanzaman);
								
						
							}else if(suanki_saatdakika < oglevakti_zaman){
								lblNewLabel_1.setText("Sabah vakti");
								 vaktincikmasina_sure.setText(oglevakti_kalanzaman);
								 System.out.println("Ogle:" + oglevakti_kalanzaman);
								
						
								
							}else if(suanki_saatdakika < ikindivakti_zaman){
								lblNewLabel_1.setText("Ögle vakti ");
								 vaktincikmasina_sure.setText(ikindivakti_kalanzaman);
								 System.out.println("Ýkindi:" + ikindivakti_kalanzaman);
								
						
								
							}else if(suanki_saatdakika < aksamvakti_zaman){
								lblNewLabel_1.setText("Ýkindi vakti ");
								 vaktincikmasina_sure.setText(aksamvakti_kalanzaman);
								 System.out.println("Ýmsak:" + aksamvakti_kalanzaman);
								
						
								
							}else if(suanki_saatdakika < yatsivakti_zaman){
								lblNewLabel_1.setText("Akþam vakti ");
								 vaktincikmasina_sure.setText(yatsivakti_kalanzaman);
								 System.out.println("Ýmsak:" + yatsivakti_kalanzaman);
								
						
							 }
							}
    	
	             };
	        	 
	             kontrol.schedule(gorev,0,1000);

		
	
		
		
	}
	
	
	public long tarihciktisi(String tarih,String gun, String ay, String yil){
		
		tarih = gun+ "/" + ay +"/" + yil +" " + tarih;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss", new Locale("tr"));
		
   		Date tarihfunc = null;


		try {
			tarihfunc = sdf.parse(tarih);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long tarihciktisi = tarihfunc.getTime();
		return tarihciktisi;
	}
	
	
	
	public ArrayList<String> namazvakticek(String ulkenum, String ilmid, String ilmceid) throws JsonIOException, JsonSyntaxException, IOException{
		System.out.println("ülkeid"+ ulkenum + "ilid" + ilmid + "ilçeid" + ilmceid);
			 String sURL = "http://www.namazvaktim.net/json/gunluk/"+ ilmid +".json"; //just a string

			    // Connect to the URL using java's native library
			    URL url = new URL(sURL);
			    HttpURLConnection request = (HttpURLConnection) url.openConnection();
			    request.addRequestProperty("User-Agent", 
					    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			    request.connect();

			    // Convert to a JSON object to print data
			    JsonParser jp = new JsonParser(); //from gson
			    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
			    JsonObject rootobjvakitler = rootobj.getAsJsonObject("namazvakitleri");
			    JsonObject rootobjzaman = rootobjvakitler.getAsJsonObject("zaman");
			    JsonObject rootobjvakitlers = rootobjzaman.getAsJsonObject("vakitler");
			    
			    
			    String imsak = rootobjvakitlers.get("imsak").getAsString(); //just grab the zipcode
			    String sabah = rootobjvakitlers.get("gunes").getAsString(); //just grab the zipcode
			    String ogle = rootobjvakitlers.get("ogle").getAsString(); //just grab the zipcode
			    String Ikindi = rootobjvakitlers.get("ikindi").getAsString(); //just grab the zipcode
			    String Aksam = rootobjvakitlers.get("aksam").getAsString(); //just grab the zipcode
			    String Yatsi = rootobjvakitlers.get("yatsi").getAsString(); //just grab the zipcode
			    String kible = rootobjvakitlers.get("kible").getAsString(); //just grab the zipcode
			    System.out.println(imsak + "asasdas");
			    
			  
			    
			    ArrayList<String> isimler = new ArrayList<String>();
			    
			    isimler.add(imsak);
			    isimler.add(sabah);
			    isimler.add(ogle);
			    isimler.add(Ikindi);
			    isimler.add(Aksam);
			    isimler.add(Yatsi);
			    
			/*    System.out.println("Sabah: " + sabah);
			    System.out.println("Ogle: " + ogle);
			    System.out.println("Ýkindi: " + Ikindi);
			    System.out.println("Akþam: " + Aksam);
		*/
			    return(isimler);
			  //  return new String[] {};
	
}
	
	public ArrayList<String> namazvakticek_saniyeli(String ulkeid,String ilsid, String ilcesid) throws JsonIOException, JsonSyntaxException, IOException{
		
		 String sURL = "http://www.namazvaktim.net/json/gunluk/"+ ilsid +".json"; //just a string

		 

		    // Connect to the URL using java's native library
		    URL url = new URL(sURL);
		    HttpURLConnection request = (HttpURLConnection) url.openConnection();
		    request.addRequestProperty("User-Agent", 
				    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		    request.connect();

		    // Convert to a JSON object to print data
		    JsonParser jp = new JsonParser(); //from gson
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
		    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
		    JsonObject rootobjvakitler = rootobj.getAsJsonObject("namazvakitleri");
		    JsonObject rootobjzaman = rootobjvakitler.getAsJsonObject("zaman");
		    JsonObject rootobjvakitlers = rootobjzaman.getAsJsonObject("vakitler");
		    
		    
		    String imsak = rootobjvakitlers.get("imsak").getAsString() + ":00"; //just grab the zipcode
		    String sabah = rootobjvakitlers.get("gunes").getAsString() + ":00";; //just grab the zipcode
		    String ogle = rootobjvakitlers.get("ogle").getAsString() + ":00";; //just grab the zipcode
		    String Ikindi = rootobjvakitlers.get("ikindi").getAsString() + ":00";; //just grab the zipcode
		    String Aksam = rootobjvakitlers.get("aksam").getAsString() + ":00";; //just grab the zipcode
		    String Yatsi = rootobjvakitlers.get("yatsi").getAsString() + ":00";; //just grab the zipcode
		    String kible = rootobjvakitlers.get("kible").getAsString() + ":00";; //just grab the zipcode
		    System.out.println(imsak + "asasdas");
		    
		    ArrayList<String> isimler = new ArrayList<String>();
		    
		    isimler.add(imsak);
		    isimler.add(sabah);
		    isimler.add(ogle);
		    isimler.add(Ikindi);
		    isimler.add(Aksam);
		    isimler.add(Yatsi);
		    
		/*    System.out.println("Sabah: " + sabah);
		    System.out.println("Ogle: " + ogle);
		    System.out.println("Ýkindi: " + Ikindi);
		    System.out.println("Akþam: " + Aksam);
	*/
		    return(isimler);
		  //  return new String[] {};

}
	

	
	
	
}

