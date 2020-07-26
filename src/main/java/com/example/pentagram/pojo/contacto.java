package com.example.pentagram.pojo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pentagram.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Para ir a Gmail y usar el correo por defecto
    public void SendMensaje(View view){
        final EditText etto = this.findViewById(R.id.etCorreo);
        final EditText etmensaje = this.findViewById(R.id.etMensaje);
        Button boton = (Button) this.findViewById(R.id.btnEnviar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String esubject = "EJEMPLO ANDROID - G";
                Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+etto.getText().toString()));
                inten.putExtra(Intent.EXTRA_SUBJECT,esubject);
                inten.putExtra(Intent.EXTRA_TEXT,etmensaje.getText().toString());
                startActivity(inten);
            }
        });
    }

    //Enviar desde el app, dando acceso de uso a terceros a tu cuenta
    public void EnviarMensaje(View view){
        final EditText etto = (EditText) this.findViewById(R.id.etCorreo);
        final EditText etnom = (EditText) this.findViewById(R.id.etNombre);
        final EditText etmensaje = (EditText) this.findViewById(R.id.etMensaje);
        Button send = (Button) this.findViewById(R.id.btnEnviar);
        send.setOnClickListener(new View.OnClickListener() {

            //Darse permiso por gmail para enviar y poner credenciales
            final String correo = "";
            final String clave = " ";
            public void onClick(View v) {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.googlemail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correo,clave);
                    }
                });
                if (session!=null){
                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("G - EJEMPLO ANDROID");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(etto.getText().toString().trim()));
                        message.setContent(etmensaje.getText().toString().trim(),"text/html; charset=utf-8");

                        //Transport.send(message);
                        new SendEmail().execute(message);

                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    private class SendEmail extends AsyncTask<Message,String,String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(contacto.this,"Por favor Espere","Enviando Esto",true,false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "EXITO";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "ERROR";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("EXITO")){

                AlertDialog.Builder builder = new AlertDialog.Builder(contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Exito</font>"));
                builder.setMessage("Mensaje enviado");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }else{
                Toast.makeText (contacto.this,"Algo salio  mal",Toast.LENGTH_SHORT ).show ();
            }
        }
    }
}