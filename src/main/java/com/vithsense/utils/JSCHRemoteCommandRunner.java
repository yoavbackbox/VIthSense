package com.vithsense.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.vithsense.pojos.Command;

public class JSCHRemoteCommandRunner {


    public void executeRemoteCommand() {
        try {
            System.out.println("Executing command");
            String command = "ls -la";
            String host = "172.31.254.75";
            String user = "root";
            String password = "1";

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);;
            session.setPassword(password);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream input = channel.getInputStream();
            channel.connect();

            System.out.println("Channel Connected to machine " + host + " server with command: " + command );

            try {
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
                bufferedReader.close();
                inputReader.close();
            } catch(IOException ex) {
                System.out.println(ex.getMessage());

                ex.printStackTrace();
            }

            channel.disconnect();
            session.disconnect();
        } catch(Exception ex) {
            System.out.println("ERROR WHIle Executing command");
            System.out.println(ex.getMessage());


            ex.printStackTrace();
        }
    }
}



