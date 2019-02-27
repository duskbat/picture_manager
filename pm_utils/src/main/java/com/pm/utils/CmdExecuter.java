package com.pm.utils;

/**
 * Created by Administrator on 2017/12/29 0029.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CmdExecuter {
    public static String exec(List<String> cmd) {
        String converted_time = null;
        Process proc =null;
        BufferedReader stdout = null;
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(cmd);
            builder.redirectErrorStream(true);
            proc = builder.start();
            stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            int lineNumber=1;
            List<String> returnStringList = new LinkedList<String>();
            while ((line = stdout.readLine()) != null) {
                System.out.println("第"+lineNumber+"行:"+line);
                lineNumber=lineNumber+1;
                returnStringList.add(FFMPEG.dealString(line));
            }
            String info = "";
            for (int i = returnStringList.size() - 1; i >= 0; i--) {
                if (null != returnStringList.get(i) && returnStringList.get(i).startsWith("frame=")) {
                    info = returnStringList.get(i);
                    break;
                }
            }
            if (null != info) {
                converted_time = info.split("time=")[1].split("bitrate=")[0].trim();
            }
        } catch (IndexOutOfBoundsException ex) {
            converted_time = null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                proc.waitFor();
                stdout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return converted_time;
    }


}
