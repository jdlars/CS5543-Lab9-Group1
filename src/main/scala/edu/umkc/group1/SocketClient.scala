package edu.umkc.group1

import java.io.{IOException, PrintStream}
import java.net.{InetAddress, Socket}

/**
 * Created by Mayanka on 10-Sep-150.
 * Used by Jordan Larson on 23-Sep-2015
 */
object SocketClient {

  def findIpAdd():String =
  {
    val localhost = InetAddress.getLocalHost
    val localIpAddress = localhost.getHostAddress

    return localIpAddress
  }
  def sendCommandToRobot(string: String)
  {
    // Simple server

    try {


      lazy val address: Array[Byte] = Array(10.toByte, 205.toByte, 2.toByte, 163.toByte)
      val ia = InetAddress.getByAddress(address)
      val socket = new Socket(ia, 1234)
      val out = new PrintStream(socket.getOutputStream)
      //val in = new DataInputStream(socket.getInputStream())

      out.print(string)
      out.flush()

      out.close()
      //in.close()
      socket.close()
    }
    catch {
      case e: IOException =>
        e.printStackTrace()
    }
  }


}
