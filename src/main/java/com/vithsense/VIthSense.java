package com.vithsense;

import com.vithsense.utils.JSCHRemoteCommandRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class VIthSense {
    private static final Logger logger = LogManager.getLogger(VIthSense.class);

    public static void main(String[] args) {
        System.out.println("NIGGGASAAAAA!!!!!!!!!!");
        ProcessBuilder processBuilder = new ProcessBuilder();

        logger.info("running command");
        processBuilder.command("bash", "-c", "echo hello;");

        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch(Exception e) {
            logger.error(e.getMessage());
        }

        JSCHRemoteCommandRunner commandRunner = new JSCHRemoteCommandRunner();

        commandRunner.executeRemoteCommand();

        logger.info("finished");

        System.out.println("bitch!!!!!!!!!!");


    }
}
