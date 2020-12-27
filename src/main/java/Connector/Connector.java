package Connector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.util.*;

public class Connector {

    public  Connector(ConnectionDetails connectionDetails ){

        String SFTPHOST = connectionDetails.getHostName();
        int    SFTPPORT = connectionDetails.getPort();
        String SFTPUSER = connectionDetails.getUserName();
        String SFTPPASS = connectionDetails.getPassword();
        String SFTPWORKINGDIR = connectionDetails.getDirectory();
        String SFTPPRIVATEKEY = connectionDetails.getKey();

        Queue<String> queue = new LinkedList<>();

        Session session     = null;
        Channel channel     = null;
        ChannelSftp channelSftp = null;

        try {
            JSch jsch = new JSch();
            File privateKey = new File(connectionDetails.getKey());

            if(privateKey.exists() && privateKey.isFile()) {
                jsch.addIdentity(SFTPPRIVATEKEY);
            }

            session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
            session.setPassword(SFTPPASS);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;

            queue.add(SFTPWORKINGDIR);

            while (!queue.isEmpty()){

                String current = queue.poll();
                Vector<String> filelist = new Vector<String>();

                ChannelSftp.LsEntrySelector selector = new ChannelSftp.LsEntrySelector() {
                    public int select(ChannelSftp.LsEntry entry)  {
                        final String filename = entry.getFilename();
                        if (filename.equals(".") || filename.equals("..")) {
                            return CONTINUE;
                        }
                        if (entry.getAttrs().isLink()) {
                            filelist.addElement(filename);
                        }
                        else if (entry.getAttrs().isDir()) {
                            filelist.addElement(entry.getFilename());
                            queue.add(current + "/" + entry.getFilename());
                        }
                        else {
                            filelist.addElement(entry.getFilename());
                        }
                        return CONTINUE;
                    }
                };
                channelSftp.ls(current ,selector);
                for(int i=0; i<filelist.size();i++){

                    System.out.println(current + "/" + filelist.get(i).toString());
                }

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(session != null) session.disconnect();
            if(channel != null) channel.disconnect();
        }
    }
}
