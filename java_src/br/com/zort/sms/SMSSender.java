package br.com.zort.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSSender {

	public SMSSender() {
	}

	public static void send(String cellphoneNumber, String message) throws Exception {

		boolean debug = true;

		URL u = new URL( "http://api.clickatell.com/http/sendmsg" );

		HttpURLConnection uc = (HttpURLConnection) u.openConnection();
		uc.setDoOutput( true );
		uc.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
		uc.setRequestMethod( "POST" );

		String query = "";

		query += "user=" + URLEncoder.encode( "mobdoc", "UTF-8" );
		query += "&password=" + URLEncoder.encode( "mobdoc#3", "UTF-8" );
		query += "&api_id=" + "3194622";
		query += "&to=" + "55" + cellphoneNumber;
		query += "&text=" + URLEncoder.encode( StringUtils.removeAcentos( message ), "UTF-8" );

		PrintWriter pw = new PrintWriter( uc.getOutputStream() );
		pw.println( query );
		pw.close();

		BufferedReader in = new BufferedReader( new InputStreamReader( uc.getInputStream() ) );
		String res = in.readLine();
		in.close();

		if ( res.indexOf( "ID:" ) == -1 || res.length() != 36 ) {
			throw new Exception( "Não foi possível enviar esse SMS! Por favor, tente mais tarde." );
		} else {
			if ( debug ) {
				System.out.println( res );
			}
		}

	}

}
