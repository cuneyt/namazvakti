package NamazVakti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class KonumSec extends JFrame {

	private JPanel contentPane;
	private String ilce;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locale.setDefault(new Locale("tr","TR"));
					KonumSec frame = new KonumSec();
					frame.setVisible(true);
					frame.setTitle("Namaz Vakti");
					
					//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(NamazVakti.class.getResource("/img/1.png")));
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 */
	public KonumSec() throws JsonIOException, JsonSyntaxException, IOException {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 494);
		contentPane = new JPanel();
		contentPane.setSize(250, 500);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(51, 204, 102));
		contentPane.setBounds(100, 100, 269, 494);
		

		contentPane.setLayout(null);

		contentPane.setLayout(null);
		contentPane.setBackground(new Color(51, 204, 102));
		
		JTextPane txtpnIliniziSein = new JTextPane();
		txtpnIliniziSein.setText("\u0130linizi Se\u00E7in");
		txtpnIliniziSein.setBounds(81, 149, 86, 20);
		contentPane.add(txtpnIliniziSein);
		
		Map<String, String> sehirlerim = SehirCek("turkiyesse");
		
		
		
		
		Vector sehirmodeli = new Vector();
		

		for (Map.Entry<String, String> entry : sehirlerim.entrySet())
		{
			sehirmodeli.addElement( new Item(entry.getKey(), entry.getValue() ) );
		   
		    
		}
        
   
		/*String[] array = new String[Sehirler.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = (String) Sehirler.get(i);
		}*/
		
		JComboBox comboBox = new JComboBox(sehirmodeli);
		
		comboBox.setBounds(81, 180, 86, 20);
		contentPane.add(comboBox);
		
		
		
		JTextPane txtpnIleniziSein = new JTextPane();
		txtpnIleniziSein.setText("\u0130l\u00E7enizi Se\u00E7in");
		txtpnIleniziSein.setBounds(81, 235, 86, 20);
		contentPane.add(txtpnIleniziSein);
		
		
	////////////////////////////// ÝKÝNCÝ MODELE GÝRÝÞ
		
		
		
		ilce = "530";
		Vector ilcelermodeli = new Vector();
		JComboBox comboBox2 = new JComboBox(ilcelermodeli);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				JComboBox comboBox = (JComboBox)e.getSource();
		        Item item = (Item) comboBox.getSelectedItem();
		        ilce = (String) item.getId();
		        System.out.println("SEÇÝLÝ=== " + ilce);
		        
		        
		      //String ilcemid = Integer.toString(ilceid);
				Map<String, String> ilceler = null;
				try {
					ilceler = IlcelerCek(ilce);
				} catch (JsonIOException | JsonSyntaxException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				comboBox2.revalidate(); // for JFrame up to Java7 is there only validate()
				comboBox2.repaint();
				comboBox2.removeAllItems();
				ilcelermodeli.clear();
				for (Map.Entry<String, String> entry2 : ilceler.entrySet())
				{
					
					ilcelermodeli.addElement( new Item(entry2.getKey(), entry2.getValue() ) );
				   
					System.out.println("ÝLÇEMODELÝ: " +  ilcelermodeli + " : " + entry2.getKey() );
				}
			
			
				
				
		        
		     //   ilceid = (int) item.getId();
		        
			}
		});
		
		
		comboBox2.setBounds(81, 266, 86, 20);
		
		
		contentPane.add(comboBox2);
		
		//System.out.println("Ýlcem Ýd:" + ilcemid);
	
		
		
		int a = 50;
		for(int i = 0; i<a; i++) {
			String barkod = "A00";
			String artansayi = Integer.toString(i);
			barkod = barkod + artansayi;
			System.out.println(barkod);
		}
	
		
		comboBox2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Item item = (Item) comboBox.getSelectedItem();
				        Item item2 = (Item) comboBox2.getSelectedItem();
				        System.out.println( item2.getId() + " : " + item2.getDescription() );
				        String ilid = (String) item.getId();
				        String ilceid = (String) item2.getId();
						
						Vakitler konumum = null;
						try {
							
							konumum = new Vakitler(ilid,ilceid);
						} catch (JsonIOException | JsonSyntaxException | IOException | JavaLayerException | ParseException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						konumum.setVisible(true);
						setVisible(false);
					
					
						
				     //   ilceid = (int) item.getId();
				        
				}
			});
		
	
	
		
		
	}
	
	public Map<String, String> SehirCek(String il_num) throws JsonIOException, JsonSyntaxException, IOException{
		
		 String sURL = "http://www.namazvaktim.net/json/sehirler/turkiye.json"; //just a string

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
		    JsonArray rootobjcity = rootobj.getAsJsonArray("cities");
		   
		  
			 Map<String, String> teamMap = new HashMap<>();
			 
			 
			 
		    for(int i =0; i < rootobjcity.size(); i++) {
		    	JsonObject jsonobjesi;
		    	jsonobjesi = rootobjcity.get(i).getAsJsonObject();
		    	 String SehirAdi = jsonobjesi.get("name").getAsString(); //just grab the zipcode
		    	 String SehirId = jsonobjesi.get("url").getAsString(); //just grab the zipcode
		    	 
		    	 
		    	 teamMap.put(SehirId,SehirAdi);
		    }
		   
		    teamMap.put("DenemeÞehir","001");
		    return(teamMap);
	}	
	
	public Map<String, String> IlcelerCek(String ilce_num) throws JsonIOException, JsonSyntaxException, IOException{
		
		// String sURL = "http://cuneydanlayisli.com/namaz2/index.php?islem=getIlceList&sehir_id="+ilce_num; //just a string
		 String sURL = "http://www.namazvaktim.net/json/ilceler/turkiye/"+ ilce_num +".json"; //just a string
		 System.out.println(sURL);

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
		    JsonArray rootobjilce = rootobj.getAsJsonArray("towns");
		
	
		    
		    
			 Map<String, String> teamMap = new HashMap<>();
		
		    for(int i =0; i < rootobjilce.size(); i++) {
		    	JsonObject jsonobjesi;
		    	jsonobjesi = rootobjilce.get(i).getAsJsonObject();
		    	 String IlceAdi = jsonobjesi.get("name").getAsString(); //just grab the zipcode
		    	 String IlceId = jsonobjesi.get("url").getAsString(); //just grab the zipcode
		    	 IlceAdi.toUpperCase( new Locale("tr","TR") );
		    	 IlceAdi = IlceAdi.replace("ý", "i");
		    	 IlceAdi = IlceAdi.replace("ö", "o");
		    	 IlceAdi = IlceAdi.replace("ü", "u");
		    	 IlceAdi = IlceAdi.replace("þ", "s");
	                IlceAdi = IlceAdi.replace("ð", "g");
	                IlceAdi = IlceAdi.replace("ç", "c");
	                IlceAdi = IlceAdi.replace("Ü", "U");
	                IlceAdi = IlceAdi.replace("Ý", "I");
	                IlceAdi = IlceAdi.replace("Ö", "O");
	                IlceAdi = IlceAdi.replace("Ü", "U");
	                IlceAdi = IlceAdi.replace("Þ", "S");
	                IlceAdi = IlceAdi.replace("Ð", "G");
	                IlceAdi = IlceAdi.replace("Ç", "C");
		    	 System.out.println("ÝlçeAdIM: " + IlceAdi);
		    	 
		    	 teamMap.put(IlceId,IlceAdi);
		    	 
		    }
		   
		    teamMap.put("DenemeÞehir","001");
		    return(teamMap);


	}
	
	class Item{
		private String description;
		private Object id;
		private int idm;
		
		public Item(Object object, String description)
        {
            this.id = object;

            this.description = description;
        }

        public Object getId()
        {
            return id;
        }

        public String getDescription()
        {
            return description;
        }

        public String toString()
        {
            return description;
        }
	}

}


