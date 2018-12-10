package SocketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		final int puerto = 9999;
		byte[] buffer = new byte[1024];

		try {
			System.out.println("Iniciado el servidor UDP");
			DatagramSocket socketUDP = new DatagramSocket(puerto);
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

			while (true) {
				socketUDP.receive(peticion);
				System.out.println("Recibo la información del cliente");
				String mensaje = new String(peticion.getData());
				System.out.println(mensaje);

				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();

				mensaje = "¡Hola mundo desde el servidor";
				buffer = mensaje.getBytes();

				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

				System.out.println("Envio la informacion del cliente");
				socketUDP.send(respuesta);
			}

		} catch (SocketException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
