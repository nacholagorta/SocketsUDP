package SocketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		final int puerto_servidor = 9999;
		byte[] buffer = new byte[1024];
		
		try {
			
			InetAddress direccionServidor = InetAddress.getByName("localhost");
			
			
			DatagramSocket socketUDP = new DatagramSocket();

			String mensaje = "¡Hola mundo desde el cliente!";
			buffer = mensaje.getBytes();
			
			DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor,puerto_servidor );
			
			System.out.println("Envio el datagrama");
			socketUDP.send(pregunta);
			
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			
			socketUDP.receive(peticion);
			System.out.println("Envio peticion");
			mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			socketUDP.close();
			
		} catch (SocketException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

}
