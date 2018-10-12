package com.wux.rcb.elf.biz.common;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(SocketClient.class);
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    /**
     * 同步阻塞读取
     * */
    public String read(String destIp, int port, String reqMsg) {
        String retLine = null;
        try {
            socket = new Socket(destIp, port);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println(reqMsg);
            retLine = bufferedReader.readLine();
            logger.info("socketClient retLine is {}", retLine);
        } catch (Exception e) {
            logger.error("Socket read error ! {} ", destIp + ":" + port, e);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.error("Socket close error ", e);
            }
        }
        return retLine;
    }
}
