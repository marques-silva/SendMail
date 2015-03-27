package com.marques.sendmail;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
 
public class AutomaticEmailActivity extends Activity {
	private Mail m;
	/** Called when the activity is first created. */
	@Override 
	public void onCreate(Bundle icicle) { 
	  super.onCreate(icicle); 
	 
	 setContentView(R.layout.main);
	  Button addImage = (Button) findViewById(R.id.send_email); 
	  addImage.setOnClickListener(new View.OnClickListener() { 
	    public void onClick(View view) { 
	      //Mail m = new Mail("evaneide.marques@cleversystems.com.br", "clever369*"); 
	       m = new Mail("email","senha*"); 
	      Log.i("script","log 1");
	      String[] toArr = {"email destinatario"}; 
	      m.setTo(toArr); 
	      m.setFrom("email que esta enviando"); 
	      m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device."); 
	      m.setBody("Email body."); 
	      Log.i("script","antes do try activity");
	      try { 
	        m.addAttachment("/sdcard/brao.jpg"); 
	    	  //String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	    	 // m.addAttachment(path+"/brao.jpg");
	        if(m.send()) { 
	          Toast.makeText(AutomaticEmailActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
	          Log.i("script","enviou email");
	        } else { 
	        	 Log.i("script","não enviou email");
	          Toast.makeText(AutomaticEmailActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
	        } 
	      } catch(Exception e) { 
	        //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
	        Log.e("script", "Could not send email-: "+e); 
	      } 
	    } 
	  }); 
	}} 